package com.model;

import java.util.ArrayList;

public class AlbumBean extends AbstractMusic {
	private String AlbumArtist;
	private String title;
	private float price;
	private String img;
	private ArrayList<SongBean> songsList;
	public String getImg() {
		img = title.replace(" ", "_");
		this.img = "img/"+img+".jpg";
		return img;
	}
	public void setImg() {
		img = title.replace(" ", "_");
		this.img = "img/"+img+".jpg";
	}
	
	public String getAlbumArtist() {
		return AlbumArtist;
	}
	public void setAlbumArtist(String albumArtist) {
		AlbumArtist = albumArtist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ArrayList<SongBean> getSongsList() {
		return songsList;
	}
	public void setSongsList(ArrayList<SongBean> songsList) {
		this.songsList = songsList;
	}
}
