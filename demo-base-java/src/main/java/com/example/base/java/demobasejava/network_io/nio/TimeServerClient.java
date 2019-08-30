package com.example.base.java.demobasejava.network_io.nio;

public class TimeServerClient {

    public static void main(String[] args) {
        int port = 8080; //服务端默认端口
        new Thread(new TimeClientHandler("127.0.0.1", port), "NIO-TimeServerClient-001").start();
    }
}
