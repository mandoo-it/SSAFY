package com.ssafy;
class DuplicateException extends Exception
{
	@Override
    public String toString() {
        return "이미 존재하는 상품입니다.";
    }
}

@SuppressWarnings("serial")
class CodeNotFoundException extends Exception
{	public CodeNotFoundException() {
		//super();                                                                                 
	}
//	public CodeNotFoundException(String string) {
//	// TODO Auto-generated constructor stub
//		super(string);
//}
	
//	@Override
//	public String toString() {
//		return "해당하는 상품 번호가 존재하지 않습니다. ";
//	}
	
}
@SuppressWarnings("serial")
class ProductNotFoundException extends Exception
{
	public ProductNotFoundException() {
		//super("ProductNotFoundException");
	}
//		public ProductNotFoundException(String string) {
//		// TODO Auto-generated constructor stub
//			super(string);
//	}
	
//	@Override
//	public String toString() {
//		return "해당하는 상품이 없습니다.";
//	}
//	
}
public class MyException{
}

