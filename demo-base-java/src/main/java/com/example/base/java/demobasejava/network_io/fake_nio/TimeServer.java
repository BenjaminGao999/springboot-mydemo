package com.example.base.java.demobasejava.network_io.fake_nio;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class TimeServer {
    public static void main(String[] args) {
        int port=8080; //服务端默认端口
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:"+port);
            Socket socket = null;
            //通过线程池的方式维护所有的IO线程，实现相对高效的线程开销及管理
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);

            while(true){
                socket = server.accept();
//                new Thread(new TimeServerHandler(socket)).start();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server!=null){
                System.out.println("The time server is close.");
                try {
                    server.close();
                    server = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
