package model;

import java.util.Date;

public class Circle {
	private Integer circleNo;
	private Integer writer;
	private String writerName;
	private String title;
	private String content;
	private Integer category;
	private String catName;
	private Date uploadDate;
	private String loc;
	private Date endDate;
	private String image;
	private Integer max;
	private Integer cnt;
	private Integer state;
	
	public Circle(Integer circleNo, Integer writer, String title, String content, Integer category, Date uploadDate,
			String loc, Date endDate, String image, Integer max, Integer cnt, Integer state) {
		this.circleNo = circleNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.category = category;
		this.uploadDate = uploadDate;
		this.loc = loc;
		this.endDate = endDate;
		this.image = image;
		this.max = max;
		this.cnt = cnt;
		this.state = state;
	}
	
	public Circle(Integer circleNo, String writerName, String title, String content, Integer category, Date uploadDate,
			String loc, Date endDate, String image, Integer max, Integer cnt, Integer state) {
		this.circleNo = circleNo;
		this.writerName = writerName;
		this.title = title;
		this.content = content;
		this.category = category;
		this.uploadDate = uploadDate;
		this.loc = loc;
		this.endDate = endDate;
		this.image = image;
		this.max = max;
		this.cnt = cnt;
		this.state = state;
	}

	public Circle(Integer circleNo, String writerName, String title, String content, Integer category, String catName, Date uploadDate,
			String loc, Date endDate, String image, Integer max, Integer cnt, Integer state) {
		this.circleNo = circleNo;
		this.writerName = writerName;
		this.title = title;
		this.content = content;
		this.category = category;
		this.catName = catName;
		this.uploadDate = uploadDate;
		this.loc = loc;
		this.endDate = endDate;
		this.image = image;
		this.max = max;
		this.cnt = cnt;
		this.state = state;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Integer getCircleNo() {
		return circleNo;
	}

	public void setCircleNo(Integer circleNo) {
		this.circleNo = circleNo;
	}

	public Integer getWriter() {
		return writer;
	}

	public void setWriter(Integer writer) {
		this.writer = writer;
	}
	
	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}