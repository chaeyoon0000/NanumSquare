package model;

import java.util.Date;

public class Comment_cchild {
	String cChild;
	Comment_c cParent;
	String content;
	Date uploadDate;
	User user;
	
	public Comment_cchild() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getcChild() {
		return cChild;
	}
	public void setcChild(String cChild) {
		this.cChild = cChild;
	}
	public Comment_c getcParent() {
		return cParent;
	}
	public void setcParent(Comment_c cParent) {
		this.cParent = cParent;
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
