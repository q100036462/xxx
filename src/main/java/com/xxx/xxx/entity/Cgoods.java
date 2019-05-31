package com.xxx.xxx.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cgoods {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;
    
    @Column(name = "pcode")
    private String pcode;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "sift")
    private String sift;
    
    @Column(name = "pic")
    private String pic;
    
    @Column(name = "certificateids")
    private String certificateids;
    
    //临时字段
    private List<Cgoods>  children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSift() {
		return sift;
	}

	public void setSift(String sift) {
		this.sift = sift;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getCertificateids() {
		return certificateids;
	}

	public void setCertificateids(String certificateids) {
		this.certificateids = certificateids;
	}

	public List<Cgoods> getChildren() {
		return children;
	}

	public void setChildren(List<Cgoods> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"code\":\"" + code + "\", \"pcode\":\"" + pcode + "\", \"name\":\"" + name
				+ "\", \"state\":\"" + state + "\", \"sift\":\"" + sift + "\", \"pic\":\"" + pic
				+ "\", \"certificateids\":\"" + certificateids + "\", \"children\":\"" + children + "\"}";
	}
    
    
}
