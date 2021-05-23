package model.dao;

import java.sql.ResultSet;
import java.util.*;

import model.dao.JDBCUtil;
import model.QnA;

public class QnADAO {
	
	private JDBCUtil jdbcUtil = new JDBCUtil();
	
	public List<QnA> getQnAList() {
		// TODO Auto-generated method stub
		String query = "SELECT post_no, title, content, upload_date, NANUM_USER.user_no, id "
					+ "FROM QNA, NANUM_USER "
					+ "WHERE QNA.user_no = NANUM_USER.user_no "
					+ "ORDER BY post_no";
		
		jdbcUtil.setSqlAndParameters(query, null);		// JDBCUtil에 query문 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<QnA> qnaList = new ArrayList<QnA>();
			
			while (rs.next()) {
				QnA qna = new QnA(
						rs.getInt("post_no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("upload_date"),
						rs.getInt("user_no"),
						rs.getString("id"));
				qnaList.add(qna);
			}			
			return qnaList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	
	public QnA getDetailQnA(int post_no) {
		
		String query = "SELECT post_no, title, content, upload_date, user_no "
    			+ "FROM QNA "
    			+ "WHERE post_no = ?";  
		
		jdbcUtil.setSqlAndParameters(query, new Object[] {post_no});	// JDBCUtil에 query문과 매개 변수 설정

		QnA qna = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				qna = new QnA(
						post_no,
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("upload_date"),
						rs.getInt("user_no"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return qna;
	}


	public QnA insertQnA(QnA qna) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO QNA (post_no, title, content, upload_date, user_no) "
				+ "VALUES(SEQ_QNA.NEXTVAL, ?, ?, SYSDATE, ?)";
		
		Object[] param = new Object[] {qna.getTitle(), qna.getContent(), qna.getUserNo()};		
		
		jdbcUtil.setSqlAndParameters(query, param);
		
		String key[] = {"post_no"}; //pk 컬럼 값의 이름
		
		try {				
			//jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	//ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	
		 
		   	int generatedKey = jdbcUtil.executeUpdate();   // 생성된 PK 값
		   	qna.setPostNo(generatedKey);
		   	
		   	return qna;
		   	
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}	
		return null;
	}


	public int updateQnA(QnA qna) {
		// TODO Auto-generated method stub
		String query = "UPDATE QNA "
				+ "SET title = ?, content = ? "
				+ "WHERE post_no = ?";
		
		Integer qPostNo = qna.getPostNo();
		
		if (qPostNo.equals("")) 
			qPostNo = null;
		
		Object[] param = new Object[] {qna.getTitle(), qna.getContent(), qPostNo};
		
		jdbcUtil.setSqlAndParameters(query, param);
		
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


	public int deleteQnA(int post_no) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM QNA WHERE post_no = ?";
		
		jdbcUtil.setSqlAndParameters(query, new Object[] {post_no});
		
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


	public List<QnA> getQnAByKeyword(String keyword) {
		// TODO Auto-generated method stub
		String query = "SELECT post_no, title, content, upload_date, user_no "
				+ "FROM QNA "
				+ "WHERE title LIKE ? OR content LIKE ?";

		String k = "%"+ keyword +"%";
		Object[] param = new Object[] {k, k};
		
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<QnA> qnaList = new ArrayList<QnA>();
			
			while (rs.next()) {
				QnA dto = new QnA(
						rs.getInt("post_no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("upload_date"),
						rs.getInt("user_no"));
				qnaList.add(dto);
			}
			return qnaList;			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}


	public List<QnA> getQnAByUser(String id) {
		String query = "SELECT post_no, title, content, upload_date, id "
				+ "FROM QNA, NANUM_USER "
				+ "WHERE QNA.user_no = NANUM_USER.user_no "
				+ "AND id = ?";
		
		jdbcUtil.setSqlAndParameters(query, new Object[] {id});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<QnA> qnaList = new ArrayList<QnA>();
			
			while (rs.next()) {
				QnA dto = new QnA(
						rs.getInt("post_no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("upload_date"),
						id);
				qnaList.add(dto);
			}
			return qnaList;			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
