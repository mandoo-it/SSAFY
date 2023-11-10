package com.exception;
//ArrayIndexOutofBoundesexeption, nullpointerexception, arithmeticeException (Runtime Exception)
public class NumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Truck t = null;
		int a = 8, b = 0;
		int result;
		try{
			result = a / b;
			System.out.println(result);
//		}catch(ArithmeticException e){
//			result = -99999;
//			System.out.println(e.toString());
//			System.out.println(result);
//		}
		}catch(Exception e){ // execption 통틀어서 가져와 안에서 나누게
			result = -99999;
			System.out.println(e.toString());
			System.out.println(result);
		}
		
		

	}

}
