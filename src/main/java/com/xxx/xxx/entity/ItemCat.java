package com.xxx.xxx.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name = "ego_item_cat")
public class ItemCat {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "sort_order")
    private Integer sortOrder;
    
    @Column(name = "is_parent")
    private String isParent;
    
    @Column(name = "created")
    private Date created;
    
    @Column(name = "updated")
    private Date updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
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
		return "{\"id\":\"" + id + "\", \"parentId\":\"" + parentId + "\", \"name\":\"" + name + "\", \"status\":\""
				+ status + "\", \"sortOrder\":\"" + sortOrder + "\", \"isParent\":\"" + isParent + "\", \"created\":\""
				+ created + "\", \"updated\":\"" + updated + "\"}";
	}

	
}
