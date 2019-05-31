package com.xxx.xxx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "idcard")
    private String idcard;

    @Column(name = "phone")
    private String phone;

    @Column(name = "adress")
    private String adress;

    @Column(name = "bankcard")
    private String bankcard;

    @Column(name = "timemoney")
    private Integer timemoney;

    @Column(name = "type")
    private Integer type;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "createby")
    private Integer createby;

    @Column(name = "createtime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern="yyyy-MM-dd  HH-mm-ss",timezone = "GMT+8")
    private Date createtime;

    @Column(name = "updateby")
    private Integer updateby;

    @Column(name = "updatetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date updatetime;

    @Column(name = "del_flag")
    private Integer delFlag;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public Integer getTimemoney() {
        return timemoney;
    }

    public void setTimemoney(Integer timemoney) {
        this.timemoney = timemoney;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"sex\":\"")
                .append(sex).append('\"');
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"idcard\":\"")
                .append(idcard).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"adress\":\"")
                .append(adress).append('\"');
        sb.append(",\"bankcard\":\"")
                .append(bankcard).append('\"');
        sb.append(",\"timemoney\":")
                .append(timemoney);
        sb.append(",\"type\":")
                .append(type);
        sb.append(",\"roleId\":")
                .append(roleId);
        sb.append(",\"deptId\":")
                .append(deptId);
        sb.append(",\"createby\":")
                .append(createby);
        sb.append(",\"createtime\":\"")
                .append(createtime).append('\"');
        sb.append(",\"updateby\":")
                .append(updateby);
        sb.append(",\"updatetime\":\"")
                .append(updatetime).append('\"');
        sb.append(",\"delFlag\":")
                .append(delFlag);
        sb.append('}');
        return sb.toString();
    }
}