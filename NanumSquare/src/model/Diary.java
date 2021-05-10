package model;

import java.util.Date;

public class Diary {
	Integer diaryNo;
	String userName;
	Integer userNo;
	Integer catNo;
	String title;
	String content;
	Date uploadDate;
	private String userId;
	String image; //filePath
	Integer cnt;
	String loc;
	Integer likey;
	
	
	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", userNo=" + userNo + ", catNo=" + catNo + ", title=" + title
				+ ", content=" + content + ", uploadDate=" + uploadDate + ", image=" + image + ", cnt=" + cnt + ", loc="
				+ loc + ", likey=" + likey + "]";
	}


	
	// 기본 생성자
	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Diary(Integer diaryNo, Integer userNo, Integer catNo, String title, String content, Date uploadDate, String image, Integer cnt, String loc, Integer likey) {
		this.diaryNo = diaryNo;
		this.userNo = userNo;
		this.catNo = catNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.image = image;
		this.cnt = cnt;
		this.loc = loc;
		this.likey = likey;
	}
	
	public Diary(Integer diaryNo, Integer userNo, Integer catNo, String title, String content, Date uploadDate, String image, Integer cnt, String loc, Integer likey, String userId) {
		this.diaryNo = diaryNo;
		this.userNo = userNo;
		this.catNo = catNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.image = image;
		this.cnt = cnt;
		this.loc = loc;
		this.likey = likey;
		this.userId = userId;
	}

	public Diary(int diaryNo, String userName, int catNo, String title, String content, Date uploadDate,
			String image, int cnt, String loc, int likey) {
		
		// TODO Auto-generated constructor stub
		this.diaryNo = diaryNo;
		this.userName = userName;
		this.catNo = catNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.image = image;
		this.cnt = cnt;
		this.loc = loc;
		this.likey = likey;
	}



	public void update(Diary updateDiary) {
		this.title = updateDiary.title;
        this.content = updateDiary.content;
        this.image = updateDiary.image;
        this.loc = updateDiary.loc;
    }

	public Integer getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(Integer diaryNo) {
		this.diaryNo = diaryNo;
	}
	
	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	
	public Integer getCatNo() {
		return catNo;
	}

	public void setCatNo(Integer catNo) {
		this.catNo = catNo;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Integer getLikey() {
		return likey;
	}

	public void setLikey(Integer likey) {
		this.likey = likey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
