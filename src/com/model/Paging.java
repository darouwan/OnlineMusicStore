package com.model;


import java.util.ArrayList;
import java.util.List;

public class Paging {
	private  int pageCount;
	private int rowCount;
	//
	
	/**
	 * Get How many pages in total 
	 * @param pageSize how many rows displayed in one page
	 * @param rowCount how many rows in total
	 * @return how many pages in total
	 */
	public int getPageCount(int pageSize,int rowCount ) {

		int pageCount = 0;// 
		//int rowCount = 0;// how many entries in total
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
		System.out.println("pageCount = "+pageCount);
		return pageCount;
	}
	
	public ArrayList getGoodsByPage(ArrayList originalAL,int pageSize, int pageNow){
		ArrayList al = new ArrayList();
		//List list = new ArrayList();
		System.out.println("al size = "+originalAL.size());
		if(pageNow*pageSize<=originalAL.size()){
			al = new ArrayList( originalAL.subList((pageNow-1)*pageSize, pageNow*pageSize));
		}else{
			al = new ArrayList( originalAL.subList((pageNow-1)*pageSize, originalAL.size()));
		}

		return al;
		
		
	}
}
