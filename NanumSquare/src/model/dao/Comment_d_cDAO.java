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
		
//		jdbcUtil.setSql(selectQuery);		// JDBCUtil �� query ����

		jdbcUtil.setSqlAndParameters(Query, null);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			List<Comment_dchild> list = new ArrayList<Comment_dchild>();		// Diary ��ü���� ������� list ��ü
			
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
			
			return list;		// Diary������ ������ dto ���� ����� ��ȯ
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		
		return null;
	}

	public int insertComment_d_c(Comment_dchild comment_d_c) {
		// TODO Auto-generated method stub
		
		String insertQuery = "INSERT INTO COMMENT_D_C (COMMENT2_NO, UPLOAD_DATE, CONTENT, COMMENT_NO, USER_NO) " +
							"VALUES (SEQ_COMMENT_D_C.NEXTVAL, SYSDATE, ?, ?, ?) ";
		
		Object[] param = new Object[] {comment_d_c.getContent(), comment_d_c.getdParent(), comment_d_c.getUserNo()};		

		jdbcUtil.setSqlAndParameters(insertQuery, param);			// JDBCUtil �� insert �� ����	
		
		String key[] = {"COMMENT2_NO"};
		
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

	public int updateComment_d_c(Comment_dchild comment_d_c) {
		// TODO Auto-generated method stub
		
		String updateQuery = "UPDATE STUDENT SET ";
		
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (comment_d_c.getContent() != null) {		// ������ �����Ǿ� ���� ���
			updateQuery += "CONTENT = ?, ";
			tempParam[index++] = comment_d_c.getContent();
		}
		
		updateQuery += "WHERE COMMENT_NO = ? ";		// update ���� ���� ����
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update ���� where �� �տ� ���� �� �ִ� , ����
//		
//		tempParam[index++] = comment_d_c.getDCommentNo();		
		
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

	public int deleteComment_d_c(int commentNo) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM COMMENT_D_C WHERE COMMENT2_NO = ?";
		
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
