package controller.nanum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Circle;
import model.User;
import model.dao.CategoryDAO;
import model.dao.CircleDAO;
import model.dao.UserDAO;
import model.service.UserManager;

public class DetailCircleController implements Controller{
	private CircleDAO circleDAO = new CircleDAO();
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception { 
    	Integer circleNo = Integer.parseInt(request.getParameter("circleNo"));
    	
    	Circle circle = circleDAO.getCircleDetailByNo(circleNo);
    	String endDate = circleDAO.getCircleEndDate(circleNo);
    	
    	List<Circle> catCircle = circleDAO.getCircleByCategory(circle.getCategory(), circle.getCircleNo());
    	
    	List<User> applyUser = circleDAO.getUserCircle(circleNo);
    	
    	circleDAO.updateCircleCnt(circleNo);

		request.setAttribute("circle", circle);
		request.setAttribute("endDate", endDate);
		request.setAttribute("catCircle", catCircle);
		request.setAttribute("applyUser", applyUser);

		return "/views/circle/detail.jsp";
    }
}

