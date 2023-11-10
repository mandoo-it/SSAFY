package com.object;

//부모클래스, super, base, parent 클래스
class Parent{
	String name = "tom";
	String address = "seoul";
	
	String getName() {
		return name;
	}
	String getAddress() {
		return address;
	}
	
	Parent() {
		System.out.println("부모 생성자");
	}
	

	
	
}

//자식클래스, sub, derived, child 클래스
public class Child extends Parent{
	String email = "jjj@naver.com";
	Child() {
		System.out.println("child 생성자");
	}
	void callSuper() {
		System.out.println(super.getName());
	}
	//method overriding:상속받은 메소드 중 자식 클래스에 맞게 재정의 하는 일
	//리턴타입, 메소드이름, 파라미터가 동일해야함
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성 : 생성된 객체에 대해 다양한 타입으로 나타낼 수 있다. 
		//method가 overriding되면 자식꺼까지 내려올 수 있다. 
		//원칙상으로 타입을 parent로 하면 child객체를 만들었다고해도 CHILD부분으로 내려올 수 없다
		//overriding만 메소드만 가능
		Parent c = new Parent();
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		//static method안에서는 this, super키워드를 사용 할 수 없음
		//System.out.println(super.getName());
		
		//형변환 - parent타입이었는데 callsuper()를 부르려면 자식이여야하니까 자식으로 형변환후 부름
		Child c2 = (Child) c;
		c2.callSuper();//tom
		//부모로부터 overriding된 함수가 아니라서 에러난다c.go();
	}

	//@: annotation(단순히 정보제공)
	@Override
	String getName() {
		return "son";
	}

}
