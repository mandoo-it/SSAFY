package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CardSave {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Card 객체를 생성해서 스트림을 통해 이동시켜 파일에 저장
		Card c1 = new Card(1234, "윤규희", "하나");
		Card c2 = new Card(4225, "김하나", "국민");
		
		//File에 저장
		FileOutputStream fos = new FileOutputStream("card.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		
		oos.close();
		fos.close();
		
		//file에서 불러오기
		FileInputStream fis = new FileInputStream("card.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		//Card c = (Card)ois.readObject();
		for(String s;(s = ois.readLine()) != null;) { //br은 1줄씩 읽어 들일 수 있다. 
			System.out.println(s);
		}
	//	ois.readLine(br)
//		System.out.println(c.getCompany());
//		System.out.println(c.getName());
//		System.out.println(c.getNum());
//		
		ois.close();
		fis.close();
	}

}
