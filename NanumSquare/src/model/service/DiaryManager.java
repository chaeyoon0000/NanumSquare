package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DiaryDAO;
import model.Diary;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * DiaryDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */

public class DiaryManager {
	private static DiaryManager diaryOne = new DiaryManager();
	private DiaryDAO diaryDAO;
//	private DiaryAnalysis diaryAanlysis; �ʿ��ϸ� �����ϱ�!

	private DiaryManager() {
		try {
			diaryDAO = new DiaryDAO();
//			diaryAanlysis = new DiaryAnalysis(diaryDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static DiaryManager getInstance() {
		return diaryOne;
	}
	
	// ��ü ���̾ ������ ȹ��
	public List<Diary> getDiaryList() throws Exception {
		return diaryDAO.getDiaryList();
	}
	
	public Diary selectDetailDiary(int diaryNo) throws SQLException, NullPointerException {
		Diary diary = diaryDAO.selectDetailDiary(diaryNo);
		
		if (diary == null) {
			throw new NullPointerException(diaryNo + "�� Diary ������ �����ϴ�.");
		}
		
		return diary;
	}
	
	// Insert
	public Diary insertDiary(Diary diary) throws SQLException {
		return diaryDAO.insertDiary(diary);
	}

	// Update
	public int updateDiary(Diary diary) throws Exception {
		return diaryDAO.updateDiary(diary);
	}	

	// delete
	public int deleteDiary(int diaryNo) throws Exception {
		return diaryDAO.deleteDiary(diaryNo);
	}
	
	public List<Diary> getDiaryByKeyword (String keyword) throws Exception, NullPointerException {
		
		if (keyword == null) {
			throw new NullPointerException(keyword + " Ű���� ���� ����");
		}
		
		return diaryDAO.getDiaryByKeyword(keyword);
	}
	
	public List<Diary> getDiaryByCategory (int catNo) throws Exception {
		return diaryDAO.getDiaryByCategory(catNo);
	}
	
	public List<Diary> getDiaryByUser(String id) throws Exception {
		return diaryDAO.getDiaryByUser(id);
	}
	
	public int UpdateLikey(int diaryNo) throws Exception {
		return diaryDAO.UpdateLikey(diaryNo);
	}
	
	public List<Diary> getDiaryListByCnt() throws Exception {
		return diaryDAO.getDiaryListByCnt();
	}
	
	public int UpdatePoint(int userNo) throws Exception {
		return diaryDAO.UpdatePoint(userNo);
	}
	
	public int DeletePoint(int diaryNo) throws Exception {
		return diaryDAO.DeletePoint(diaryNo);
	}
	
	public DiaryDAO getDiaryDAO() {
		return this.diaryDAO;
	}
}