package com.object;

public class React {
	int width;
	int height;
	
	double getArea( ) {
		return width * height;
	}
	double getCircum() {
		return 2 * (width + height);
	}
	public React() {
	}
	public React(int width, int height) {
		this.width = width;
		this.height = height;
	}

}
