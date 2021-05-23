package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RankingDiary;

public class RankingDiaryDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public RankingDiaryDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public List<RankingDiary> getDiaryListByLikey() throws SQLException {
		// TODO Auto-generated method stub
		String LikeyQuery = "SELECT ROWNUM, diary_no, title, cnt, likey "
				+ "FROM (SELECT diary_no, title, cnt, likey " 
						+ "FROM diary " 
						+ "ORDER BY likey DESC, title ASC) "
				+ "WHERE ROWNUM <= 10 ";

		jdbcUtil.setSqlAndParameters(LikeyQuery, null);

		

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 문 실행
			List<RankingDiary> list = new ArrayList<RankingDiary>();
			
			while (rs.next()) {
				RankingDiary dto = new RankingDiary(
				rs.getInt("DIARY_NO"),
				rs.getString("TITLE"),
				rs.getInt("CNT"),
				rs.getInt("LIKEY"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return null;
	}

	public List<RankingDiary> getDiaryListByCnt() throws SQLException{
		// TODO Auto-generated method stub

		String CntQuery = "SELECT ROWNUM, diary_no, title, cnt, likey " + 
				"FROM (SELECT diary_no, title, cnt, likey " 
					+ "FROM diary " 
					+ "ORDER BY cnt DESC, title ASC) "
				+ "WHERE ROWNUM <= 10 ";
					
		jdbcUtil.setSqlAndParameters(CntQuery, null);
		
		System.out.println(CntQuery + "1차 cnt쿼리 들어오는지 확인!!!!!!!!!!!!");

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 문 실행
			List<RankingDiary> list = new ArrayList<RankingDiary>();
			
			System.out.println(rs + "1차 rs쿼리 들어오는지 확인~~~~~~~~~~~~~~~~~~~~~~~~");
			
			while (rs.next()) {
				RankingDiary dto = new RankingDiary(
				rs.getInt("DIARY_NO"),
				rs.getString("TITLE"),
				rs.getInt("CNT"),
				rs.getInt("LIKEY"));
				System.out.println("몇번되나");
				list.add(dto);
			}
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return null;

	}

//	public List<Circle> getCircleListByCnt() {
//		String sql = "SELECT circle_no, NANUM_USER.id, CIRCLE.cat_no, title, content, "
//				+ "upload_date, cnt, loc, state, end_date, image, max " + "FROM CIRCLE, NANUM_USER "
//				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no " + "ORDER BY upload_date DESC";
//
//		jdbcUtil.setSqlAndParameters(sql, null);
//
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();
//			List<Circle> circleList = new ArrayList<Circle>();
//			while (rs.next()) {
//				Circle circle = new Circle(rs.getInt("circle_no"), rs.getString("id"), rs.getString("title"),
//						rs.getString("content"), rs.getInt("cat_no"), rs.getDate("upload_date"), rs.getString("loc"),
//						rs.getDate("end_date"), rs.getString("image"), rs.getInt("max"), rs.getInt("cnt"),
//						rs.getInt("state"));
//				circleList.add(circle);
//			}
//			return circleList;
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();
//		}
//		return null;
//	}

}
