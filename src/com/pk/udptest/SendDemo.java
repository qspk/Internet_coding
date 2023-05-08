package com.pk.udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            if ("886".equals(s)) {
                break;
            }
            byte[] bys = s.getBytes(StandardCharsets.UTF_8);
            DatagramPacket dp = new DatagramPacket(bys, bys.length,
                    InetAddress.getByName("localhost"), 12345);
            ds.send(dp);
        }
        ds.close();
    }
}
