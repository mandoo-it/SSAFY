package com.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MemberParsingDOM {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		
		Document doc = parser.parse("xml/member.xml");
		NodeList list = doc.getElementsByTagName("member");
		for(int i=0;i<list.getLength();i++) {
			Node member = list.item(i);//member 한 사람
			NodeList child = member.getChildNodes();//member 한 사람의 자식 모두
			
			for(int j=0;j<child.getLength();j++) {
				Node one = child.item(j);//자식 중 한개 추출
				String name = one.getNodeName();
				
				if(name.equals("name")) {
					System.out.print(one.getFirstChild().getNodeValue()+" ");
				}
				
				if(name.equals("address")) {
					System.out.println(one.getFirstChild().getNodeValue());
				}
			}
		}
	}

}
