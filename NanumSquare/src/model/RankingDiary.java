package model;

public class RankingDiary {
	private Integer diaryNo;
	private String title;
	private Integer cnt = null;
	private Integer likey = null;
	
	public RankingDiary(int diaryNo, String title, int cnt, int likey) {
		this.diaryNo = diaryNo;
		this.title = title;
		this.cnt = cnt;
		this.likey = likey;
	}
	
	public RankingDiary(Integer diaryNo, String title, Integer cnt, Integer likey) {
		this.diaryNo = diaryNo;
		this.title = title;
		this.cnt = cnt;
		this.likey = likey;
	}
	
	public RankingDiary(Integer cnt, Integer likey) {
		this.cnt = cnt;
		this.likey = likey;
	}
	
	public RankingDiary() {
		super();
	}


	public Integer getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(Integer diaryNo) {
		this.diaryNo = diaryNo;
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
	public Integer getLikey() {
		return likey;
	}
	public void setLikey(Integer likey) {
		this.likey = likey;
	}


}
