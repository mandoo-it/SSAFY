package com.thread;

class Matrix extends Thread{
	int num;//자기가 맡은 단의 값

	public Matrix(int num) {
		this.num = num;
	}
	public void run() { //쓰레드가 수행하는 메소드
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i++) {
			System.out.print(num + " * " + i + " = " + (i * num)+"\t");
		}
		System.out.println();
		
	}
	
}

public class MatrixTest{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method
		for(int i=2;i<=9;i++) {
			Matrix m = new Matrix(i);
			m.start();
			m.join();
		}
		

	}

	

}
