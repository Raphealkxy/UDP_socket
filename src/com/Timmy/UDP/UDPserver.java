package com.Timmy.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class UDPserver {

	public static void main(String[] args) throws IOException {
            
		//创建服务端DatagramSocket实例，并绑定端口
		DatagramSocket datagramSocket=new DatagramSocket(8800);
		
		
		//创建数据报，用于接收客户端并发送数据
		byte[] bytes=new byte[1024];//字节数组，指定其大小
		DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
		//接收客户端发送的数据
		datagramSocket.receive(datagramPacket);
		
		//读取数据
		String info =new String(bytes,0,datagramPacket.getLength());
		System.out.println("我是服务端，客户端说："+info);
		
		//回应客户端
        //1.定义服务端的端口号，ip地址，数据
		InetAddress in =datagramPacket.getAddress();
		int port=datagramPacket.getPort();
		byte[] data="我是服务端，欢迎您".getBytes();
		//创建数据包，并发送信息；
		DatagramPacket packet=new DatagramPacket(data, data.length, in, port);
		//创建Datasocket对象发送报文
		DatagramSocket socket=new DatagramSocket();
		socket.send(packet);
		socket.close();
	}

}
