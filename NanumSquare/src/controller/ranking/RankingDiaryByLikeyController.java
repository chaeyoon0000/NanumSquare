package controller.ranking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.RankingDiary;
import model.service.RankingDiaryManager;

public class RankingDiaryByLikeyController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RankingDiaryManager manager = RankingDiaryManager.getInstance();
		List<RankingDiary> rankingDiaryByLikey = manager.getDiaryListByLikey();
		
		request.setAttribute("rankingDiaryByLikey", rankingDiaryByLikey);
			
		return "/views/ranking/rank.jsp";
	}
//XXXXXXXXXXXXXXXXXXXXXXX사용안함XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}
