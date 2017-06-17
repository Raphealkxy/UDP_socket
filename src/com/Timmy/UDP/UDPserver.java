package com.Timmy.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class UDPserver {

	public static void main(String[] args) throws IOException {
            
		//���������DatagramSocketʵ�������󶨶˿�
		DatagramSocket datagramSocket=new DatagramSocket(8800);
		
		
		//�������ݱ������ڽ��տͻ��˲���������
		byte[] bytes=new byte[1024];//�ֽ����飬ָ�����С
		DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
		//���տͻ��˷��͵�����
		datagramSocket.receive(datagramPacket);
		
		//��ȡ����
		String info =new String(bytes,0,datagramPacket.getLength());
		System.out.println("���Ƿ���ˣ��ͻ���˵��"+info);
		
		//��Ӧ�ͻ���
        //1.�������˵Ķ˿ںţ�ip��ַ������
		InetAddress in =datagramPacket.getAddress();
		int port=datagramPacket.getPort();
		byte[] data="���Ƿ���ˣ���ӭ��".getBytes();
		//�������ݰ�����������Ϣ��
		DatagramPacket packet=new DatagramPacket(data, data.length, in, port);
		//����Datasocket�����ͱ���
		DatagramSocket socket=new DatagramSocket();
		socket.send(packet);
		socket.close();
	}

}
