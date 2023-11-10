package com.object;

public class BonusTest {
	void printBonus(Employee who) {
		System.out.println(who.getBonus());
	}

	public static void main(String[] args) {
		//자식은 부모타입이다. 
		Employee tom = new Employee(123, "tom kim", 5000);
		Manager bill = new Manager(587, "billjone",7000,100);
		
		BonusTest bt = new BonusTest();
		//내영물은 매니저인데 타입은 더 큰 부모그릇이까 매니저의 겟보너스함수가와야한다.
		bt.printBonus(bill);
	}
}
