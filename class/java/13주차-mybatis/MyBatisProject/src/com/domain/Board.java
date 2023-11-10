package com.domain;

public class Board {
	// filed 7개
	private String num, pass, name, wdate, title, content;
	private int count;

	// getter, setter
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		//System.out.println(num);
		this.num = num;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		//System.out.println(pass);
		this.pass = pass;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		//System.out.println(name);
		this.name = name;
	}

	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		//System.out.println(title);
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	// 생성자(default생성자 parameter 7개 생성자)
	public Board() {
		//System.out.println("default");
	}
	
	public Board(String num, String pass, String name, String wdate,
			String title, String content, int count) {
		this.num = num;
		this.pass = pass;
		this.name = name;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.count = count;
	}

	// toString()
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [num=").append(num).append(", pass=").append(pass)
				.append(", name=").append(name).append(", wdate=").append(wdate)
				.append(", title=").append(title).append(", content=")
				.append(content).append(", count=").append(count).append("]");
		return builder.toString();
	}

}
