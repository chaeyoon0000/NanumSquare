package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.RankingCircle;

public class RankingCircleDAO {

	private JDBCUtil jdbcUtil = null;
	
	public RankingCircleDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<RankingCircle> getCircleListByCnt() {
//		String sql = "SELECT circle_no, NANUM_USER.id, CIRCLE.cat_no, title, content, "
//				+ "upload_date, cnt, loc, state, end_date, image, max " + "FROM CIRCLE, NANUM_USER "
//				+ "WHERE CIRCLE.user_no = NANUM_USER.user_no " + "ORDER BY upload_date DESC";
		
		String CntQuery = "SELECT ROWNUM, circle_no, title, cnt "
				+ "FROM (SELECT circle_no, title, cnt "
					+ "FROM circle "
					+ "ORDER BY cnt DESC, title ASC) "
				+ "WHERE ROWNUM <= 10 ";

		jdbcUtil.setSqlAndParameters(CntQuery, null);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<RankingCircle> list = new ArrayList<RankingCircle>();
			while (rs.next()) {
				RankingCircle circle = new RankingCircle(
						rs.getInt("CIRCLE_NO"),
						rs.getString("TITLE"),
						rs.getInt("CNT"));
						
						list.add(circle);
			}
			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
