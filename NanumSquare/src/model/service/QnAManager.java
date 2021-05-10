package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.QnADAO;
import model.QnA;

public class QnAManager {
	private static QnAManager qnaMan = new QnAManager();
	private QnADAO qnaDAO;
	
	private QnAManager() {
		try {
			qnaDAO = new QnADAO();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static QnAManager getInstance() {
		return qnaMan;
	}
	
	public List<QnA> getQnAList() throws SQLException {
		return qnaDAO.getQnAList();
	}
	
	public QnA getDetailQnA(int post_no) throws SQLException {
		return qnaDAO.getDetailQnA(post_no);
	}
	
	public QnA insert(QnA qna) throws SQLException {
		return qnaDAO.insertQnA(qna);
	}

	public int update(QnA qna) throws SQLException {
		return qnaDAO.updateQnA(qna);
	}	

	public int delete(int post_no) throws SQLException {
		return qnaDAO.deleteQnA(post_no);
	}
	
	public List<QnA> getQnAByKeyword(String keyword) throws SQLException {
		return qnaDAO.getQnAByKeyword(keyword);
	}
	
	public List<QnA> getQnAByUser(String id) throws SQLException {
		return qnaDAO.getQnAByUser(id);
	}
	
	public QnADAO getQnADAOimpl() {
		return this.qnaDAO;
	}
	
}

