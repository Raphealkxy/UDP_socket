package com.Timmy.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPclient {

	public static void main(String[] args) throws IOException {
           //1.�������˵Ķ˿ںţ�ip��ַ������
		InetAddress in =InetAddress.getLocalHost();
		int port=8800;
		byte[] data="�û�����admin;���룺12356".getBytes();
		//�������ݰ�����������Ϣ��
		DatagramPacket packet=new DatagramPacket(data, data.length, in, port);
		//����Datasocket�����ͱ���
		DatagramSocket socket=new DatagramSocket();//�����˿ڲ���Ҫ��
		socket.send(packet);
		
		
		
	    //���շ������Ϣ
			//���������DatagramSocketʵ�������󶨶˿�
	
			
			//���ڱ�����Ĭ�϶˿ںţ����Բ���Ҫ��
			
			//�������ݱ������ڽ��տͻ��˲���������
			byte[] bytes=new byte[1024];//�ֽ����飬ָ�����С
			DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
			//���տͻ��˷��͵�����
		 socket.receive(datagramPacket);
			
			//��ȡ����
			String info =new String(bytes,0,datagramPacket.getLength());
			System.out.println("���ǿͻ��ˣ������˵��"+info);
			socket.close();
		
	}

}
