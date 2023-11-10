package chat;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread{
	private ObjectInputStream ois;
	private PrintWriter pw;
	
	public ServerThread(ObjectInputStream ois,PrintWriter pw) {
		this.ois=ois;
		this.pw=pw;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String msg=(String)ois.readObject();
				System.out.println(msg);
				
				pw.println(msg);
				pw.flush();
			}
			//pw.close();
			//ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(8888);
			while(true) {
				System.out.println("ready...");
				Socket s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
				new ServerThread(ois,pw).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





















