package com.object;
class Employee{
	int num;
	String name;
	int salary;
	
	//생성자
	
	double getBonus() {
		return salary * 0.2;
	}

	public Employee(int num, String name, int salary) {
		this.num = num;
		this.name = name;
		this.salary = salary;
	}
}
public class Manager extends Employee{

	public Manager(int num, String name, int salary, int deptcode) {
		super(num, name, salary);//부모의 생성자 호출
		this.deptcode = deptcode;
		// TODO Auto-generated constructor stub
	}
    
	@Override
	double getBonus() {
		// TODO Auto-generated method stub
		return salary * 0.3;
	}

	int deptcode;//부서코드
	
	public static void main(String[] args) {
	
	}
}
