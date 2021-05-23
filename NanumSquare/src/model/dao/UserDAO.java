package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO{
	
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();
	}
	
	public int getSeq()
    {
		String sql = "SELECT SEQ_NANUM_USER.NEXTVAL FROM DUAL";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		int userNo = 0;
        
        try {
        	ResultSet rs = jdbcUtil.executeQuery();	
            
            if(rs.next())
            	userNo = rs.getInt("NEXTVAL");
 
        } catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
        
        return userNo;    
    }

	public int create(User user) {
		String sql = "INSERT INTO NANUM_USER (user_no, id, name, passwd, phone, email, address, point) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {user.getUserNo(), user.getId(), user.getName(), 
				user.getPasswd(), user.getPhone(), user.getEmail(), user.getAddress(), user.getPoint()};
		
		jdbcUtil.setSqlAndParameters(sql, param);

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;			
	}

	public int update(User user) {
		String sql = "UPDATE NANUM_USER "
				+ "SET passwd=?, phone=?, address=?, email=? "
				+ "WHERE user_no=?";
		Object[] param = new Object[] {user.getPasswd(), user.getPhone(), 
					user.getAddress(), user.getEmail()};
		
		jdbcUtil.setSqlAndParameters(sql, param);
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
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

	public int remove(String id) {
		String sql = "DELETE FROM NANUM_USER WHERE id=?";	
		
		jdbcUtil.setSqlAndParameters(sql, null);

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	public User findUser(String id) {
		String sql = "SELECT user_no, id, passwd, name, email, phone, address, point "
    			+ "FROM NANUM_USER "
    			+ "WHERE id=?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {id});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				User user = new User(
					rs.getInt("user_no"),
					id,
					rs.getString("name"),
					rs.getString("passwd"),
					rs.getString("point"),
					rs.getString("email"),
					rs.getString("address"),
					rs.getInt("point"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public User findUser(Integer userNo) {
		String sql = "SELECT user_no, id, passwd, name, email, phone, address, point "
    			+ "FROM NANUM_USER "
    			+ "WHERE user_no=?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {userNo});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				User user = new User(
					userNo,
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("passwd"),
					rs.getString("point"),
					rs.getString("email"),
					rs.getString("address"),
					rs.getInt("point"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<User> findUserList() {
		 String sql = "SELECT user_no, id, passwd, name, email, phone, address, point " 
      		   + "FROM NANUM_USER "
      		   + "ORDER BY user_no";
		 jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
			while (rs.next()) {
				User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("user_no"),
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("passwd"),
						rs.getString("point"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getInt("point"));
				userList.add(user);				// List에 User 객체 저장
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<User> findUserList(int currentPage, int countPerPage) {
        String sql = "SELECT userId, password, name, email, phone " 
     		   + "FROM USERINFO "
     		   + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
				do {
					User user = new User(		// User 객체를 생성하여 현재 행의 정보를 저장
							rs.getInt("user_no"),
							rs.getString("id"),
							rs.getString("name"),
							rs.getString("passwd"),
							rs.getString("point"),
							rs.getString("email"),
							rs.getString("address"),
							rs.getInt("point"));
					userList.add(user);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	public boolean existingUser(String id) {
		String sql = "SELECT count(*) FROM USERINFO WHERE id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

	public User getMyPage(String id) {
		
		 String query = "SELECT user_no, id, passwd, name, email, phone, address, point " 
   		   + "FROM NANUM_USER "
   		   + "WHERE id = ?";
			
			jdbcUtil.setSqlAndParameters(query, new Object[] {id});	// JDBCUtil에 query문과 매개 변수 설정

			User user = null;
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				
				if (rs.next()) {
					user = new User(
							rs.getInt("user_no"),
							id,
							rs.getString("name"),
							rs.getString("passwd"),
							rs.getString("phone"),
							rs.getString("email"),
							rs.getString("address"),
							rs.getInt("point"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return user;
	}

	public int addPoint(String userId, Integer point) {
		String sql = "INSERT INTO NANUM_USER (point) "
				+ "VALUES (?) WHERE id = ? ";		
		Object[] param = new Object[] {userId, point};
		
		jdbcUtil.setSqlAndParameters(sql, param);

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;	
	}
}
