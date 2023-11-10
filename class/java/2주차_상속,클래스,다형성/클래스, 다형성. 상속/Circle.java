package com.object;

public class Circle {
	int r;

	public Circle() {
		this(0);
	}
	public Circle(int r) {
		this.r = r;
	}
	double getArea() {
		return r*r*3.14;
	}
	double getCircum() {
		return 2*r*3.14;
	}
	
	
}
