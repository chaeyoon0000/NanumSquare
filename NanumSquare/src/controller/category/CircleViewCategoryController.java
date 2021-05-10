package controller.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.CategoryManager;

import controller.Controller;
import model.dao.CircleDAO;
import model.Category;
import model.Circle;

public class CircleViewCategoryController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		Category cat = null;
		CategoryManager manager = CategoryManager.getInstance();
		
		CircleDAO circleDAO = new CircleDAO();
		
		int catNo = Integer.parseInt(request.getParameter("catNo"));
		List<Circle> circleList = circleDAO.getCircleByCategory(catNo);
	
    	request.setAttribute("circleList", circleList);					
		return "/views/category/CircleView.jsp";		
		
		
	}

}
