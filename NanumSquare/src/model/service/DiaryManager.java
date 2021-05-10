package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DiaryDAO;
import model.Diary;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * DiaryDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */

public class DiaryManager {
	private static DiaryManager diaryOne = new DiaryManager();
	private DiaryDAO diaryDAO;
//	private DiaryAnalysis diaryAanlysis; 필요하면 설정하기!

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
	
	// 전체 다이어리 정보를 획득
	public List<Diary> getDiaryList() throws Exception {
		return diaryDAO.getDiaryList();
	}
	
	public Diary selectDetailDiary(int diaryNo) throws SQLException, NullPointerException {
		Diary diary = diaryDAO.selectDetailDiary(diaryNo);
		
		if (diary == null) {
			throw new NullPointerException(diaryNo + "번 Diary 정보가 없습니다.");
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
			throw new NullPointerException(keyword + " 키워드 정보 누락");
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