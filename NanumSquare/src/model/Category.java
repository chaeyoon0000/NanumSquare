package model;

import java.util.List;

public class Category {
	private Integer catNo = null;
	private String catName = null;
	private List<Circle> circleList;
	

	public Category(int catNo, String catName) {
		this.catNo = catNo;
		this.catName = catName;
// TODO Auto-generated constructor stub
	}

	public Category(Integer catNo, String catName) {
		// TODO Auto-generated constructor stub
		this.catNo = catNo;
		this.catName = catName;
	}

	public Integer getCatNo() {
		return catNo;
	}

	public void setCatNo(Integer catNo) {
		this.catNo = catNo;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	public List<Circle> getCircleList() {
		return circleList;
	}

	public void setCircleList(List<Circle> circleList) {
		this.circleList = circleList;
	}
	
	
}
