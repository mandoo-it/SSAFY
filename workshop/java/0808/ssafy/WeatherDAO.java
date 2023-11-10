package com.ssafy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {
ArrayList<Weather> nlist;
	private static WeatherDAO instance = new WeatherDAO();
	
	private WeatherDAO() {
		nlist = new ArrayList<>();
	}
	//3.singleton 
	public static WeatherDAO getInstance() {
		return instance;
	}
	
	//1. 전달된 url에 접속해서 xml문서 받아오기
	//2. xml문서 파싱하기
	//3. 원하는 엘리먼트 찾아서 vo에 담기
	//4. vo를 list에 담아서 리턴
	public List<Weather> getNewsData(String url) {
		// TODO Auto-generated method stub
		nlist.clear();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(url);
			
			NodeList list = doc.getElementsByTagName("data");
			
			for(int i=0;i<list.getLength();i++) {
				Node item = list.item(i);//기사 1건 정보
				NodeList child = item.getChildNodes();//member 한 사람의 자식 모두
				System.out.println(child.getLength());
				Weather n = new Weather();//vo작성
				
				for(int j=0;j<child.getLength();j++) {
					Node one = child.item(j);//자식 중 한개 추출
					String name = one.getNodeName();
					System.out.println(name);
					if(name.equals("hour")) {
						n.setHour(Integer.parseInt(one.getFirstChild().getNodeValue()));
					}
					if(name.equals("wfKor")) {
						System.out.println(one.getFirstChild().getNodeValue());
						n.setWfkor((one.getFirstChild().getNodeValue()));
						
					}
					if(name.equals("temp")) {
						n.setTemp(Double.parseDouble(one.getFirstChild().getNodeValue()));
					}
					if(name.equals("reh")) {
						n.setReh(Integer.parseInt(one.getFirstChild().getNodeValue()));
						System.out.println(one.getFirstChild().getNodeValue());
					}
					
					
					if(n.getHour() != 0 && n.getTemp() != 0 && n.getReh() != 0 && n.getWfkor() != null) {
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
}
