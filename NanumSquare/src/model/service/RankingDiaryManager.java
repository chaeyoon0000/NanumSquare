package model.service;

import java.util.List;
import model.RankingDiary;
import model.dao.RankingDiaryDAO;

public class RankingDiaryManager {
	private static RankingDiaryManager rankingMan = new RankingDiaryManager();
	private RankingDiaryDAO rankingDiaryDAO;

	private RankingDiaryManager() {
		try {
			rankingDiaryDAO = new RankingDiaryDAO();
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public static RankingDiaryManager getInstance() {
		return rankingMan;
	}
	
	public List<RankingDiary> getDiaryListByLikey() throws Exception {
		return rankingDiaryDAO.getDiaryListByLikey();
	}
	
	public List<RankingDiary> getDiaryListByCnt() throws Exception {
		return rankingDiaryDAO.getDiaryListByCnt();
	}
}
