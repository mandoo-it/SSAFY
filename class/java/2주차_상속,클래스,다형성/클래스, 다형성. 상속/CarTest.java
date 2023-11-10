package com.object;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button b = new Button("456");
		Button cancel = new Button("cancel");
		Checkbox ch1 = new Checkbox();
		Checkbox ch2 = new Checkbox("one");
		Checkbox ch3 = new Checkbox("two", true);
		
		
		Frame f = new Frame("객체 생성 테스트");//창 윈도우
		f.setLayout(new FlowLayout());
		f.add(b);//버튼 추가
		f.add(cancel);
		f.add(ch1);
		f.add(ch2);
		f.add(ch3);
		f.setSize(300,300);
		f.setVisible(true);//눈에 보이게 해준다
		Car c1 = new Car();
		//객체사용
		c1.num = 1234;
		c1.model = "avante";
		c1.owner = "kim";
		
	    Car c2 = new Car();
	    Car c3 = new Car(1989);

	}

}
