package model;

import java.util.Date;

public class Comment_q {
	Integer commentNo;
	User user;
	QnA qna;
	String content;
	Date uploadDate;
	
	public Comment_q() {
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

	public QnA getQna() {
		return qna;
	}

	public void setQna(QnA qna) {
		this.qna = qna;
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
