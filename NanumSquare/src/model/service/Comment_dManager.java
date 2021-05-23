package model.service;

import java.sql.SQLException;
import java.util.List;
import model.dao.Comment_dDAO;
import model.Comment_d;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * Comment_dDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */

public class Comment_dManager {
	private static Comment_dManager Comment_d = new Comment_dManager();
	private Comment_dDAO Comment_dDAO;
//	private Comment_dAnalysis Comment_dAanlysis; 필요하면 설정하기!

	private Comment_dManager() {
		try {
			Comment_dDAO = new Comment_dDAO();
//			Comment_dAanlysis = new Comment_dAnalysis(Comment_dDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static Comment_dManager getInstance() {
		return Comment_d;
	}
	
	public List<Comment_d> getComment_dList() throws Exception {
		return Comment_dDAO.getComment_dList();
	}
	

	public List<Comment_d> Comment_dList(int diaryNo) throws Exception {
		return Comment_dDAO.Comment_dList(diaryNo);
	}
	
	// Insert
	public int insertComment_d(Comment_d comment_d) throws SQLException {
		return Comment_dDAO.insertComment_d(comment_d);
	}

	// Update
	public int updateComment_d(Comment_d comment_d) throws Exception {
		return Comment_dDAO.updateComment_d(comment_d);
	}	

	// delete
	public int deleteComment_d(int commentNo) throws Exception {
		return Comment_dDAO.deleteComment_d(commentNo);
	}
	
	// Point
	public int UpdatePoint(int userNo) throws Exception {
		return Comment_dDAO.UpdatePoint(userNo);
	}
	
}	