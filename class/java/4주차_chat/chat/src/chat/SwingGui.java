package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingGui {
	private JFrame f;
	private JButton b;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	
	private SwingGui() { //객체는 생성자에서 주로 초기화한다. 
		f = new JFrame("SwingGui");
		b = new JButton("ok");
		b2 = new JButton("b2");
		b3 = new JButton("b3");
		b4 = new JButton("b4");
	}
	
	private void display() {
		//flow layout
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	f.setLayout(new FlowLayout()); //항상 버튼 생긴 순서대로 가운데 정렬
		f.setLayout(new GridLayout(3,3));
		f.setBackground(new Color(33,44,33));
		f.add(b);
		f.add(b2);
		f.add(b3);
		f.add(b4);
	
//		Border Layout
//		f.add(b);
//		f.add(b2,"North");
//		f.add(b3,"South");
//		f.add(b4,"West");
		f.setSize(300,300);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingGui gui = new SwingGui();
		gui.display();
	}
}
