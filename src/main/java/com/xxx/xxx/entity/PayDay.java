package com.xxx.xxx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pay_day")
public class PayDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_day_id")
    private Integer payDayId;

    private Integer userId;

    private Integer deptId;

    private Float worktime;

    private Integer timemoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date workdate;

    private Integer paydayType;

    private Integer paydayName;

    private Integer createby;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH-mm-ss",timezone = "GMT+8")
    private Date createtime;

    private Integer updateby;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH-mm-ss",timezone = "GMT+8")
    private Date updatetime;

    public Integer getPayDayId() {
        return payDayId;
    }

    public void setPayDayId(Integer payDayId) {
        this.payDayId = payDayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Float getWorktime() {
        return worktime;
    }

    public void setWorktime(Float worktime) {
        this.worktime = worktime;
    }

    public Integer getTimemoney() {
        return timemoney;
    }

    public void setTimemoney(Integer timemoney) {
        this.timemoney = timemoney;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public Integer getPaydayType() {
        return paydayType;
    }

    public void setPaydayType(Integer paydayType) {
        this.paydayType = paydayType;
    }

    public Integer getPaydayName() {
        return paydayName;
    }

    public void setPaydayName(Integer paydayName) {
        this.paydayName = paydayName;
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