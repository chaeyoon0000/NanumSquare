package model.service;

import java.sql.SQLException;
import java.util.List;
import model.dao.Comment_d_cDAO;
import model.Comment_dchild;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * Comment_dDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */

public class Comment_d_cManager {
	private static Comment_d_cManager Comment_d_c = new Comment_d_cManager();
	private Comment_d_cDAO Comment_d_cDAO;
//	private Comment_dAnalysis Comment_dAanlysis; 필요하면 설정하기!

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