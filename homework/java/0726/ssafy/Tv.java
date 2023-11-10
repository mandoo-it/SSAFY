package com.ssafy;

public class Tv extends Product{
	private int inch;
	private String display;
	public Tv(int sn, String name, int price, int stock, int inch, String display) {
		super(sn, name, price, stock);
		this.inch = inch;
		this.display = display;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	@Override
	public String toString() {
		return super.toString() + "  |  " + inch + "  |  " + display;
	}


}
