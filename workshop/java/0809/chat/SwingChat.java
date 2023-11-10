package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingChat {
		private JFrame f;
		private JTextArea ta;
		private JScrollPane sp;
		private JTextField tf;
		private JPanel p;
		private JButton s;
		private JButton e;
		
		private SwingChat() { //객체는 생성자에서 주로 초기화한다. 
			f = new JFrame("ChatingCilent");
			ta = new JTextArea("서버전송성공!\n");
			sp = new JScrollPane(ta);
			tf = new JTextField();
			s = new JButton("send");
			e = new JButton("exit");
			p = new JPanel();
			
		}
		private void addEvent() {
			ActionListener al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ta.append(tf.getText() + "\n");
					ta.setCaretPosition(ta.getDocument().getLength());//자동으로 스크롤링
					tf.setText("");
					tf.requestFocus();
				}
			};
//			b.addActionListener(al);
//			s.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					ta.append(tf.getText() + "\n");
//					ta.setCaretPosition(ta.getDocument().getLength());//자동으로 스크롤링
//					tf.setText("");
//					tf.requestFocus();
//				}
//			});
			tf.addActionListener(al);
			s.addActionListener(al);
			e.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					f.dispose();
//					System.exit(0);
				}});
		}
		private void display() {
			//flow layout
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container cp = f.getContentPane();
			
			ta.setEditable(false);
			cp.add(sp, "Center");
			
			p.setLayout(new GridLayout(10,1));
			p.add(s);
			p.add(e);
			cp.add(p, "East");
			cp.add(tf, "South");
			
			f.setSize(500,400);
			f.setVisible(true);
			tf.requestFocus();
		}
		
		public static void main(String[] args) {
			SwingChat gui = new SwingChat();
			gui.display();
			gui.addEvent();
		}
	}

