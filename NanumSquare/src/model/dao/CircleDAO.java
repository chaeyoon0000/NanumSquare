package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.JDBCUtil;
import model.Circle;
import model.User;

public class CircleDAO{
	private JDBCUtil jdbcUtil = null;
	
	public CircleDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	String select_sql = "SELECT circle_no, user_no, cat_no, title, content, "
			+ "upload_date, cnt, loc, state, end_date, image, max "
			+ "FROM CIRCLE ";
	
	public int getSeq()
    {
		String sql = "SELECT SEQ_CIRCLE.NEXTVAL FROM DUAL";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		int circle_no = 0;
        
        try {
        	ResultSet rs = jdbcUtil.executeQuery();	
            
            if(rs.next())
            	circle_no = rs.getInt("NEXTVAL");
 
        } catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
        
        return circle_no;    
    }
	
	public Circle getCircleByNo(Integer circleNo) {
		select_sql = select_sql + "WHERE circle_no=? ";
		
		jdbcUtil.setSqlAndParameters(select_sql, new Object[] {circleNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				Circle circle = new Circle(circleNo,
						rs.getInt("user_no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				return circle;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
//	public Circle getCircleByNo(Integer circleNo, Integer userNo) {
//		String sql = "SELECT circle_no, user_name, title, content, cat_name, "
//				+ "upload_date, loc, end_date, image, max, cnt, state "
//				+ "FROM CIRCLE, CATEGORY, NANUM_USER " 
//				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no AND CIRCLE.cat_no = CATGORY.cat_no "
//				+ "AND circle_no=? AND cat_no = ?;";
//		
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo, userNo});
//	
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();	
//			if (rs.next()) {					
//				Circle circle = new Circle(circleNo,
//						rs.getString("user_name"),
//						rs.getString("title"),
//						rs.getString("content"),
//						rs.getString("cat_name"),
//						rs.getDate("upload_date"),
//						rs.getString("loc"),
//						rs.getDate("end_date"),
//						rs.getString("image"),
//						rs.getInt("max"),
//						rs.getInt("cnt"),
//						rs.getInt("state"));
//				return circle;
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();
//		}
//		return null;
//	}

	public String getUserNameByCircleNo(Integer circleNo) {
		String sql = "SELECT user_name FROM USER, CIRCLE "
				+ "WHERE USER.user_no = CIRCLE.user_no "
				+ "AND CIRCLE.circle_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				String userName = rs.getString("user_name");
				return userName;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<Circle> getCircleList() {
		String sql = "SELECT circle_no, NANUM_USER.id, CIRCLE.cat_no, title, content, "
				+ "upload_date, cnt, loc, state, end_date, image, max "
				+ "FROM CIRCLE, NANUM_USER "
				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no "
				+ "ORDER BY upload_date DESC";
		
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Circle> circleList = new ArrayList<Circle>(); 
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);	
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	

	public List<Circle> getCircleByCategory(Integer catNo) {
		String select_sql = "SELECT circle_no, NANUM_USER.name, CIRCLE.cat_no, title, content, " + 
				"upload_date, cnt, loc, state, end_date, image, max " + 
				"FROM CIRCLE, NANUM_USER, CATEGORY " + 
				"WHERE CIRCLE.user_no = NANUM_USER.user_no and CIRCLE.cat_no = CATEGORY.cat_no and CATEGORY.cat_no = ? "
				+ "ORDER BY upload_date desc";
		
//		CategoryDAOimpl catimpl = new CategoryDAOimpl();
//		Integer catNo = catimpl.getCategoryNoByName(catNo);
		
		jdbcUtil.setSqlAndParameters(select_sql, new Object[] {catNo});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<Circle> circleList = new ArrayList<Circle>();
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						rs.getString("name"),
						rs.getString("title"),
						rs.getString("content"),
						catNo,
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Circle> getCircleByUserNo(Integer userNo) {
		select_sql += select_sql + "WHERE user_no = ? "
				+ "ORDER BY upload_date desc";
		
		jdbcUtil.setSqlAndParameters(select_sql, new Object[] {userNo});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<Circle> circleList = new ArrayList<Circle>();
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						userNo,
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);	
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int insertCircle(Circle circle) {
		String sql = "INSERT INTO DBP0101.CIRCLE (circle_no, user_no, cat_no, title, content, upload_date, "
				+ "cnt, loc, state, end_date, image, max) "
				+ "VALUES (?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {circle.getCircleNo(), circle.getWriter(), circle.getCategory(), 
				circle.getTitle(), circle.getContent(), circle.getCnt(), 
				circle.getLoc(), circle.getState(), circle.getEndDate(), circle.getImage(), circle.getMax()};
		//"DBP0101.SEQ_CIRCLE.nextval"
		for(int i = 0; i < param.length; i++)
			System.out.println(param[i]);
		
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

	public int updateCircle(Circle circle) {
		String sql = "UPDATE CIRCLE "
				+ "SET circle_no = ?, user_no = ?, cat_no = ?, title = ?, content = ?, "
				+ "cnt = ?, loc = ?, state = ?, end_date = ?, image = ?, max = ? "
				+ "WHERE circle_no = ?";
		
		Object[] param = new Object[] {circle.getCircleNo(), circle.getWriter(), circle.getCategory(), 
				circle.getTitle(), circle.getContent(), circle.getCnt(), 
				circle.getLoc(), circle.getState(), circle.getEndDate(), circle.getImage(), circle.getMax(), circle.getCircleNo()};
		
		jdbcUtil.setSqlAndParameters(sql, param);
			
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

	public int deleteCircle(Integer circleNo) {
		String sql = "DELETE FROM CIRCLE WHERE circle_no=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo});	

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

	public List<Circle> getCircleByCategory(Integer catNo, Integer circleNo) {
		String select_sql = "SELECT circle_no, NANUM_USER.name, CIRCLE.cat_no, title, content, " + 
				"upload_date, cnt, loc, state, end_date, image, max " + 
				"FROM CIRCLE, NANUM_USER, CATEGORY " + 
				"WHERE CIRCLE.user_no = NANUM_USER.user_no "
				+ "and CIRCLE.cat_no = CATEGORY.cat_no "
				+ "and CATEGORY.cat_no = ? and CIRCLE.circle_no <> ? "
				//+ "and ROWNUM = 4 "
				+ "ORDER BY upload_date";
		
		jdbcUtil.setSqlAndParameters(select_sql, new Object[] {catNo, circleNo});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<Circle> circleList = new ArrayList<Circle>();
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						rs.getString("name"),
						rs.getString("title"),
						rs.getString("content"),
						catNo,
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int updateCircleByEndDate(Integer circleNo) {
		String sql = "UPDATE CIRCLE SET state = CIRCLE.max WHERE circle_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo});
		
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

	public Circle getCircleDetailByNo(Integer circleNo) {	
		String select_sql = "SELECT circle_no, NANUM_USER.id, CATEGORY.cat_no, CATEGORY.cat_name, "
		+ "title, content, upload_date, cnt, loc, state, end_date, image, max "
		+ "FROM CIRCLE, NANUM_USER, CATEGORY "
		+ "WHERE CIRCLE.user_no = NANUM_USER.user_no "
		+ "AND CIRCLE.cat_no = CATEGORY.cat_no AND circle_no = ?";
		
		jdbcUtil.setSqlAndParameters(select_sql, new Object[] {circleNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				Circle circle = new Circle(circleNo,
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getString("cat_name"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				return circle;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public String getCircleEndDate(Integer circleNo)
    { 
		String sql = "SELECT TO_CHAR(end_date,'YYYY-MM-DD HH24:MI') AS end FROM circle WHERE circle_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo});
		
		String endDate = "";
        
        try {
        	ResultSet rs = jdbcUtil.executeQuery();	
            
            if(rs.next())
            	endDate = rs.getString("end");
 
        } catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
        
        return endDate;    
    }

	public int insertUserCircle(Integer userNo, Integer circleNo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USER_CIRCLE (circle_no, user_no, apply_date) "
				+ "VALUES (?, ?, SYSDATE)";
		Object[] param = new Object[] {circleNo, userNo};
		
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

	public int updateCircleState(Integer circleNo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CIRCLE SET state = state + 1 WHERE circle_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo});
		
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

	public int updateCircleCnt(Integer circleNo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CIRCLE SET cnt = cnt + 1 WHERE circle_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {circleNo});
		
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

	public List<User> getUserCircle(Integer circleNo) {
		// TODO Auto-generated method stub
		String select_sql = "SELECT id, TO_CHAR(apply_date,'YYYY-MM-DD HH24:MI') AS applyDate "
				+ "FROM user_circle, nanum_user "
				+ "WHERE user_circle.user_no = nanum_user.user_no "
				+ "AND user_circle.circle_no = ? "
				+ "ORDER BY apply_date";
		
		jdbcUtil.setSqlAndParameters(select_sql, new Object[] {circleNo});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<User> applyList = new ArrayList<User>();
			while (rs.next()) {						
				User user = new User(rs.getString("id"), 
						rs.getString("applyDate"));
				applyList.add(user);
			}
			return applyList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Circle> getCircleListByKeyword(String keyword) {
		String sql = "SELECT circle_no, NANUM_USER.id, CIRCLE.cat_no, title, content, "
				+ "upload_date, cnt, loc, state, end_date, image, max "
				+ "FROM CIRCLE, NANUM_USER "
				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no "
				+ "AND title LIKE '%" + keyword + "%' "
				+ "ORDER BY upload_date DESC";
		
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Circle> circleList = new ArrayList<Circle>(); 
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);	
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Circle> getRecruitingCircleListByKeyword(String keyword) {
		String sql = "SELECT circle_no, NANUM_USER.id, CIRCLE.cat_no, title, content, "
				+ "upload_date, cnt, loc, state, end_date, image, max "
				+ "FROM CIRCLE, NANUM_USER "
				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no "
				+ "AND title LIKE '%" + keyword + "%' "
				+ "AND state < max "
				+ "ORDER BY upload_date DESC";
		
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Circle> circleList = new ArrayList<Circle>(); 
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);	
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Circle> getCompletedCircleListByKeyword(String keyword) {
		String sql = "SELECT circle_no, NANUM_USER.id, CIRCLE.cat_no, title, content, "
				+ "upload_date, cnt, loc, state, end_date, image, max "
				+ "FROM CIRCLE, NANUM_USER "
				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no "
				+ "AND title LIKE '%" + keyword + "%' "
				+ "AND state = max "
				+ "ORDER BY upload_date DESC";
		
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Circle> circleList = new ArrayList<Circle>(); 
			while (rs.next()) {						
				Circle circle = new Circle(rs.getInt("circle_no"), 
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("cat_no"),
						rs.getDate("upload_date"),
						rs.getString("loc"),
						rs.getDate("end_date"),
						rs.getString("image"),
						rs.getInt("max"),
						rs.getInt("cnt"),
						rs.getInt("state"));
				circleList.add(circle);	
			}
			return circleList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
