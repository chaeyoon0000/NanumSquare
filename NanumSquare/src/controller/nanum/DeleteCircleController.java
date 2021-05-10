package controller.nanum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.CircleDAO;

public class DeleteCircleController implements Controller{
	private CircleDAO circleDAO = new CircleDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Integer deleteCircle = Integer.parseInt(request.getParameter("circleNo"));
		circleDAO.deleteCircle(deleteCircle);

		return "redirect:/views/circle/list";	
	}
}
