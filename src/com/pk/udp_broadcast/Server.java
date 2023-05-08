package com.pk.udp_broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        ds.receive(dp);

        byte[] data = dp.getData();
        int length = dp.getLength();
        System.out.println(new String(data,0,length));
        ds.close();
    }
}
