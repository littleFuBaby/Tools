package org.fuys.owndb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GiftBook extends Gift implements Serializable {
	
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return super.toString() + " GiftBook [author=" + author + "]";
	}
	
	

}
