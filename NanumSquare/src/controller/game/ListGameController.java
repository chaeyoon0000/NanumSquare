package controller.game;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Circle;
import model.Game;
import model.dao.GameDAO;


public class ListGameController implements Controller{
	private GameDAO gameDao = new GameDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Game> gameList = gameDao.getGameList();	
		request.setAttribute("gameList", gameList);

		return "/views/game/list.jsp";
	}

}
