package com.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Doc {
	public Document getDoc() throws ParserConfigurationException, SAXException, IOException{
		ClassLoader classLoader = Doc.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("Musics.xml");
		
		
		//File fXmlFile = new File("D:\\Musics.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(is);
		doc.getDocumentElement().normalize();
		return doc;
	}
}
