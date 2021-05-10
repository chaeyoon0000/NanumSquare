package controller.game;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.nanum.JobExecuter;
import controller.nanum.JobScheduler;
import controller.nanum.RegisterCircleController;
import model.Game;
import model.User;
import model.dao.GameDAO;
import model.dao.UserDAO;

public class RegisterGameController implements Controller{
	private GameDAO gameDao = new GameDAO();
	private UserDAO userDao = new UserDAO();
	
	static Map<Date, Integer> gameNo = new HashMap<Date, Integer>();

	public static Map<Date, Integer> getGameNo() {
		return gameNo;
	}

	public static void setCircleNo(Map<Date, Integer> gameNo) {
		RegisterGameController.gameNo = gameNo;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(request.getMethod().equals("GET")) {
			return "/views/game/form.jsp";
		}
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = userDao.findUser(userId);

		String endDate = request.getParameter("endDate");
		String time = request.getParameter("time");
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlCurrDate = new java.sql.Date(utilDate.getTime());
		
		String s = endDate + " " + time;
		java.util.Date d = new SimpleDateFormat("MM/dd/yyyy hh:mm").parse(s); System.out.println(d);
		Timestamp sqlEndDate = new java.sql.Timestamp(d.getTime());
		
 		Integer gameNo = gameDao.getSeq();
 		Game game = new Game(gameNo, 0, user, sqlCurrDate, sqlEndDate, 0, 0);

 		int insertGame = gameDao.insertGame(game);
 		System.out.println(insertGame);

 		request.setAttribute("gameNo", gameNo);
 		
		//Scheduler
 		String date = gameDao.getGameEndDate(game.getGameNo());
		String[] dates = date.split("");
		
		String mm = dates[14] + dates[15];
		String hh = dates[11] + dates[12];
		String day = dates[8] + dates[9];
		String month = dates[5] + dates[6];
		String year = dates[0] + dates[1] + dates[2] + dates[3];		

		String setDate =  0 + " " + mm + " " + hh + " " + day + " " + month + " ? *";
		System.out.println(setDate);
 		
		RegisterGameController.gameNo.put(sqlEndDate, game.getGameNo());
		
		Iterator<Date> keys = RegisterGameController.gameNo.keySet().iterator();
		while( keys.hasNext() ){ 
			Date key = keys.next();
			System.out.println( "key : " + key + ", value : " + RegisterGameController.getGameNo().get(key)); 
		}
		
		GameJobScheduler js = new GameJobScheduler(GameJobExecuter.class, setDate);
		js.triggerJob();
		
		return "redirect:/views/game/detail?gameNo=" + gameNo;
	}

}
