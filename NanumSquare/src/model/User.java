package model;

public class User {
	Integer userNo;
	String id;
	String name;
	String passwd;
	String phone;
	String email;
	String address;
	Integer point;
	String applyDate;
	Integer friendNo;
	String friendId;
	Integer FollingNo;
	
	public User(Integer userNo, String id, String name, String passwd, String phone, String email, String address,
			Integer point) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.point = point;
	}
	
	public User(String id, String applyDate) {
		this.id = id;
		this.applyDate = applyDate;
	}
	
	public User(Integer userNo, Integer friendNo) {
		this.userNo = userNo;
		this.friendNo = friendNo;
	}
	
	public User(Integer userNo, String id, Integer friendNo, String friendId) {
		this.userNo = userNo;
		this.id = id;
		this.friendNo = friendNo;
		this.friendId = friendId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	
	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}	

	public Integer getFriendNo() {
		return friendNo;
	}

	public void setFriendNo(Integer friendNo) {
		this.friendNo = friendNo;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public Integer getFollingNo() {
		return FollingNo;
	}

	public void setFollingNo(Integer follingNo) {
		FollingNo = follingNo;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.passwd.equals(password);
	}
	
	public boolean isSameUser(String id) {
        return this.id.equals(id);
    }
}
