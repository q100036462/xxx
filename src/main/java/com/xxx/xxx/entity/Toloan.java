package com.xxx.xxx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Toloan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "to_id")
    private Integer toId;

    private Integer userId;

    private String toReason;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date toDate;

    private Integer toMoney;

    private Integer toType;

    private Integer toWorknumber;

    private Integer createby;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH-mm-ss",timezone = "GMT+8")
    private Date createtime;

    private Integer updateby;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH-mm-ss",timezone = "GMT+8")
    private Date updatetime;

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToReason() {
        return toReason;
    }

    public void setToReason(String toReason) {
        this.toReason = toReason == null ? null : toReason.trim();
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getToMoney() {
        return toMoney;
    }

    public void setToMoney(Integer toMoney) {
        this.toMoney = toMoney;
    }

    public Integer getToType() {
        return toType;
    }

    public void setToType(Integer toType) {
        this.toType = toType;
    }

    public Integer getToWorknumber() {
        return toWorknumber;
    }

    public void setToWorknumber(Integer toWorknumber) {
        this.toWorknumber = toWorknumber;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}