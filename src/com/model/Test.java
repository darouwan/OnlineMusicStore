package com.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test extends TestCase {

	static public ArrayList<SongBean> searchSongByYear(String year)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Title/text()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		// String albumTitle = "";
		for (int i = 0; i < titleList.getLength(); i++) {
			SongBean sb = new SongBean();
			String songTitle = titleList.item(i).getTextContent();
			al.addAll(SongBeanDao.getSongsListByAlbum(songTitle));
		}

		return al;
	}

	static public ArrayList<SongBean> searchSongByGenre(String genre)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		// --------------------------------------
		XPathExpression expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Title/text()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		String albumTitle = "";
		for (int i = 0; i < titleList.getLength(); i++) {
			SongBean sb = new SongBean();
			String songTitle = titleList.item(i).getTextContent();
			al.addAll(SongBeanDao.getSongsListByAlbum(songTitle));
		}

		return al;
	}

	static public ArrayList<SongBean> searchSongByArtist(String artist)
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
				+ artist + "')]/ancestor::Album/Title/text()");
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

			sb.setTitle(albumTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);
			sb.setAlbumTitle(albumTitle);

			al.add(sb);

		}
		return al;

	}

	static public ArrayList<SongBean> searchSongByTitle(String title)
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

		expr = xpath.compile("//Album/SongsList/Song[contains(Title,'" + title
				+ "')]/ancestor::Album/Title/text()");
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

			sb.setTitle(albumTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);
			sb.setAlbumTitle(albumTitle);

			al.add(sb);

		}
		return al;

	}

	static public ArrayList<AlbumBean> searchByYear(String year)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Year,'" + year
				+ "')]/Price/text()");
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

	static public ArrayList<AlbumBean> searchByGenre(String genre)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Genre,'" + genre
				+ "')]/Price/text()");
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

	static public ArrayList<AlbumBean> searchByArtist(String artist)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Album_Artist,'"
				+ artist + "')]/Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Album_Artist,'" + artist
				+ "')]/Price/text()");
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

	static public ArrayList<AlbumBean> searchByTitle(String title)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		// TODO Auto-generated method stub
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[contains(Title,'" + title
				+ "')]/Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Title,'" + title
				+ "')]/Price/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Title,'" + title
				+ "')]/Album_Artist/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		expr = xpath.compile("//Album[contains(Title,'" + title
				+ "')]/Publisher/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList publisherList = (NodeList) result;
		// String publisher = publisherList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Title,'" + title
				+ "')]/Year/text()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList yearList = (NodeList) result;
		// String year = yearList.item(0).getTextContent();

		expr = xpath.compile("//Album[contains(Title,'" + title
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

	/**
	 * @param args
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 */
	static public ArrayList<SongBean> getSongsListByAlbum(String title)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		// TODO Auto-generated method stub
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album[Title='" + title
				+ "']/SongsList/Song/Title/node()");
		// get Album_Artist
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album[Title='" + title
				+ "']/SongsList/Song/Price/node()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList priceList = (NodeList) result;

		expr = xpath.compile("//Album[Title='" + title
				+ "']/SongsList/Song/Artist/node()");
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList artistList = (NodeList) result;

		for (int i = 0; i < titleList.getLength(); i++) {

			String songTitle = titleList.item(i).getTextContent();
			String songPrice = priceList.item(i).getTextContent();
			String songArtist = artistList.item(i).getTextContent();

			System.out.println(songTitle);
			System.out.println(songPrice);
			System.out.println(songArtist);

			SongBean sb = new SongBean();
			sb.setTitle(songTitle);
			sb.setPrice(Float.parseFloat(songPrice));
			sb.setArtist(songArtist);

			al.add(sb);
		}

		System.out.println(al.size());

		// expr
		// = xpath.compile("//Album[Title='"+title+"']/Publisher/text()");
		// result = expr.evaluate(doc, XPathConstants.NODESET);
		// NodeList l = (NodeList) result ;
		// System.out.println(l.item(0).getTextContent());
		return al;
	}

	static public ArrayList getAllAlbum() throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {

		ArrayList al = new ArrayList();
		Document doc = new Doc().getDoc();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//Album/Title/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList titleList = (NodeList) result;

		expr = xpath.compile("//Album/Price/text()");
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

		}
		return al;
	}

	public static void main(String[] args) throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		// getSongsListByAlbum("Number Ones");
		// getAllAlbum();
		// searchByArtist("em");
		// searchByGenre("Popo");
		// searchByYear("10");
		// searchByTitle("21");
		// searchSongByTitle("B");
		// searchSongByArtist("Em");
		// searchSongByGenre("Po");
		// searchSongByYear("2008");
		Mail mail = new Mail();
		mail.setSendTo("k-2feng@hotmail.com");
		mail.setContent("miamia!!");
		//mail.send();
		mail.sendMailTLS();
	}

	public void test1() throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		searchByYear("2003");
	}

}
