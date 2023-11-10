package com.exception;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] msg = {"go", "stop", "hello", "bye", "seeyou"};
		
		for(int i=0; i <= msg.length;i++) {
			try {
				System.out.println(msg[i]);//예외 발생할 가능성이 있는 문장
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("sorry..");
				//System.out.println(e);
				e.printStackTrace();
			}finally {//예외가 나던 안나던 공통적으로 계속 실행하는 부분
				System.out.println("finally");
			}
		}
		System.out.println("finished...");

	}

}
