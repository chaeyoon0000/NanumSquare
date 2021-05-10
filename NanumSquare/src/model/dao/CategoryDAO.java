package model. dao;

import model.Category;
import model.Circle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;

public class CategoryDAO {
	private JDBCUtil jdbcUtil = null;
	
	private static String Query =  "SELECT cat_no, cat_name " +
			   "FROM CATEGORY " + "ORDER BY cat_no";

	public CategoryDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<Category> getCategoryList() throws SQLException {
		String searchQuery = Query ; //+ "WHERE CATEGORY.CAT_NAME = ?";
		
		jdbcUtil.setSqlAndParameters(searchQuery, null);
	      
	      try {
	         ResultSet rs = jdbcUtil.executeQuery();      // query �� ����
	         List<Category> list = new ArrayList<Category>();      //Category ����Ʈ ����
	         
	         while (rs.next()) {
	        	 Category cat = new Category(  // Category ��ü�� �����Ͽ� ���� ���� ������ ����
	        	 rs.getInt("cat_no"),
	        	 rs.getString("cat_name"));
	             list.add(cat);   // List�� Category ��ü ����
	         }
	         return list;
	         
	         
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close(); // resource ��ȯ
	      }
	      
	      return null;
	}
	
	public Category findCategory(Integer catNo) throws SQLException {
        String sql = "SELECT t.cat_no, t.cat_name "
        		+ "FROM Circle c LEFT OUTER JOIN Category t ON c.cat_no = t.cat_no "
        		+ "WHERE t.cat_no = ? ";	
//        String sql = "SELECT circle_no, user_no, title, context, upload_date, end_date, image, cnt, loc, state, max "
//        		+ "FROM Circle c LEFT OUTER JOIN Category t ON c.cat_no = t.cat_no "
//        		+ "WHERE cat_no = ? ";	   
        
        
        System.out.println(catNo + "�̰ž� �̰ž� �̰ž� findCategory ///////////////////");
        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {catNo});	// JDBCUtil�� query���� �Ű� ���� ����
		
		Category cat = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// circle ���� �߰�
				cat = new Category(		// Circle ��ü�� �����Ͽ� circle ������ ����,
						catNo,
						rs.getString("cat_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return cat;
	}
	
	public List<Circle> findCategoryInCircle(int catNo) throws SQLException {
	        String sql ="SELECT circle_no, NANUM_USER.name, CIRCLE.cat_no, title, content, " + 
					"upload_date, cnt, loc, state, end_date, image, max " + 
					"FROM CIRCLE, NANUM_USER, CATEGORY " + 
					"WHERE CIRCLE.user_no = NANUM_USER.user_no "
					+ "and CIRCLE.cat_no = CATEGORY.cat_no "
					+ "and CATEGORY.cat_no = ? and CIRCLE.circle_no <> ? "
					+ "ORDER BY upload_date";                   
		jdbcUtil.setSqlAndParameters(sql, new Object[] {catNo});	// JDBCUtil�� query���� �Ű� ���� ����
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
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
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

}

//public interface CategoryDAO {
//	
//	public List<Category> getCategoryList() throws SQLException; // ī�װ��� ���� ����Ʈ ��ȯ 
//	//public List<Category> searchStudent(String title); //ī�װ��� �˻�
//
///*	public int insertCat(Category cat); //ī�װ� �߰�
//	public int updateCat(Category cat); //ī�װ� ����
//	public int deleteCat(Category cat); //ī�װ� ����
//*/
//	}

