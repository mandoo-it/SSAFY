package com.object;
//class설계(틀 구조 설계도) 자체로 실행은 안되지만 다른 클래스에서 가져다 쓸 수 있다. 
public class Car {
		// TODO Auto-generated method stub

		//전역변수  data.field.member.field는 초기화 안해도  기본값이 들어가있다. 
		int num;//0
		String model;//null
		String owner;//null
		boolean flag;//false
		double d;//0.0
		
		//constructer.생성자.객체가 생성이 될 때 자동으로 실행되는 메소드
		//조건 : 메소드이름이 클래스이름과 동일하고 리턴타입은 없다
		//default 생성자(파라메터가 없는 생서자)
		//생성자 오버로딩
		Car(){
			this(0);//생성자 안에서만 사용 가능하고 다른 생성자 호출
		}
		Car(int num) {
//			this.num = num;
			this(num, "xby");
		}
		Car(int num, String model) {
//			this.num = num;
//			this.model = model;
			this(num, model, "anonymous");
			
		}
		Car(int num, String model, String owner) {
			this.num = num;
			this.model = model;
			this.owner = owner;
				}
		//method
		void run() {
			//지역 변수 //int code 지역변수는 반드시 사용 전에 반드시 초기화가 되어있어야한다.;
			int code;
			System.out.println("run method...");
		}
		//method overloading:한 클래스 안에서 동일한 이름의 메소드가 여러번 나오는 경우
		//반드시 파라메터 부분이 달라야한다. 
		void run(String msg) {
			//지역 변수 //int code 지역변수는 반드시 사용 전에 반드시 초기화가 되어있어야한다.;
			System.out.println(msg);
		}
		void stop() {
			System.out.println("stop method..");
		}
		void info() {
			System.out.println("num:" + num);
			System.out.println("model:" + model);
			System.out.println("owner:" + owner);
		}
		
		public static void main(String[] args) {
			Car c = new Car(7899, "avante", "jane");
			c.num = 9999;
		}
}
