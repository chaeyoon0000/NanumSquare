package controller.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.BettingDAO;
import model.dao.GameDAO;

public class DeleteGameController implements Controller{
	GameDAO gameDAO = new GameDAO();
	BettingDAO bettingDAO = new BettingDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer gameNo = Integer.parseInt(request.getParameter("gameNo"));
		gameDAO.deleteGame(gameNo);
		bettingDAO.deleteBetting(gameNo);

		return "redirect:/views/game/list";
	}

}
