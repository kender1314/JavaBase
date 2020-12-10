package com.java.learn.telnet;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;

public class TelnetClientMain {
//    public static void main(String[] args) throws IOException {
//        System.out.println("结果：" + ssss());
//    }
//
//
//    private static String ssss() throws IOException {
//        TelnetClient telnetClient = new TelnetClient("vt200"); //指明Telnet终端类型，否则会返回来的数据中文会乱码
//        telnetClient.setDefaultTimeout(5000); //socket延迟时间：5000ms
//        telnetClient.connect("192.168.59.100", 23); //建立一个连接,默认端口是23
//        InputStream inputStream = telnetClient.getInputStream(); //读取命令的流
//        PrintStream pStream = new PrintStream(telnetClient.getOutputStream()); //写命令的流
//        byte[] b = new byte[1024];
//        int size;
//        StringBuilder sBuffer = new StringBuilder(300);
//        while (true) { //读取Server返回来的数据，直到读到登陆标识，这个时候认为可以输入用户名
//            try {
//                size = inputStream.read(b);
//            }catch (Exception e){
//                break;
//            }
//
//            sBuffer.append(new String(b, 0, size));
//        }
//        return sBuffer.toString().trim().replace("\r\n", "<br>");
//
//    }

    public static void main(String[] args) throws SocketException, IOException {
        TelnetClient telnetClient=new TelnetClient("VT200"); //指明Telnet终端类型，否则会返回来的数据中文会乱码
        telnetClient.setDefaultTimeout(5000); //socket延迟时间：5000ms
//        telnetClient.connect("2001:da8:207::1180", 23); //建立一个连接,默认端口是23
        telnetClient.connect("192.168.59.100", 23); //建立一个连接,默认端口是23
        InputStream inputStream=telnetClient.getInputStream(); //读取命令的流
        PrintStream pStream=new PrintStream(telnetClient.getOutputStream()); //写命令的流
        byte[] b=new byte[1024];
        int size;
        StringBuffer sBuffer=new StringBuffer(300);
        while(true){ //读取Server返回来的数据，直到读到登陆标识，这个时候认为可以输入用户名
            size=inputStream.read(b);
            if(-1 != size){
                sBuffer.append(new String(b,0,size));
                if(sBuffer.toString().trim().endsWith("login:")){
                    break;
                }
            }
        }
        System.out.println(sBuffer.toString());
        pStream.print("exit"); //写命令
        pStream.flush(); //将命令发送到telnet Server
        if(null != pStream){
            pStream.close();
        }
        telnetClient.disconnect();
    }

}