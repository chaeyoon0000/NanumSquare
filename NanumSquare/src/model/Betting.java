package model;

import java.util.Date;

public class Betting {
	private Integer betNo;
	private Integer bPoint;
	private Integer gameNo;
	private Date uploadDate;
	private Integer userNo;
	private String id;
	
	public Betting(Integer betNo, Integer bPoint, Integer gameNo, Date uploadDate, Integer userNo, String id) {
		super();
		this.betNo = betNo;
		this.bPoint = bPoint;
		this.gameNo = gameNo;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
		this.id = id;
	}
	
	
	public Betting(Integer betNo, Integer bPoint, Integer gameNo, Date uploadDate, Integer userNo) {
		super();
		this.betNo = betNo;
		this.bPoint = bPoint;
		this.gameNo = gameNo;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
	}

	public Betting(Integer betNo, Integer bPoint, Integer gameNo, Date uploadDate, String id) {
		super();
		this.betNo = betNo;
		this.bPoint = bPoint;
		this.gameNo = gameNo;
		this.uploadDate = uploadDate;
		this.id = id;
	}

	public Integer getBetNo() {
		return betNo;
	}

	public void setBetNo(Integer betNo) {
		this.betNo = betNo;
	}

	public Integer getbPoint() {
		return bPoint;
	}

	public void setbPoint(Integer bPoint) {
		this.bPoint = bPoint;
	}

	public Integer getGameNo() {
		return gameNo;
	}

	public void setGameNo(Integer gameNo) {
		this.gameNo = gameNo;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
