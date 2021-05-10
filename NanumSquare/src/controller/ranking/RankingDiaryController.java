package controller.ranking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.RankingCircle;
import model.RankingDiary;
import model.service.RankingCircleManager;
import model.service.RankingDiaryManager;

public class RankingDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RankingDiaryManager DmanagerCnt = RankingDiaryManager.getInstance();
		List<RankingDiary> rankingDiaryByCnt = DmanagerCnt.getDiaryListByCnt();
		
		RankingDiaryManager DmanagerLikey = RankingDiaryManager.getInstance();
		List<RankingDiary> rankingDiaryByLikey = DmanagerLikey.getDiaryListByLikey();
		
		RankingCircleManager CmanagerCnt = RankingCircleManager.getInstance();
		List<RankingCircle> rankingCircleByCnt = CmanagerCnt.getCircleListByCnt();
		
		request.setAttribute("rankingDiaryByCnt", rankingDiaryByCnt);
		request.setAttribute("rankingDiaryByLikey", rankingDiaryByLikey);
		request.setAttribute("rankingCircleByCnt", rankingCircleByCnt);
		 
		return "/views/ranking/rank.jsp";
	}
	
}
