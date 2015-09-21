package com.heros.doing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userInfo")
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="nickName")
    private String nickName;
	
	@Column(name="deviceCode")
    private String deviceCode;
	
	@Column(name="userId")
    private String userId;
	
	@Column(name="password")
    private String password;
	
	@Column(name="sex")
    private int sex;
	
	@Column(name="age")
    private int age;
	
	@Column(name="occupation")
    private String occupation;
	
	@Column(name="iconUrl")
    private String iconUrl;
	
	@Column(name="identificationMobile")
    private String identificationMobile;
	
	@Column(name="registerTime")
    private int registerTime;
	
	@Column(name="lastLoginTime")
    private int lastLoginTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIdentificationMobile() {
		return identificationMobile;
	}

	public void setIdentificationMobile(String identificationMobile) {
		this.identificationMobile = identificationMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(int registerTime) {
		this.registerTime = registerTime;
	}

	public int getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(int lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
