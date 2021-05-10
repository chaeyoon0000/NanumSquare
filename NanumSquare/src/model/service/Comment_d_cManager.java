package model.service;

import java.sql.SQLException;
import java.util.List;
import model.dao.Comment_d_cDAO;
import model.Comment_dchild;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * Comment_dDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */

public class Comment_d_cManager {
	private static Comment_d_cManager Comment_d_c = new Comment_d_cManager();
	private Comment_d_cDAO Comment_d_cDAO;
//	private Comment_dAnalysis Comment_dAanlysis; �ʿ��ϸ� �����ϱ�!

	private Comment_d_cManager() {
		try {
			Comment_d_cDAO = new Comment_d_cDAO();
//			Comment_dAanlysis = new Comment_dAnalysis(Comment_dDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static Comment_d_cManager getInstance() {
		return Comment_d_c;
	}
	

	public List<Comment_dchild> Comment_d_cList() throws Exception {
		return Comment_d_cDAO.Comment_d_cList();
	}
	
	// Insert
	public int insertComment_d_c(Comment_dchild comment_d_c) throws SQLException {
		return Comment_d_cDAO.insertComment_d_c(comment_d_c);
	}

	// Update
	public int updateComment_d_c(Comment_dchild comment_d_c) throws Exception {
		return Comment_d_cDAO.updateComment_d_c(comment_d_c);
	}	

	// delete
	public int deleteComment_d_c(int commentNo) throws Exception {
		return Comment_d_cDAO.deleteComment_d_c(commentNo);
	}
	
	// Point
	public int UpdatePoint(int userNo) throws Exception {
		return Comment_d_cDAO.UpdatePoint(userNo);
	}
	
}	