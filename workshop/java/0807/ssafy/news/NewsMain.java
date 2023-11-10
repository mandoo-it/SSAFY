package com.ssafy.news;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame f;
	JButton b;
	JList li;
	JTextArea ta;
	NewsDAOImpl dao;

	public NewsMain() {
		dao = dao.getInstance();
		createGUI(); // 화면 만드는 메소드
		addEvent(); // 이벤트 처리를 위한 메소드
		// showList();
	}

	public void createGUI() {
		f = new JFrame("NewsList");
		JPanel p = new JPanel();
		b = new JButton("News List 호출");

		li = new JList();
		ta = new JTextArea("");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b, "North");
		p.add(li);
		f.setLayout(new GridLayout(2, 1, 5, 5));
		f.add(p);
		f.add(ta);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});

		li.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				News n = (News) li.getSelectedValue();
				if (n != null)
					ta.setText(n.getDesc() + "\n" + n.getLink());
			}
		});
	}

	// dao의 메소드 호출해서 데이터 받아온 후에 그 결과를 화면 (JList)에 뿌려주기
	public void showList() {
		java.util.List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		li.setListData(datas.toArray());
	}

	public static void main(String[] args) {
		new NewsMain();
	}

}
