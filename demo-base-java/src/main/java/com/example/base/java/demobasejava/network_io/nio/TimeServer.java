package com.example.base.java.demobasejava.network_io.nio;

public class TimeServer {

    public static void main(String[] args) {
        int port = 8080; //服务端默认端口
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
