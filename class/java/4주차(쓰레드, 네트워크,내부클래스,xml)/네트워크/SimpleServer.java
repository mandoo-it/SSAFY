package com.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Server 프로그램 : 클라이언트의 접속을 받고 메세지 전송
//1. ServerSocket 생성
//2. accept() : 클라이언트 접속을 기다렸다가 받음
//3. Socket으로부터 입출력 스트림 얻어냄
//4. 메세지 전송
//5. 마무리 : close()
public class SimpleServer {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server;
		Socket s;//접속해 들어온 client
		OutputStream out;
		DataOutputStream dos;
		InputStream in;
		DataInputStream dis;
		
		String msg = "hello, network..소켓프로그래밍";
		server = new ServerSocket(3000);
		
		while(true) {
			System.out.println("클라이언트를 기다리는 중...");
			s = server.accept(); //block되는 특징. 클라이언트가 접속해 올때까지 멈춰있음
			System.out.println("클라이언트 접속!");
			
			out = s.getOutputStream();//클라이언트한테 입출력 작업해야되니까
			dos = new DataOutputStream(out);//filter stream.byte stream
			in = s.getInputStream();
			
			dis = new DataInputStream(in);
			dos.writeUTF(msg);//한글처리
			String result = dis.readUTF();
			System.out.println(result);
			
			dos.close();
			out.close();
			dis.close();
		
			in.close();
			s.close();
		}
		
	}

}
