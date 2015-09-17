package com.heros.doing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="userCode")
    private String userCode;
	
	@Column(name="nickName")
    private String nickName;
	
	@Column(name="sex")
    private int sex;
	
	@Column(name="age")
    private String age;
	
	@Column(name="iconUrl")
    private String iconUrl;
	
	@Column(name="occupation")
    private String occupation;
	
	@Column(name="friendList")
    private Long[] friendList;
	
	@Column(name="identificationMobile")
    private String identificationMobile;
	
	@Column(name="password")
    private String password;
	
	@Column(name="registerTime")
    private String registerTime;
	
	@Column(name="lastLoginTime")
    private String lastLoginTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
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

	public Long[] getFriendList() {
		return friendList;
	}

	public void setFriendList(Long[] friendList) {
		this.friendList = friendList;
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

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
