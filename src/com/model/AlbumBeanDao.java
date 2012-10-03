package com.model;

import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

/**
 * @author CJF
 * 
 */
public class AlbumBeanDao {


	
	public ArrayList<AlbumBean> searchByTitle(String title) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		// TODO Auto-generated method stub
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Album_Title,'"
				+ title + "')]/Album_Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Title,'"
				+ title + "')]/Album_Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Title,'"
				+ title + "')]/Album_Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Title,'"
				+ title + "')]/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		// String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Album_Title,'"
				+ title + "')]/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		// String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Album_Title,'"
				+ title + "')]/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList genreList = (NodeList) result;

		for (int i = 0; i < titleList.getLength(); i++) {
			AlbumBean ab = new AlbumBean();
			String albumTitle = titleList.item(i).getTextContent();
			String albumPrice = priceList.item(i).getTextContent();
			String albumArtist = artistList.item(i).getTextContent();
			String albumPublisher = publisherList.item(i).getTextContent();
			String albumYear = yearList.item(i).getTextContent();
			String albumGenre = genreList.item(i).getTextContent();

			System.out.println(albumTitle);
			System.out.println(albumPrice);
			System.out.println(albumArtist);
			System.out.println(albumPublisher);
			System.out.println(albumYear);
			System.out.println(albumGenre);

			ab.setTitle(albumTitle);
			ab.setPrice(Float.parseFloat(albumPrice));
			ab.setAlbumArtist(albumArtist);
			ab.setPublisher(albumPublisher);
			ab.setYear(albumYear);
			ab.setGenre(albumGenre);
			ab.setImg();

			System.out.println(ab.getImg());

			al.add(ab);

		}
		return al;
	}
	
	public ArrayList<AlbumBean> searchByArtist(String artist)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Album_Artist,'"
				+ artist + "')]/Album_Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Artist,'" + artist
				+ "')]/Album_Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Artist,'" + artist
				+ "')]/Album_Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Artist,'" + artist
				+ "')]/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		// String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Album_Artist,'" + artist
				+ "')]/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		// String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Album_Artist,'" + artist
				+ "')]/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList genreList = (NodeList) result;

		for (int i = 0; i < titleList.getLength(); i++) {
			AlbumBean ab = new AlbumBean();
			String albumTitle = titleList.item(i).getTextContent();
			String albumPrice = priceList.item(i).getTextContent();
			String albumArtist = artistList.item(i).getTextContent();
			String albumPublisher = publisherList.item(i).getTextContent();
			String albumYear = yearList.item(i).getTextContent();
			String albumGenre = genreList.item(i).getTextContent();

			System.out.println(albumTitle);
			System.out.println(albumPrice);
			System.out.println(albumArtist);
			System.out.println(albumPublisher);
			System.out.println(albumYear);
			System.out.println(albumGenre);

			ab.setTitle(albumTitle);
			ab.setPrice(Float.parseFloat(albumPrice));
			ab.setAlbumArtist(albumArtist);
			ab.setPublisher(albumPublisher);
			ab.setYear(albumYear);
			ab.setGenre(albumGenre);
			ab.setImg();

			System.out.println(ab.getImg());

			al.add(ab);

		}
		return al;
	}

	public ArrayList<AlbumBean> searchByGenre(String genre)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Album_Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Album_Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Album_Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		// String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		// String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList genreList = (NodeList) result;

		for (int i = 0; i < titleList.getLength(); i++) {
			AlbumBean ab = new AlbumBean();
			String albumTitle = titleList.item(i).getTextContent();
			String albumPrice = priceList.item(i).getTextContent();
			String albumArtist = artistList.item(i).getTextContent();
			String albumPublisher = publisherList.item(i).getTextContent();
			String albumYear = yearList.item(i).getTextContent();
			String albumGenre = genreList.item(i).getTextContent();

			System.out.println(albumTitle);
			System.out.println(albumPrice);
			System.out.println(albumArtist);
			System.out.println(albumPublisher);
			System.out.println(albumYear);
			System.out.println(albumGenre);

			ab.setTitle(albumTitle);
			ab.setPrice(Float.parseFloat(albumPrice));
			ab.setAlbumArtist(albumArtist);
			ab.setPublisher(albumPublisher);
			ab.setYear(albumYear);
			ab.setGenre(albumGenre);
			ab.setImg();

			System.out.println(ab.getImg());

			al.add(ab);

		}
		return al;
	}

	public ArrayList<AlbumBean> searchByYear(String year)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Album_Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Album_Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Album_Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		// String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		// String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList genreList = (NodeList) result;

		for (int i = 0; i < titleList.getLength(); i++) {
			AlbumBean ab = new AlbumBean();
			String albumTitle = titleList.item(i).getTextContent();
			String albumPrice = priceList.item(i).getTextContent();
			String albumArtist = artistList.item(i).getTextContent();
			String albumPublisher = publisherList.item(i).getTextContent();
			String albumYear = yearList.item(i).getTextContent();
			String albumGenre = genreList.item(i).getTextContent();

			System.out.println(albumTitle);
			System.out.println(albumPrice);
			System.out.println(albumArtist);
			System.out.println(albumPublisher);
			System.out.println(albumYear);
			System.out.println(albumGenre);

			ab.setTitle(albumTitle);
			ab.setPrice(Float.parseFloat(albumPrice));
			ab.setAlbumArtist(albumArtist);
			ab.setPublisher(albumPublisher);
			ab.setYear(albumYear);
			ab.setGenre(albumGenre);
			ab.setImg();

			System.out.println(ab.getImg());

			al.add(ab);

		}
		return al;

	}

	public ArrayList<AlbumBean> getAllAlbum()
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {

		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album/Album_Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album/Album_Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album/Album_Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		// String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		// String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList genreList = (NodeList) result;
		// String genre = genreList.item(0).getTextContent();

		for (int i = 0; i < titleList.getLength(); i++) {
			AlbumBean ab = new AlbumBean();
			String albumTitle = titleList.item(i).getTextContent();
			String albumPrice = priceList.item(i).getTextContent();
			String albumArtist = artistList.item(i).getTextContent();
			String albumPublisher = publisherList.item(i).getTextContent();
			String albumYear = yearList.item(i).getTextContent();
			String albumGenre = genreList.item(i).getTextContent();

			System.out.println(albumTitle);
			System.out.println(albumPrice);
			System.out.println(albumArtist);
			System.out.println(albumPublisher);
			System.out.println(albumYear);
			System.out.println(albumGenre);

			ab.setTitle(albumTitle);
			ab.setPrice(Float.parseFloat(albumPrice));
			ab.setAlbumArtist(albumArtist);
			ab.setPublisher(albumPublisher);
			ab.setYear(albumYear);
			ab.setGenre(albumGenre);
			ab.setImg();

			System.out.println(ab.getImg());

			al.add(ab);

		}
		return al;
	}

	public AlbumBean getAlbumBean(String title)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		AlbumBean ab = new AlbumBean();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[Album_Title='" + title
				+ "']/Album_Artist/text()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		if (nodes.getLength() == 1) {
			ab.setTitle(title);
			ab.setAlbumArtist(nodes.item(0).getNodeValue());
		}
		// get genre
		expr = xpath.compile("//Album[Album_Title='" + title + "']/Genre/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		nodes = (NodeList) result;
		if (nodes.getLength() == 1) {
			ab.setGenre(nodes.item(0).getNodeValue());
		}
		// get publisher
		expr = xpath.compile("//Album[Album_Title='" + title + "']/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		nodes = (NodeList) result;
		if (nodes.getLength() == 1) {
			ab.setPublisher(nodes.item(0).getNodeValue());
		}
		// get year
		expr = xpath.compile("//Album[Album_Title='" + title + "']/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		nodes = (NodeList) result;
		if (nodes.getLength() == 1) {
			ab.setYear(nodes.item(0).getNodeValue());
		}

		// get Price
		expr = xpath.compile("//Album[Album_Title='" + title + "']/Album_Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		nodes = (NodeList) result;
		if (nodes.getLength() == 1) {
			System.out.println("float price ="+nodes.item(0).getTextContent());
			ab.setPrice(Float.parseFloat(nodes.item(0).getTextContent()));
		}

		// get songlist
		SongBeanDao sbo = new SongBeanDao();
		ab.setSongsList(sbo.getSongsListByAlbum(ab.getTitle()));
		return ab;
	}

	/**
	 * This method is used for calculating how many pages need to be shown on
	 * main.jsp
	 * 
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize) {

		int pageCount = 0;// which page to be displayed
		int rowCount = 0;// how many entries in total
		try {

			if (rowCount % pageSize == 0) {

				pageCount = rowCount / pageSize;
			} else {

				pageCount = rowCount / pageSize + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			// this.close();
		}

		return pageCount;
	}


}
