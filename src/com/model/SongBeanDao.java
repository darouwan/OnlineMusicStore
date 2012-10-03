package com.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SongBeanDao {

	
	public static SongBean getSongBean(String title) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath
				.compile("//Album/SongsList/Song[Title='" + title + "']/Title/text()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;
		expr = xpath.compile("//Album/SongsList/Song[Title='" + title + "']/Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album/SongsList/Song[Title='" + title + "']/Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

/*		expr = xpath.compile("//Album/SongsList/Song[contains(Title,'" + title
				+ "')]/ancestor::Album/Title/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList albumTitleList = (NodeList) result;*/
		// ---------------------------

		String albumTitle = "";
		SongBean sb = new SongBean();
		for (int i = 0; i < 1; i++) {
			
			String songTitle = titleList.item(i).getTextContent();
			
			System.out.println("-----------");
			System.out.println("songTitle=" + songTitle);

			String songPrice = priceList.item(i).getTextContent();
			System.out.println("songPrice=" + songPrice);

			String songArtist = artistList.item(i).getTextContent();
			System.out.println("songArtist=" + songArtist);

			
			expr = xpath.compile("//Album/SongsList/Song[Title='" + title + "']/ancestor::Album/Album_Title/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList albumTitleList = (NodeList) result;
			albumTitle=albumTitleList.item(0).getTextContent();

			System.out.println("albumTitle=" + albumTitle);

			sb.setTitle(songTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);
			sb.setAlbumTitle(albumTitle);

			//al.add(sb);

		}
		return sb;
	}
	
	public ArrayList<SongBean> searchByYear(String year)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Album_Title/text()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		//String albumTitle = "";
		for (int i = 0; i < titleList.getLength(); i++) {
			SongBean sb = new SongBean();
			String songTitle = titleList.item(i).getTextContent();
			al.addAll(this.getSongsListByAlbum(songTitle));
		}

		return al;
	}
	
	
	public ArrayList<SongBean> searchByGenre(String genre)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Album_Title/text()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		//String albumTitle = "";
		for (int i = 0; i < titleList.getLength(); i++) {
			SongBean sb = new SongBean();
			String songTitle = titleList.item(i).getTextContent();
			al.addAll(this.getSongsListByAlbum(songTitle));
		}

		return al;
	}

	public ArrayList<SongBean> searchByArtist(String artist)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath
				.compile("//Album/SongsList/Song[contains(Artist,'" + artist
						+ "')]/Title/node()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;
		expr = xpath.compile("//Album/SongsList/Song[contains(Artist,'"
				+ artist + "')]/Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album/SongsList/Song[contains(Artist,'"
				+ artist + "')]/Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album/SongsList/Song[contains(Artist,'"
				+ artist + "')]/ancestor::Album/Album_Title/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList albumTitleList = (NodeList) result;
		// ---------------------------

		String albumTitle = "";
		for (int i = 0; i < titleList.getLength(); i++) {
			SongBean sb = new SongBean();
			String songTitle = titleList.item(i).getTextContent();
			System.out.println("songTitle=" + songTitle);

			String songPrice = priceList.item(i).getTextContent();
			System.out.println("songPrice=" + songPrice);

			String songArtist = artistList.item(i).getTextContent();
			System.out.println("songArtist=" + songArtist);

			if (albumTitleList.item(i) != null) {
				albumTitle = albumTitleList.item(i).getTextContent();
			}
			System.out.println("albumTitle=" + albumTitle);

			sb.setTitle(songTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);
			sb.setAlbumTitle(albumTitle);

			al.add(sb);

		}
		return al;

	}

	public ArrayList<SongBean> searchByTitle(String title)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath
				.compile("//Album/SongsList/Song[contains(Title,'" + title
						+ "')]/Title/node()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;
		expr = xpath.compile("//Album/SongsList/Song[contains(Title,'" + title
				+ "')]/Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album/SongsList/Song[contains(Title,'" + title
				+ "')]/Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

/*		expr = xpath.compile("//Album/SongsList/Song[contains(Title,'" + title
				+ "')]/ancestor::Album/Title/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList albumTitleList = (NodeList) result;*/
		// ---------------------------

		String albumTitle = "";
		for (int i = 0; i < titleList.getLength(); i++) {
			SongBean sb = new SongBean();
			String songTitle = titleList.item(i).getTextContent();
			System.out.println("-----------");
			System.out.println("songTitle=" + songTitle);

			String songPrice = priceList.item(i).getTextContent();
			System.out.println("songPrice=" + songPrice);

			String songArtist = artistList.item(i).getTextContent();
			System.out.println("songArtist=" + songArtist);

			
			expr = xpath.compile("//Album/SongsList/Song[Title='" + songTitle + "']/ancestor::Album/Album_Title/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList albumTitleList = (NodeList) result;
			albumTitle=albumTitleList.item(0).getTextContent();

			System.out.println("albumTitle=" + albumTitle);

			sb.setTitle(songTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);
			sb.setAlbumTitle(albumTitle);

			al.add(sb);

		}
		return al;

	}

	static public ArrayList<SongBean> getSongsListByAlbum(String title)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		// TODO Auto-generated method stub
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[Album_Title='" + title
				+ "']/SongsList/Song/Title/node()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[Album_Title='" + title
				+ "']/SongsList/Song/Price/node()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[Album_Title='" + title
				+ "']/SongsList/Song/Artist/node()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album[Album_Title='" + title + "']/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album[Album_Title='" + title + "']/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album[Album_Title='" + title + "']/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList genreList = (NodeList) result;
		String genre = genreList.item(0).getTextContent();

		for (int i = 0; i < titleList.getLength(); i++) {
			String songTitle = titleList.item(i).getTextContent();
			String songPrice = priceList.item(i).getTextContent();
			String songArtist = artistList.item(i).getTextContent();

			System.out.println(songTitle);
			System.out.println(songPrice);
			System.out.println(songArtist);
			System.out.println(title);

			SongBean sb = new SongBean();
			sb.setTitle(songTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);
			sb.setGenre(genre);
			sb.setPublisher(publisher);
			sb.setYear(year);
			sb.setAlbumTitle(title);
			al.add(sb);
		}

		return al;
	}

}
