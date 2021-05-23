package model;

import java.util.Date;

public class Game {
	private Integer gameNo;
	private Integer bPoint;
	private User user;
	private String id;
	private Date uploadDate;
	private Date endDate;
	private Integer state;
	private Integer maxPoint;
	private String bestUser;
	
	public Game(Integer gameNo, Integer bPoint, User user, Date uploadDate, Date endDate, Integer state, Integer maxPoint) {
		this.gameNo = gameNo;
		this.bPoint = bPoint;
		this.user = user;
		this.uploadDate = uploadDate;
		this.endDate = endDate;
		this.state = state;
		this.maxPoint = maxPoint;
	}
	
	public Game(Integer gameNo, Integer bPoint, String id, Date uploadDate, Date endDate, Integer state, Integer maxPoint) {
		this.gameNo = gameNo;
		this.bPoint = bPoint;
		this.id = id;
		this.uploadDate = uploadDate;
		this.endDate = endDate;
		this.state = state;
		this.maxPoint = maxPoint;
	}
	
	public Game(Integer gameNo, String id, Date endDate, Integer state, Integer bPoint, Integer maxPoint) {
		this.gameNo = gameNo;
		this.bPoint = bPoint;
		this.id = id;
		this.endDate = endDate;
		this.state = state;
		this.maxPoint = maxPoint;
	}

	public Integer getGameNo() {
		return gameNo;
	}
	public void setGameNo(Integer gameNo) {
		this.gameNo = gameNo;
	}
	public Integer getbPoint() {
		return bPoint;
	}
	public void setbPoint(Integer bPoint) {
		this.bPoint = bPoint;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getMaxPoint() {
		return maxPoint;
	}
	public void setMaxPoint(Integer maxPoint) {
		this.maxPoint = maxPoint;
	}
	public String getBestUser() {
		return bestUser;
	}
	public void setBestUser(String bestUser) {
		this.bestUser = bestUser;
	}
	
	
}
