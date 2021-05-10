package model;

import java.util.Date;

public class Comment_dchild {
	Integer dCommentNo;
	Integer dParent;
	String content;
	Date uploadDate;
	Integer userNo;
	String userName;
	
	public Comment_dchild() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment_dchild(int dCommentNo, int userNo, String userName, int dParent, String content, Date uploadDate) {
		this.dCommentNo = dCommentNo;
		this.dParent = dParent;
		this.userName = userName;
		this.userNo = userNo;
		this.content = content;
		this.uploadDate = uploadDate;
		// TODO Auto-generated constructor stub
	}
	
	public Integer getdCommentNo() {
		return dCommentNo;
	}
	public void setdCommentNo(Integer dCommentNo) {
		this.dCommentNo = dCommentNo;
	}
	public Integer getdParent() {
		return dParent;
	}
	public void setdParent(Integer dParent) {
		this.dParent = dParent;
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
}
