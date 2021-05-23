package model.service;

import java.sql.SQLException;
import java.util.List;
import model.User;

import model.dao.FriendDAO;

public class FriendManager {
	private static FriendManager friendMan = new FriendManager();
	private FriendDAO friendDAO;
	
	private FriendManager() {
		try {
			friendDAO = new FriendDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FriendManager getInstance() {
		return friendMan;
	}
	
	// 내 친구 관련
	public List<User> getFriendListByUser(String user_id) throws SQLException {
		return friendDAO.getFriendListByUser(user_id);
	}
	
	public int deleteFriend(int friend_no) { 
		return friendDAO.deleteFriend(friend_no);
	}
	
	//나에게 온 친구 요청 관련
	public List<User> getFriendRequestList(String user_id) throws SQLException {
		return friendDAO.getFriendRequestList(user_id);
	}
	
	public int acceptFollowing(User following) {
		return friendDAO.acceptFollowing(following);
	}
	
	public int rejectFollowing(int friend_no) { 
		return friendDAO.rejectFollowing(friend_no);
	}
	
	//내가 요청한 친구 관련
	public List<User> getRequestListByUser(String user_id) throws SQLException {
		return friendDAO.getRequestListByUser(user_id);
	}
	
	public int requestFollowing(User following) { 
		return friendDAO.requestFollowing(following);
	}
	
	public int cancelFollowing(int friend_no) {
		return friendDAO.cancelFollowing(friend_no);
	}
}
