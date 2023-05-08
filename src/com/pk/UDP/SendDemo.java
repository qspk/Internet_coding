package com.pk.UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象(DatagramSocket)
        //DatagramSocket() 构造数据报套接字并将其绑定到本地主机上的任何可用端口
        DatagramSocket ds = new DatagramSocket();

        //创建数据并把数据打包
        //DatagramPacket(byte[] buf,int length,InetAddress address,int port)
        byte[] bys = "hello,udp,我来了".getBytes(StandardCharsets.UTF_8);

        DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("localhost"), 10086);

        //调用DatagramSocket对象的方法发送数据
        //void send(DatagramPacket p)从此套接字发送数据
        ds.send(dp);
        //关闭发送端
        ds.close();
    }
}
