package model;

public class RankingCircle {
	
	private Integer circleNo;
	private String title;
	private Integer cnt = null;
	
	public RankingCircle() {
		super();
	}
	
	public RankingCircle(int circleNo, String title, int cnt) {
		this.setCircleNo(circleNo);
		this.title = title;
		this.cnt = cnt;
	}
	
	
	public RankingCircle(Integer circleNo, String title, Integer cnt) {
		this.setCircleNo(circleNo);
		this.title = title;
		this.cnt = cnt;
	}
	
	public Integer getCircleNo() {
		return circleNo;
	}

	public void setCircleNo(Integer circleNo) {
		this.circleNo = circleNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}




}
