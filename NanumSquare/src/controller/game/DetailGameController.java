package controller.game;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Betting;
import model.Game;
import model.dao.BettingDAO;
import model.dao.GameDAO;

public class DetailGameController implements Controller{
	private GameDAO gameDAO = new GameDAO();
	private BettingDAO bettingDAO = new BettingDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Integer gameNo = Integer.parseInt(request.getParameter("gameNo"));
		
		Game game = gameDAO.getGameByNo(gameNo);
		String maxbPointUser = bettingDAO.getMaxbPoinUser(gameNo);
		String endDate = gameDAO.getGameEndDate(gameNo);
		
		List<Betting> bettingList = bettingDAO.getGameBetting(gameNo);
		
		request.setAttribute("bettingList", bettingList);
		request.setAttribute("game", game);
		request.setAttribute("maxbPointUser", maxbPointUser);
		request.setAttribute("endDate", endDate);
		
		return "/views/game/detail.jsp"; 
	}

}
