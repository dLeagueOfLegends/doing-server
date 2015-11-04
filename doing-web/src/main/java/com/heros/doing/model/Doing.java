package com.heros.doing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doing")
public class Doing implements Serializable{

	private static final long serialVersionUID = 8844323582684102181L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;
	
    @Column(name="userId")
    private String userId;

    @Column(name="content")
    private String content;
    
    @Column(name="imgList")
    private String[] imgList;
    
    @Column(name="publishTime")
    private Long publishTime;
    
    @Column(name="device")
    private String device;
    
    @Column(name="position")
    private String position;
    
    @Column(name="commentList")
    private int[] commentList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getImgList() {
		return imgList;
	}

	public void setImgList(String[] imgList) {
		this.imgList = imgList;
	}

	public Long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int[] getCommentList() {
		return commentList;
	}

	public void setCommentList(int[] commentList) {
		this.commentList = commentList;
	}
}
