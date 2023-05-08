package com.pk.UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //接受数据

        //1.创建DataGramSocket对象(快递公司)
        //接受数据时一定要绑定端口 且与发送端口保持一致
        DatagramSocket ds = new DatagramSocket(10086);

        //2.接受数据包
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        //该方法是阻塞的
        //程序执行到这一步时,会在这里死等
        //等发送端发送消息
        ds.receive(dp);

        //3.解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        System.out.println("数据来自 " + address + "  " + port);
        System.out.println("数据是: " + new String(dp.getData(), 0, dp.getLength()));

        //4.释放资源
    }
}
