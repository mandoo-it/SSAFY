package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent2 implements ActionListener {
		private JFrame f;
		private JButton b;
		
		private SwingEvent2() { //객체는 생성자에서 주로 초기화한다. 
			f = new JFrame("SwingEvent");
			b = new JButton("ok");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton)e.getSource();
			b.setBackground(Color.green);
			System.out.println("performed~" + b.getText());
		}
		
		private void addEvent() {
			b.addActionListener(this);
		}
		
		private void display() {
			//flow layout
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(new FlowLayout()); //항상 버튼 생긴 순서대로 가운데 정렬
			f.getContentPane().setBackground(Color.orange);
		//	f.setLayout(new GridLayout(3,3));
			//f.setBackground(new Color(33,44,33));
			f.add(b);

		
//			Border Layout
//			f.add(b);
//			f.add(b2,"North");
//			f.add(b3,"South");
//			f.add(b4,"West");
			f.setSize(300,300);
			f.setVisible(true);
		}
		
		public static void main(String[] args) {
			SwingEvent2 gui = new SwingEvent2();
			gui.display();
			gui.addEvent();
		}
	}

