package com.ssafy;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class BookServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server;
		Socket s;//접속해 들어온 client
		InputStream in;
		ObjectInputStream ois;
		
		String msg = "hello, network..소켓프로그래밍";
		server = new ServerSocket(6000);
		
		System.out.println("클라이언트를 기다리는 중...");
		s = server.accept(); //block되는 특징. 클라이언트가 접속해 올때까지 멈춰있음
		System.out.println("클라이언트 접속!");
		

		in = s.getInputStream();
		
		ois = new ObjectInputStream(in);
		List<Book> result = (List<Book>) ois.readObject();
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
		ois.close();
		in.close();
		s.close();
	}
}
