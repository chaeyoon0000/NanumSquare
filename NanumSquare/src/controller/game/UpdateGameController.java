package controller.game;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Game;
import model.User;
import model.dao.GameDAO;
import model.dao.UserDAO;

public class UpdateGameController implements Controller{
	GameDAO gameDAO = new GameDAO();
	UserDAO userDAO = new UserDAO();
	
	static Map<Date, Integer> gameNo = new HashMap<Date, Integer>();

	public static Map<Date, Integer> getGameNo() {
		return gameNo;
	}

	public static void setCircleNo(Map<Date, Integer> gameNo) {
		UpdateGameController.gameNo = gameNo;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(request.getMethod().equals("GET")) {
			Integer gameNo = Integer.parseInt(request.getParameter("gameNo"));
			
			Game game = gameDAO.getGameByNo(gameNo);
			String endDate = gameDAO.getGameEndDate(gameNo);
			
			request.setAttribute("game", game);
			request.setAttribute("endDate", endDate.substring(0, 10));
			
			return "/views/game/update.jsp";
		}
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = userDAO.findUser(userId);

		String endDate = request.getParameter("endDate");
		String time = request.getParameter("time");
		
		Integer gameNo = Integer.parseInt(request.getParameter("gameNo")); 		
		System.out.println(gameNo);
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlCurrDate = new java.sql.Date(utilDate.getTime());

		String s = endDate + " " + time;
		java.util.Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(s);
		Timestamp sqlEndDate = new java.sql.Timestamp(d.getTime());
		
 		Game game = new Game(gameNo, 0, user, sqlCurrDate, sqlEndDate, 0, 0);

 		gameDAO.updateGame(game);
 		
 		//Scheduler
 		String date = gameDAO.getGameEndDate(game.getGameNo());
		String[] dates = date.split("");
		
		String mm = dates[14] + dates[15];
		String hh = dates[11] + dates[12];
		String day = dates[8] + dates[9];
		String month = dates[5] + dates[6];
		String year = dates[0] + dates[1] + dates[2] + dates[3];		

		String setDate =  0 + " " + mm + " " + hh + " " + day + " " + month + " ? *";
 		
		UpdateGameController.gameNo.put(sqlEndDate, game.getGameNo());
		
		Iterator<Date> keys = UpdateGameController.gameNo.keySet().iterator();
		while( keys.hasNext() ){ 
			Date key = keys.next();
			System.out.println( "key : " + key + ", value : " + UpdateGameController.getGameNo().get(key)); 
		}
		
		GameJobScheduler js = new GameJobScheduler(GameJobExecuter.class, setDate);
		js.triggerJob();
		
		return "redirect:/views/game/detail?gameNo=" + gameNo;
	}

}
