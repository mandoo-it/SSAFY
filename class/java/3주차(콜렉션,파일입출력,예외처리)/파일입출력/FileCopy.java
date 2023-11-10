package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args)  {	
		
		try {
			String origin = "src\\com\\io\\FileCopy.java";//원본
			String copy = "src\\com\\exception\\FileCopy.java";//복사본 파일
			
			FileInputStream fis;//파일 내용을 읽어오는 스트림
			FileOutputStream fos;//파일에 내용을 쓰는 스트림
			fis = new FileInputStream(origin);
			fos = new FileOutputStream(copy);
			
			//fis.read() : fis로 파일에서 한글자 읽어냄, 파일의 끝을 만나면 -1 리턴 // 1글자씩 주면서 읽을 게 있으면 1 return
			for(int i;(i = fis.read()) != -1;) {
				System.out.println(i);
				fos.write(i);
			}
			fis.close();
			fos.close();
			System.out.println("finish...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*	// TODO Auto-generated method stub
	System.out.println("jell");
	System.err.println("kii");
	try {
		int a = System.in.read();
		//System.in.read();//표준 입력 , 키보드로부터 한글자 입력 받음
		System.out.println(a);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}
