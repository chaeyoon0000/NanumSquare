package controller.ranking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.RankingCircle;
import model.RankingDiary;
import model.service.RankingCircleManager;
import model.service.RankingDiaryManager;

public class RankingCircleController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RankingCircleManager managerCnt = RankingCircleManager.getInstance();
		List<RankingCircle> rankingCircleByCnt = managerCnt.getCircleListByCnt();
		
		request.setAttribute("rankingCircleByCnt", rankingCircleByCnt);
		
		//return "/views/ranking/rank.jsp";
		return null;
	}

}
