package model;

import java.util.Date;

public class Comment_qchild {
	String qChild;
	Comment_q qParent;
	String content;
	Date uploadDate;
	User user;
	
	public Comment_qchild() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getqChild() {
		return qChild;
	}
	public void setqChild(String qChild) {
		this.qChild = qChild;
	}
	public Comment_q getqParent() {
		return qParent;
	}
	public void setqParent(Comment_q qParent) {
		this.qParent = qParent;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
