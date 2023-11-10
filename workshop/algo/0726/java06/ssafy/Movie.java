package com.ssafy;

public class Movie {

	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;
	
	public Movie(String title, String director, int grade, String genre, String summary) {
		setTitle(title);
		setDirector(director);
		setGrade(grade);
		setGenre(genre);
		setSummary(genre);
	}

	public Movie() {
		this(null,null,0,null,null);
	}

	public Movie(String title, String director, int grade, String genre) {
		setTitle(title);
		setDirector(director);
		setGrade(grade);
		setGenre(genre);
		setSummary(null);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
		.append("영화 제목 : ").append(title)
		.append("  영화 감독 : ").append(director)
		.append("  영화 등급 : ").append(grade)
		.append("  영화 장르 : ").append(genre);
		if(summary != null)
			builder.append("  영화 줄거리 : ").append(summary);
		return builder.toString();
	}	
}
