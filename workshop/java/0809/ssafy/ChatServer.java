package com.ssafy;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class UserInfo {
	private String ip;
	private String nick;
	private PrintWriter pw;
	private ObjectInputStream ois;

	UserInfo(String ip, String nick, PrintWriter pw, ObjectInputStream ois) {
		this.ip = ip;
		this.nick = nick;
		this.pw = pw;
		this.ois = ois;
	}

	public String getIp() {
		return ip;
	}

	public String getNick() {
		return nick;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

}

class ServerThread extends Thread {
	private UserInfo user;
	private ArrayList<UserInfo> li;

	public ServerThread(UserInfo user, ArrayList<UserInfo> li) {
		this.user = user;
		this.li = li;
	}

	public void run() {
		try {
			while (true) {
				String msg = (String) user.getOis().readObject();
				for (UserInfo u : li) {
					u.getPw().println("[" + user.getNick() + "] " + msg);
					u.getPw().flush();
				}
			}
//                pw.close();
//                ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ChatServer {
	private ArrayList<UserInfo> li = new ArrayList<UserInfo>();

//	public UserInfo findUser(String ip) {
//		for (UserInfo u : li)
//			if (u.getIp().equals(ip))
//				return u;
//		return null;
//	}

	public void connect() {
		try {
			ServerSocket ss = new ServerSocket(8000);
			while (true) {
				Socket s = ss.accept();
				System.out.println("클라이언트 연결");
				//System.out.println(s.getInetAddress());
				String ip = s.getInetAddress()+"";
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));

				//UserInfo user = findUser(ip);
				System.out.println("클라이언트 연결");
				//if (user == null) {
					pw.println("채팅방에 참여할 닉네임을 입력해주세요.");
					pw.flush();
					String nick = (String) ois.readObject();
					UserInfo user = new UserInfo(ip, nick, pw, ois);
					li.add(user);
				

				for (UserInfo u : li) {
					u.getPw().println("[" + user.getNick() + "] 님이 입장하셨습니다.");
					pw.flush();
				}
				new ServerThread(user, li).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.connect();
	}
}