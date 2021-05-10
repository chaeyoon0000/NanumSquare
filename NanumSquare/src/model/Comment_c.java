package model;

import java.util.Date;

public class Comment_c {
	Integer commentNo;
	User user;
	Circle circle;
	String content;
	Date uploadDate;
	
	public Comment_c() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
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
}