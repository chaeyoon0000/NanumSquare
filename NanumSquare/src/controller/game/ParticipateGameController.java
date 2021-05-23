package controller.game;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Betting;
import model.Game;
import model.User;
import model.dao.BettingDAO;
import model.dao.GameDAO;
import model.dao.UserDAO;

public class ParticipateGameController implements Controller{
	private UserDAO userDAO = new UserDAO();
	private GameDAO gameDAO = new GameDAO();
	private BettingDAO bettingDAO = new BettingDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt(request.getParameter("gameNo")));
		Integer gameNo = Integer.parseInt(request.getParameter("gameNo"));
		Integer bPoint = Integer.parseInt(request.getParameter("bPoint"));
		
		System.out.println("No: " + gameNo);
		
		System.out.println("gameNo: " + gameNo + " bPoint: " + bPoint);
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = userDAO.findUser(userId);
		
		if(user.getPoint() < bPoint) {	
			 response.setCharacterEncoding("EUC-KR");
		     PrintWriter writer = response.getWriter();
		     writer.println("<script type='text/javascript'>");
		     writer.println("alert('Not enough points');");
		     writer.println("history.back();");
		     writer.println("</script>");
		     writer.flush();
		}
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlCurrDate = new java.sql.Date(utilDate.getTime());
		
		int betNo = bettingDAO.getSeq();

		Betting betting = new Betting(betNo, bPoint, gameNo, sqlCurrDate, user.getUserNo());
		
		bettingDAO.insertBetting(betting);
		bettingDAO.redeemPoint(user.getUserNo(), bPoint);

		if(gameDAO.getMaxPoint(gameNo) < bPoint) {
			gameDAO.updateMaxPoint(gameNo, bPoint);
		}
		
		request.setAttribute("betting", betting);
		
		return "redirect:/views/game/detail?gameNo=" + gameNo;
	}

}
