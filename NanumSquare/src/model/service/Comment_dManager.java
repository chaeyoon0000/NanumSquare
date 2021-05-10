package model.service;

import java.sql.SQLException;
import java.util.List;
import model.dao.Comment_dDAO;
import model.Comment_d;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * Comment_dDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */

public class Comment_dManager {
	private static Comment_dManager Comment_d = new Comment_dManager();
	private Comment_dDAO Comment_dDAO;
//	private Comment_dAnalysis Comment_dAanlysis; �ʿ��ϸ� �����ϱ�!

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