package com.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable{

	private Integer gId;
	private String gName;
	private String gPrice;
	private String image;
	private Integer stock;
	private String gMember;
	private String gDescription;
	private Integer gScore;
	public Integer getgId() {
		return gId;
	}
	public void setgId(Integer gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getgMember() {
		return gMember;
	}
	public void setgMember(String gMember) {
		this.gMember = gMember;
	}
	public String getgDescription() {
		return gDescription;
	}
	public void setgDescription(String gDescription) {
		this.gDescription = gDescription;
	}
	public Integer getgScore() {
		return gScore;
	}
	public void setgScore(Integer gScore) {
		this.gScore = gScore;
	}
	public Goods(Integer gId, String gName, String gPrice, String image, Integer stock, String gMember,
			String gDescription, Integer gScore) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.image = image;
		this.stock = stock;
		this.gMember = gMember;
		this.gDescription = gDescription;
		this.gScore = gScore;
	}
	public Goods() {
	}
	
	
}
