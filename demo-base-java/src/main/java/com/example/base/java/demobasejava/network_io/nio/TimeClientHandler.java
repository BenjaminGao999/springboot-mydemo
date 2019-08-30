package com.example.base.java.demobasejava.network_io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lgs
 */
public class TimeClientHandler implements Runnable {

    private String host;
    private int port;
    private SocketChannel socketChannel;
    private Selector selector;
    private volatile boolean stop;

    public TimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            //客户端打开一个通道SocketChannel
            socketChannel = SocketChannel.open();
            //创建Selector(多路复用器)线程
            selector = Selector.open();
            //设置为非阻塞模式
            socketChannel.configureBlocking(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            //连接服务端并发送数据
            doConnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        //处理服务端响应的数据,和服务端处理客户端发送的数据一样
        while (!stop) {
            //轮训通道的状态
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    //取到key以后就移出，避免重复取
                    iterator.remove();
                    try {
                        //处理服务端响应的数据
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        if (selectionKey != null) {
                            selectionKey.cancel();
                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理服务端响应的数据
     *
     * @param selectionKey
     * @throws Exception
     */
    private void handleInput(SelectionKey selectionKey) throws Exception {
        if (selectionKey.isValid()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();
            if (selectionKey.isConnectable()) {
                if (client.finishConnect()) {
                    client.register(selector, SelectionKey.OP_READ);
                    doWrite(client);
                } else {
                    System.exit(1);
                }
            }
            if (selectionKey.isReadable()) {
                ByteBuffer receivebuffer = ByteBuffer.allocate(1024);
                int count = client.read(receivebuffer);
                if (count > 0) {
                    receivebuffer.flip();
                    byte[] bytes = new byte[receivebuffer.remaining()]; //remaining()方法
                    receivebuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is " + body);
                    this.stop = true;
                } else if (count < 0) {
                    selectionKey.channel();
                    client.close();
                } else {

                }
            }
        }
    }

    /**
     * 连接服务端并发送数据
     *
     * @throws Exception
     */
    private void doConnect() throws Exception {
        //连接服务端
        boolean connect = socketChannel.connect(new InetSocketAddress(host, port));
        //判断是否连接成功，如果连接成功，则监听Channel的读状态。
        if (connect) {
            //连接成功就把客户端的通道注册到多路复用器上，并设置通道状态为可读
            socketChannel.register(selector, SelectionKey.OP_READ);
            //写数据  写给服务端
            doWrite(socketChannel);
        } else {
            //如果没有连接成功，则向多路复用器注册Connect(可连接)状态
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }

    }

    /**
     * 写数据  写给服务端
     *
     * @param channel
     * @throws IOException
     */
    private void doWrite(SocketChannel channel) throws IOException {
        ByteBuffer sendbuffer = ByteBuffer.allocate(1024);
        sendbuffer.put("QUERY TIME ORDER".getBytes());
        sendbuffer.flip();
        //向Channel中写入客户端的请求指令  写到服务端 写到通道里面
        channel.write(sendbuffer);
        if (!sendbuffer.hasRemaining()) {
            System.out.println("Send order to server succeed.");
        }
    }
}
