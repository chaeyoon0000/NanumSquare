package controller.nanum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.User;
import model.dao.CircleDAO;
import model.dao.UserDAO;
import model.service.UserManager;

public class ApplyCircleController implements Controller{
	private CircleDAO circleDAO = new CircleDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Integer circleNo = Integer.parseInt(request.getParameter("circleNo"));
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		UserManager manager = UserManager.getInstance();
		User user = manager.findUser(userId);
		
		circleDAO.insertUserCircle(user.getUserNo(), circleNo);
		circleDAO.updateCircleState(circleNo);
		
		return "/views/circle/detail";
	}

}
