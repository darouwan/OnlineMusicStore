package com.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class MyCartDao {
	private float allPrice=0.0f;
	private ArrayList<String> songAl = new ArrayList<String>();
	private ArrayList<String> albumAl = new ArrayList<String>();
	private SongBeanDao sbd = new  SongBeanDao();
	private AlbumBeanDao abd = new AlbumBeanDao();
	private UserBean user = new UserBean();

	
	public void mergeCart(){
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<songAl.size();i++){
			try {
				
				SongBean sb = sbd.getSongBean(songAl.get(i));
				System.out.println("the song list size  = "+songAl.size());
				if(albumAl.contains(sb.getAlbumTitle())){
					al.add(sb.getTitle());
					System.out.println("removed song title = "+sb.getTitle());
				}
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		songAl.removeAll(al);
		
	}
	
	/**
	 * If user buy all individual songs in one album, the program will replace these songs with the album
	 * @param newSong new added song
	 */
	public void checkDuplicates(String newSong){
		try {
			SongBeanDao sbd = new SongBeanDao();
			String album_title = sbd.getSongBean(newSong).getAlbumTitle();

			
			
			ArrayList<SongBean> al = sbd.getSongsListByAlbum(album_title);
			ArrayList<SongBean> temp_al = new ArrayList<SongBean>();
			for(int i=0;i<songAl.size();i++){
				String song_title = songAl.get(i);
				SongBean sb = sbd.getSongBean(song_title);
				if(sb.getAlbumTitle().equals(album_title)){
					temp_al.add(sb);
				}
			}
			if(al.size()==temp_al.size()){
				for(int i=0;i<temp_al.size();i++){
					songAl.remove(temp_al.get(i).getTitle());
				}
				this.addAlbum(album_title);
			}
			
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	/**
	 * ·µ»Ø×Ü¼Û
	 * @return
	 */
	public float getAllPrice(){
		
		return this.allPrice;
	}
	
	public void addSong(String songTitle){
		if(!songAl.contains(songTitle)){
			songAl.add(songTitle);
		}
		
	}
	
	public void addAlbum(String albumTitle){
		if(!albumAl.contains(albumTitle)){
			albumAl.add(albumTitle);
		}
	}
	
	public void delSong(String title){
		//songhm.remove(title);
		
		songAl.remove(title);
	}
	
	public void delAlbum(String title){
		System.out.println("Removed album = "+title);
		albumAl.remove(title);
	}
	
	public void clearCart(){
		songAl.clear();
		albumAl.clear();
	}
	
	public ArrayList<SongBean> getSongCart(){
		ArrayList<SongBean> al = new ArrayList<SongBean>();
		for(int i=0;i<songAl.size();i++){
			SongBean sb;
			try {
				sb = sbd.getSongBean(songAl.get(i));
				al.add(sb);
				
				BigDecimal b1 = new BigDecimal(Float.toString(allPrice));
				allPrice = b1.add(new BigDecimal(Float.toString(sb.getPrice()))).floatValue();
				
				//allPrice += sb.getPrice();
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return al;
		
	}
	
	
	public ArrayList<AlbumBean> getAlbumCart(){
		allPrice = 0.0f;

		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		for(int i=0;i<albumAl.size();i++){
			AlbumBean ab;
			try {
				ab = abd.getAlbumBean(albumAl.get(i));
				al.add(ab);
				BigDecimal b1 = new BigDecimal(Float.toString(allPrice));
				allPrice = b1.add(new BigDecimal(Float.toString(ab.getPrice()))).floatValue();
				
				
				//allPrice += ab.getPrice();
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return al;
	}
	
}
