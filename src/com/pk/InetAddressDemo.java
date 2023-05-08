package com.pk;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    /*
    static InetAddress getByName(String host)  确定主机的IP地址.主机名称可以是机器名称,也可以是IP地址
    String getHostName()            获取此IP地址的主机名
    String getHostAddress()         返回文本显示中的IP地址字符串
     */
    public static void main(String[] args) throws UnknownHostException {
        //IP的对象  一台电脑的对象
//        InetAddress address = InetAddress.getByName("192.168.110.74");
        InetAddress address = InetAddress.getByName("PKBook1");

        String name = address.getHostName();

        String ip = address.getHostAddress();

        System.out.println("主机名: "+name);
        System.out.println("ip地址: "+ip);
    }
}
