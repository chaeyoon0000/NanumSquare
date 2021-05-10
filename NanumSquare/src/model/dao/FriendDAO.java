package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;
public class FriendDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public FriendDAO() {			
		jdbcUtil = new JDBCUtil();
	}
	
	//내 친구 관련
	public List<User> getFriendListByUser(String user_id) { 
		// TODO Auto-generated method stub
		String query = "SELECT user1.user_no AS userNo, user1.id AS userId, user2.user_no AS friendNo, user2.id AS friendId " 
				+ "FROM NANUM_USER user1, NANUM_USER user2, friend "
				+ "WHERE user1.id = ? AND user2.user_no = friend.friend_no "
				+ "AND user1.user_no = friend.user_no";
			
		jdbcUtil.setSqlAndParameters(query, new Object[] {user_id});
						
			try {
				ResultSet rs = jdbcUtil.executeQuery();					
				List<User> friendList = new ArrayList<User>();	
				
				while (rs.next()) {
					User dto = new User(
							rs.getInt("userNo"),
							rs.getString("userId"),
							rs.getInt("friendNo"),
							rs.getString("friendId"));
					friendList.add(dto);
				}		
				return friendList;					
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
			return null;
	}
	
	public int deleteFriend(int friend_no) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM FRIEND WHERE friend_no = ?";
				
		jdbcUtil.setSqlAndParameters(query, new Object[] {friend_no});
				
		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return 0;
	}

	//나에게 온 친구 요청 관련
	public List<User> getFriendRequestList(String user_id) {
		// TODO Auto-generated method stub
		String query = "SELECT user1.user_no AS userNo, user1.id AS userId, user2.user_no AS friendNo, user2.id AS friendId "
				+ "FROM NANUM_USER user1, NANUM_USER user2, following "
				+ "WHERE user2.id = ? AND user2.user_no = following.friend_no "
				+ "AND user1.user_no = following.user_no";
					
		jdbcUtil.setSqlAndParameters(query, new Object[] {user_id});
								
		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<User> friendList = new ArrayList<User>();	
						
			while (rs.next()) {
				User dto = new User(
						rs.getInt("userNo"),
						rs.getString("userId"),
						rs.getInt("friendNo"),
						rs.getString("friendId"));
				friendList.add(dto);
			}
			return friendList;					
		} catch (Exception ex) {
			ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
		return null;
	}
	
	public int acceptFollowing(User following) {
		String query = "INSERT INTO FRIEND VALUES(?, ?)";
		
		int friendNo = following.getFriendNo();
		rejectFollowing(friendNo);
		
		Object[] param = new Object[] {following.getUserNo(), following.getFriendNo()};		
				
		jdbcUtil.setSqlAndParameters(query, param);
				
		 try {
			 int result = jdbcUtil.executeUpdate();  
	         return result;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      } finally {      
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }      
	      return 0;
	}
	
	public int rejectFollowing(int friend_no) { 
		// TODO Auto-generated method stub
		String query = "DELETE FROM FOLLOWING WHERE user_no = ?";
						
		jdbcUtil.setSqlAndParameters(query, new Object[] {friend_no});
						
		try {
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return 0;
	}
	
	//내가 요청한 친구 관련
	public List<User> getRequestListByUser(String user_id) { 
		// TODO Auto-generated method stub
		String query = "SELECT user1.user_no AS userNo, user1.id AS userId, user2.user_no AS friendNo, user2.id AS friendId " 
				+ "FROM NANUM_USER user1, NANUM_USER user2, following "
				+ "WHERE user1.id = ? AND user2.user_no = following.friend_no "
				+ "AND user1.user_no = following.user_no";
					
		jdbcUtil.setSqlAndParameters(query, new Object[] {user_id});
								
		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<User> friendList = new ArrayList<User>();	
						
			while (rs.next()) {
				User dto = new User(
						rs.getInt("userNo"),
						rs.getString("userId"),
						rs.getInt("friendNo"),
						rs.getString("friendId"));
				friendList.add(dto);
			}
			return friendList;					
		} catch (Exception ex) {
			ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
		return null;
	}
	
	public int requestFollowing(User following) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Following VALUES(?, ?)";
				
		Object[] param = new Object[] {following.getFriendNo(), following.getUserNo()};		
				
		jdbcUtil.setSqlAndParameters(query, param);
				
		 try {
			 int result = jdbcUtil.executeUpdate();  
	         return result;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      } finally {      
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }      
	      return 0;
	}
	
	public int cancelFollowing(int friend_no) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM FOLLOWING WHERE friend_no = ?";
								
		jdbcUtil.setSqlAndParameters(query, new Object[] {friend_no});
								
		try {
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return 0;
	}
	
//	public int insertPoint(int user_no) { //포인트 다시 입력
//		// TODO Auto-generated method stub
//		String query = "UPDATE NANUM_USER "
//				+ "SET point = point + 10 "
//				+ "WHERE user_no = ?";
//				
//		jdbcUtil.setSqlAndParameters(query, new Object[] {user_no});
//				
//		try {
//			int result = jdbcUtil.executeUpdate();	// update 문 실행
//			return result;
//		} catch (Exception ex) {
//			jdbcUtil.rollback();
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.commit();
//			jdbcUtil.close();	// resource 반환
//		}
//		return 0;
//	}
//	
//	public int deletePoint(int user_no) { //포인트 감소
//		// TODO Auto-generated method stub
//		String query = "UPDATE NANUM_USER "
//				+ "SET point = point - 10 "
//				+ "WHERE user_no = ?";
//						
//		jdbcUtil.setSqlAndParameters(query, new Object[] {user_no});
//						
//		try {
//			int result = jdbcUtil.executeUpdate();	// update 문 실행
//			return result;
//		} catch (Exception ex) {
//			jdbcUtil.rollback();
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.commit();
//			jdbcUtil.close();	// resource 반환
//		}
//		return 0;
//	}
}
