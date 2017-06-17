package com.Timmy.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPclient {

	public static void main(String[] args) throws IOException {
           //1.定义服务端的端口号，ip地址，数据
		InetAddress in =InetAddress.getLocalHost();
		int port=8800;
		byte[] data="用户名：admin;密码：12356".getBytes();
		//创建数据包，并发送信息；
		DatagramPacket packet=new DatagramPacket(data, data.length, in, port);
		//创建Datasocket对象发送报文
		DatagramSocket socket=new DatagramSocket();//本机端口不需要绑定
		socket.send(packet);
		
		
		
	    //接收服务端信息
			//创建服务端DatagramSocket实例，并绑定端口
	
			
			//由于本机有默认端口号，所以不想要绑定
			
			//创建数据报，用于接收客户端并发送数据
			byte[] bytes=new byte[1024];//字节数组，指定其大小
			DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
			//接收客户端发送的数据
		 socket.receive(datagramPacket);
			
			//读取数据
			String info =new String(bytes,0,datagramPacket.getLength());
			System.out.println("我是客户端，服务端说："+info);
			socket.close();
		
	}

}
