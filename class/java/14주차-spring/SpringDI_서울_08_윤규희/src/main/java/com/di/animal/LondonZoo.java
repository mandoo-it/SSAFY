package com.di.animal;

public class LondonZoo implements zoo{
	private Tiger tiger;
	private Lion lion;
	
	@Override
	public void info() {
		lion.info();
		tiger.info();
		
	}

	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}

	public void setLion(Lion lion) {
		this.lion = lion;
	}

}
