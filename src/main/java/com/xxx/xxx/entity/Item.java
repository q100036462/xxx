package com.xxx.xxx.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ego_item")
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "sell_point")
    private String sellPoint;
    
    @Column(name = "price")
    private Long price;
    
    @Column(name = "num")
    private Integer num;
    
    @Column(name = "barcode")
    private String barcode;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "cid")
    private Long cid;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "created")
    private Date created;
    
    @Column(name = "updated")
    private Date updated;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"title\":\"" + title + "\", \"sellPoint\":\"" + sellPoint + "\", \"price\":\""
				+ price + "\", \"num\":\"" + num + "\", \"barcode\":\"" + barcode + "\", \"image\":\"" + image
				+ "\", \"cid\":\"" + cid + "\", \"status\":\"" + status + "\", \"created\":\"" + created
				+ "\", \"updated\":\"" + updated + "\"}";
	}
    
    
}
