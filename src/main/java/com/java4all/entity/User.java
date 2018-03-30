package com.java4all.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: momo
 * Date: 2018/3/26
 * Description:
 */

@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id ;

    @Column(name = "userName",nullable = true)
    private String userName;

    @Column(name = "real_name",nullable = true)
    private String realName;

    @Column(name = "password",nullable = true)
    private String password;

    @Column(name = "country",nullable = true)
    private String country;

    @Column(name = "province",nullable = true)
    private String province;

    @Column(name = "city",nullable = true)
    private String city;

    @Column(name = "phone",nullable = true)
    private String phone;

    @Column(name = "createTime",nullable = true)
    private Date createTime;

    @Column(name = "devLanguage",nullable = true)
    private String devLanguage;

    @Column(name = "schoolName",nullable = true)
    private String schoolName;

    @Column(name = "schoolMajor",nullable = true)
    private String schoolMajor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDevLanguage() {
        return devLanguage;
    }

    public void setDevLanguage(String devLanguage) {
        this.devLanguage = devLanguage;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolMajor() {
        return schoolMajor;
    }

    public void setSchoolMajor(String schoolMajor) {
        this.schoolMajor = schoolMajor;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", devLanguage='" + devLanguage + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolMajor='" + schoolMajor + '\'' +
                '}';
    }
}
