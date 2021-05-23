package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment_d;
import model.Comment_dchild;

public class Comment_d_cDAO {

	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT COMMENT_D.COMMENT_NO AS COMMENT_NO, " +
				"       COMMENT_D.UPLOAD_DATE AS UPLOAD_DATE, " +
				"       COMMENT_D.CONTENT AS CONTENT, " +
				"       COMMENT_D.USER_NO AS USER_NO, " +
				"       COMMENT_D.DIARY_NO AS DIARY_NO " +
				"		FROM COMMENT_D ";
	
	public Comment_d_cDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public List<Comment_dchild> Comment_d_cList() {
		// TODO Auto-generated method stub
		String Query = "SELECT COMMENT_D_C.COMMENT2_NO, NANUM_USER.name, COMMENT_D_C.UPLOAD_DATE, COMMENT_D_C.CONTENT, COMMENT_D_C.COMMENT_NO, COMMENT_D_C.USER_NO "
				+ "FROM COMMENT_D_C, NANUM_USER "
				+ "WHERE NANUM_USER.user_no = COMMENT_D_C.user_no "
				+ "ORDER BY COMMENT2_NO";
		
//		jdbcUtil.setSql(selectQuery);		// JDBCUtil 에 query 설정

		jdbcUtil.setSqlAndParameters(Query, null);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행			
			List<Comment_dchild> list = new ArrayList<Comment_dchild>();		// Diary 객체들을 담기위한 list 객체
			
			while (rs.next()) {
			    Comment_dchild dto = new Comment_dchild(
				rs.getInt("COMMENT2_NO"),
				rs.getInt("USER_NO"),
				rs.getString("name"),
				rs.getInt("COMMENT_NO"),
				rs.getString("CONTENT"),
				rs.getDate("UPLOAD_DATE"));
				
				list.add(dto);
			}
			
			return list;		// Diary정보를 저장한 dto 들의 목록을 반환
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		
		return null;
	}

	public int insertComment_d_c(Comment_dchild comment_d_c) {
		// TODO Auto-generated method stub
		
		String insertQuery = "INSERT INTO COMMENT_D_C (COMMENT2_NO, UPLOAD_DATE, CONTENT, COMMENT_NO, USER_NO) " +
							"VALUES (SEQ_COMMENT_D_C.NEXTVAL, SYSDATE, ?, ?, ?) ";
		
		Object[] param = new Object[] {comment_d_c.getContent(), comment_d_c.getdParent(), comment_d_c.getUserNo()};		

		jdbcUtil.setSqlAndParameters(insertQuery, param);			// JDBCUtil 에 insert 문 설정	
		
		String key[] = {"COMMENT2_NO"};
		
		try {				
			int rs = jdbcUtil.executeUpdate();
//			ResultSet rs = jdbcUtil.getGeneratedKeys();		// insert 문 실행
			
//
//		   	int generatedKey = rs.getInt(1);   // 생성된 PK 값
//			
		   	return rs;
		   	
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		
		return 0;	
	}

	public int updateComment_d_c(Comment_dchild comment_d_c) {
		// TODO Auto-generated method stub
		
		String updateQuery = "UPDATE STUDENT SET ";
		
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (comment_d_c.getContent() != null) {		// 제목이 설정되어 있을 경우
			updateQuery += "CONTENT = ?, ";
			tempParam[index++] = comment_d_c.getContent();
		}
		
		updateQuery += "WHERE COMMENT_NO = ? ";		// update 문에 조건 지정
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
//		
//		tempParam[index++] = comment_d_c.getDCommentNo();		
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// 매개변수의 개수만큼의 크기를 갖는 배열을 생성하고 매개변수 값 복사
			newParam[i] = tempParam[i];
		
//		jdbcUtil.setSql(updateQuery);			// JDBCUtil에 update 문 설정
//		jdbcUtil.setParameters(newParam);		// JDBCUtil 에 매개변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return 0;
	}

	public int deleteComment_d_c(int commentNo) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM COMMENT_D_C WHERE COMMENT2_NO = ?";
		
		Object[] param = new Object[] {commentNo};
		jdbcUtil.setSqlAndParameters(deleteQuery, param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}
	
	public int UpdatePoint(int userNo) {
		// TODO Auto-generated method stub
		
		String PointQuery = "UPDATE NANUM_USER "
				+ "SET POINT = POINT + 5 "
				+ "WHERE USER_NO=? ";
	
		Object[] param = new Object[] {userNo};
		jdbcUtil.setSqlAndParameters(PointQuery, param);
	
		try {
			
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			
			return result;						// delete 에 의해 반영된 레코드 수 반환
		
		} catch (Exception ex) {
		
			jdbcUtil.rollback();
			ex.printStackTrace();		
		
		} finally {
		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		
		}
		
		return 0;
	}
	
}
