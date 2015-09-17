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
	
    @Column(name="ownerId")
    private Long ownerId;

    @Column(name="content")
    private String content;
    
    @Column(name="imgList")
    private String[] imgList;
    
    @Column(name="publishTime")
    private String publishTime;
    
    @Column(name="device")
    private String device;
    
    @Column(name="area")
    private String area;
    
    @Column(name="commentList")
    private String[] commentList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String[] getCommentList() {
		return commentList;
	}

	public void setCommentList(String[] commentList) {
		this.commentList = commentList;
	}
}
