package com.di.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("paris")
public class ParisZoo implements zoo {
	//@Autowired
	//@Qualifier("tigers")
	List<Tiger> tigers;//2마리
	//@Autowired
	//@Qualifier("lions")
	List<Lion> lions;//2마리
	
	public void setTigers(List<Tiger> tigers) {
		this.tigers = tigers;
	}
	
	public void setLions(List<Lion> lions){
		this.lions = lions;
	}
	@Override
	public void info() {
		for(Tiger t: tigers)
			t.info();
		for(Lion l: lions)
			l.info();
		
	}

}
