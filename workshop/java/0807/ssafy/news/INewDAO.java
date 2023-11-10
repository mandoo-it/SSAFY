package com.ssafy.news;

import java.util.List;

public interface INewDAO {
	List<News> getNewsList(String url);
	News search(int index);
	
}
