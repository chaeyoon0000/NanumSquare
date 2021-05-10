package controller.nanum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Circle;
import model.dao.CircleDAO;

public class SearchCircleController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CircleDAO circleDao = new CircleDAO();
		
		String keyword = (String) request.getAttribute("keyword");
		List<Circle> circleList = circleDao.getCircleListByKeyword(keyword);
		
		System.out.println(keyword);
		request.setAttribute("circleList", circleList);
		
		return "/views/circle/list.jsp";
	}

}
