package com.inner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AnomyousTest {
	public void test(Runnable r) {
		System.out.println("test");
	}
	public void test2(ActionListener a) {
		System.out.println("test2");
	}
	public void test3(MouseListener m) {
		System.out.println("test3");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnomyousTest a = new AnomyousTest();
		a.test(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Dd");
			}
		});
		
		a.test2(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		a.test3(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
