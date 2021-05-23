package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment_d;
import model.QnA;

public class Comment_dDAO {

	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT COMMENT_D.COMMENT_NO AS COMMENT_NO, " +
				"       COMMENT_D.UPLOAD_DATE AS UPLOAD_DATE, " +
				"       COMMENT_D.CONTENT AS CONTENT, " +
				"       COMMENT_D.USER_NO AS USER_NO, " +
				"       COMMENT_D.DIARY_NO AS DIARY_NO " +
				"		FROM COMMENT_D ";
	
	public Comment_dDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<Comment_d> getComment_dList() {
		// TODO Auto-generated method stub
		String allQuery = query;		
		
//		jdbcUtil.setSql(allQuery);		// JDBCUtil �� query ����

		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			
			List<Comment_d> list = new ArrayList<Comment_d>();	
			
			while (rs.next()) {
				Comment_d dto = new Comment_d();
				
				dto.setCommentNo(rs.getInt("COMMENT_NO"));
				dto.setUserNo(rs.getInt("USER_NO"));
				dto.setDiaryNo(rs.getInt("DIARY_NO"));
			    dto.setUploadDate(rs.getDate("UPLOAD_DATE"));
			    dto.setContent(rs.getString("CONTENT"));
				
				list.add(dto);
			}
			
			return list;		// Diary������ ������ dto ���� ����� ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		
		return null;	
	}

	public List<Comment_d> Comment_dList(int diaryNo) {
		// TODO Auto-generated method stub
		String Query = "SELECT COMMENT_D.COMMENT_NO, NANUM_USER.name, COMMENT_D.UPLOAD_DATE, COMMENT_D.CONTENT, COMMENT_D.DIARY_NO, COMMENT_D.USER_NO "
				+ "FROM COMMENT_D, NANUM_USER "
				+ "WHERE COMMENT_D.DIARY_NO = ? "
				+ "AND NANUM_USER.user_no = COMMENT_D.user_no "
				+ "ORDER BY COMMENT_NO";
		
//		jdbcUtil.setSql(selectQuery);		// JDBCUtil �� query ����

		Object[] param = new Object[] { diaryNo };
		jdbcUtil.setSqlAndParameters(Query, param);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			List<Comment_d> list = new ArrayList<Comment_d>();		// Diary ��ü���� ������� list ��ü
			
			while (rs.next()) {
			    Comment_d dto = new Comment_d(
				rs.getInt("COMMENT_NO"),
				rs.getInt("DIARY_NO"),
				rs.getString("name"),
				rs.getInt("USER_NO"),
				rs.getString("CONTENT"),
				rs.getDate("UPLOAD_DATE"));
				
				list.add(dto);
			}
			
			return list;		// Diary������ ������ dto ���� ����� ��ȯ
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		
		return null;
	}

	public int insertComment_d(Comment_d comment_d) {
		// TODO Auto-generated method stub
		
		String insertQuery = "INSERT INTO COMMENT_D (COMMENT_NO, UPLOAD_DATE, CONTENT, DIARY_NO, USER_NO) " +
							"VALUES (SEQ_COMMENT_D.NEXTVAL, SYSDATE, ?, ?, ?) ";
		
		Object[] param = new Object[] {comment_d.getContent(), comment_d.getDiaryNo(), comment_d.getUserNo()};		

		jdbcUtil.setSqlAndParameters(insertQuery, param);			// JDBCUtil �� insert �� ����	
		
		String key[] = {"COMMENT_NO"};
		
		try {				
			int rs = jdbcUtil.executeUpdate();
//			ResultSet rs = jdbcUtil.getGeneratedKeys();		// insert �� ����
			
//
//		   	int generatedKey = rs.getInt(1);   // ������ PK ��
//			
		   	return rs;
		   	
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		
		return 0;	
	}

	public int updateComment_d(Comment_d comment_d) {
		// TODO Auto-generated method stub
		
		String updateQuery = "UPDATE STUDENT SET ";
		
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (comment_d.getContent() != null) {		// ������ �����Ǿ� ���� ���
			updateQuery += "CONTENT = ?, ";
			tempParam[index++] = comment_d.getContent();
		}
		
		updateQuery += "WHERE COMMENT_NO = ? ";		// update ���� ���� ����
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update ���� where �� �տ� ���� �� �ִ� , ����
		
		tempParam[index++] = comment_d.getCommentNo();		
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// �Ű������� ������ŭ�� ũ�⸦ ���� �迭�� �����ϰ� �Ű����� �� ����
			newParam[i] = tempParam[i];
		
//		jdbcUtil.setSql(updateQuery);			// JDBCUtil�� update �� ����
//		jdbcUtil.setParameters(newParam);		// JDBCUtil �� �Ű����� ����
		
		try {
			int result = jdbcUtil.executeUpdate();		// update �� ����
			return result;			// update �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return 0;
	}

	public int deleteComment_d(int commentNo) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM COMMENT_D WHERE COMMENT_NO = ?";
		
		Object[] param = new Object[] {commentNo};
		jdbcUtil.setSqlAndParameters(deleteQuery, param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
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
			
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		
		} catch (Exception ex) {
		
			jdbcUtil.rollback();
			ex.printStackTrace();		
		
		} finally {
		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		
		}
		
		return 0;
	}
	
}
