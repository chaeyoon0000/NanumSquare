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
	         ResultSet rs = jdbcUtil.executeQuery();      // query 문 실행
	         List<Category> list = new ArrayList<Category>();      //Category 리스트 생성
	         
	         while (rs.next()) {
	        	 Category cat = new Category(  // Category 객체를 생성하여 현재 행의 정보를 저장
	        	 rs.getInt("cat_no"),
	        	 rs.getString("cat_name"));
	             list.add(cat);   // List에 Category 객체 저장
	         }
	         return list;
	         
	         
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close(); // resource 반환
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
        
        
        System.out.println(catNo + "이거야 이거야 이거야 findCategory ///////////////////");
        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {catNo});	// JDBCUtil에 query문과 매개 변수 설정
		
		Category cat = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// circle 정보 발견
				cat = new Category(		// Circle 객체를 생성하여 circle 정보를 저장,
						catNo,
						rs.getString("cat_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
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
		jdbcUtil.setSqlAndParameters(sql, new Object[] {catNo});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
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
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

}

//public interface CategoryDAO {
//	
//	public List<Category> getCategoryList() throws SQLException; // 카테고리에 대한 리스트 반환 
//	//public List<Category> searchStudent(String title); //카테고리별 검색
//
///*	public int insertCat(Category cat); //카테고리 추가
//	public int updateCat(Category cat); //카테고리 갱신
//	public int deleteCat(Category cat); //카테고리 삭제
//*/
//	}

