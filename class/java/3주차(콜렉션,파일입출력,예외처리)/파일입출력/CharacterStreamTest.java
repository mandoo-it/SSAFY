package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				File f = File.createTempFile("sample", "txt"); //tempfile을 만들어준다. 
				System.out.println(f);
				
				//file에 쓰기(16-36)
				FileWriter fw = new FileWriter(f); //fos랑 같은 역할 node stream
				BufferedWriter bw = new BufferedWriter(fw);//한번에 한글자가 아니라 버퍼사이즈 만큼 읽고 쓴다 새로운 파이프 //filter stream
				//bw는 필터라서 일반 스트림이 하는 작업을 받아서 추가 작업한다. 
				bw.write("hello");
				bw.write("hello2");
				bw.write("깨지냐?");
				bw.write("hello4");
				bw.newLine();
				
				bw.close();
				fw.close();
				
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				for(String s;(s = br.readLine()) != null;) { //br은 1줄씩 읽어 들일 수 있다. 
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
