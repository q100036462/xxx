package com.xxx.xxx.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    private String roleName;

    private String roleCname;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCname() {
        return roleCname;
    }

    public void setRoleCname(String roleCname) {
        this.roleCname = roleCname == null ? null : roleCname.trim();
    }
}