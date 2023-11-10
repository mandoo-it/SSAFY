package com.ssafy.news;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




public class NewsDAOImpl implements INewDAO{
	ArrayList<News> nlist;
	private static NewsDAOImpl instance = new NewsDAOImpl();
	
	private NewsDAOImpl() {
		nlist = new ArrayList<>();
	}
	//3.singleton 
	public static NewsDAOImpl getInstance() {
		return instance;
	}
	public List<News> getNewsList(String url) {
		// TODO Auto-generated method stub
		nlist.clear();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(url);
			NodeList list = doc.getElementsByTagName("item");
			
			for(int i=0;i<list.getLength();i++) {
				Node item = list.item(i);//기사 1건 정보
				NodeList child = item.getChildNodes();//member 한 사람의 자식 모두
				News n = new News();//vo작성
				
				for(int j=0;j<child.getLength();j++) {
					Node one = child.item(j);//자식 중 한개 추출
					String name = one.getNodeName();
					
					if(name.equals("title")) {
						n.setTitle(one.getFirstChild().getNodeValue());
					}
					if(name.equals("description")) {
						System.out.println(one.getFirstChild().getNodeValue());
						n.setDesc(one.getFirstChild().getNodeValue());
						
					}
					if(name.equals("link")) {
						n.setLink(one.getFirstChild().getNodeValue());
					}					
					
					if(n.getTitle() != null && n.getLink() != null && n.getDesc() != null) {
						nlist.add(n);
						break;
					}
					
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nlist;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return nlist.get(index);
	}
}
