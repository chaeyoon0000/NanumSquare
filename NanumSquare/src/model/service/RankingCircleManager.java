package model.service;

import java.util.List;

import model.RankingCircle;
import model.dao.RankingCircleDAO;

public class RankingCircleManager {
	private static RankingCircleManager rankingMan = new RankingCircleManager();
	private RankingCircleDAO rankingCircleDAO;

	private RankingCircleManager() {
		try {
			rankingCircleDAO = new RankingCircleDAO();
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public static RankingCircleManager getInstance() {
		return rankingMan;
	}
	
	public List<RankingCircle> getCircleListByCnt() throws Exception {
		return rankingCircleDAO.getCircleListByCnt();
	}
}
