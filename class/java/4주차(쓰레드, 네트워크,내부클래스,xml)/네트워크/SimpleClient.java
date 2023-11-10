package com.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//Client 프로그램 : 서버의 접속을 받고 메세지 받음
//1. Socket 생성(ip, port)
//2. Socket으로부터 입출력 스트림 얻어냄
//3. 메세지 전송
//4. 마무리 : 소켓, close()
public class SimpleClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s;
		InputStream in;
		DataInputStream dis;
		OutputStream out;
		DataOutputStream dos;
		String msg = "그만잘래.....?";
		s = new Socket("70.12.108.173",3000); //loopback Address
		in = s.getInputStream();
		dis = new DataInputStream(in);
		out = s.getOutputStream();//클라이언트한테 입출력 작업해야되니까
		dos = new DataOutputStream(out);//filter stream.byte stream
	
		String result = dis.readUTF();
		System.out.println(result);
		dos.writeUTF(msg);//한글처리
		dis.close();
		in.close();
		s.close();
		
	}

}
