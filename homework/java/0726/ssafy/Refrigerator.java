package com.ssafy;

public class Refrigerator extends Product{
	private int volume;
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Refrigerator(int sn, String name, int price, int stock, int volume) {
		super(sn, name, price, stock);
		this.volume = volume;
	}

	@Override
	public String toString() {
		return super.toString() +"  |  " + volume;
	}
	
	
	
}
