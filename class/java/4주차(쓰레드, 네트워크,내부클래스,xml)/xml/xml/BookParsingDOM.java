package com.xml;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookParsingDOM {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();//dom parser
		
		Document doc = parser.parse("xml/book.xml");//parsing
	
		NodeList list = doc.getElementsByTagName("title");
		NodeList list2 = doc.getElementsByTagName("author");
		
		for(int i=0;i<list.getLength();i++) {
			Node each = list.item(i);
			Node each2 = list2.item(i);
			Node child = each.getFirstChild();
			Node child2 = each2.getFirstChild();
			System.out.println(child.getNodeValue() + " "+child2.getNodeValue());
			
		}
		
	}
}
