package model;

import java.util.Date;

public class QnA {
	private Integer postNo;
	private String title;
	private String content;
	private Date uploadDate;
	private Integer userNo;
	private String userId;
	
	public QnA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QnA(Integer postNo, String title, String content, Date uploadDate, String userId) {
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.userId = userId;
	}
	
	public QnA(Integer postNo, String title, String content, Date uploadDate, Integer userNo) {
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
	}
	
	public QnA(Integer postNo, String title, String content, Date uploadDate, Integer userNo, String userId) {
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
		this.userId = userId;
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
