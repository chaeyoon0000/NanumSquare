package model;

import java.util.Date;


public class Comment_d {
	Integer commentNo;
	Integer userNo;
	String userName;
	Integer diaryNo;
	String content;
	Date uploadDate;
	
	public Comment_d() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment_d(int commentNo, int userNo, String userName, int diaryNo, String content, Date uploadDate) {
		this.commentNo = commentNo;
		this.diaryNo = diaryNo;
		this.userName = userName;
		this.userNo = userNo;
		this.content = content;
		this.uploadDate = uploadDate;
		// TODO Auto-generated constructor stub
	}
	
	public Integer getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(Integer diaryNo) {
		this.diaryNo = diaryNo;
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
	
//	public List<Comment_d> getComment_dList();		// ��ü ��� ������ ȹ��	
//	
//	public List<Comment_d> Comment_dList(int commentNo);	// ���̾�� ���� ��� ��� ��� - userNo, content, uploadDate
//
//	public int insertComment_d(Comment_d comment_d);	// ���̾ ����� �߰�
//	public int updateComment_d(Comment_d comment_d);	// ���̾ ����� ����
//	public int deleteComment_d(int commentNo);	// ���̾ ����� ����
	
}
