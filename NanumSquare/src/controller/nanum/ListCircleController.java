package controller.nanum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.CircleDAO;
import model.Circle;

public class ListCircleController implements Controller{
	private CircleDAO circleDao = new CircleDAO();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {    	
    	if(request.getMethod().equals("GET")) {
    		List<Circle> circleList = circleDao.getCircleList();
		
			System.out.println("list size: " + circleList.size());
			
			request.setAttribute("circleList", circleList);
	
			return "/views/circle/list.jsp";
    	}
    	
    	String keyword = (String)request.getParameter("keyword");
    	String state = (String)request.getParameter("state");
    	
    	List<Circle> circleList;
    	
    	if(state.equals("0")) circleList = circleDao.getCircleListByKeyword(keyword);
    	else if(state.equals("1")) circleList = circleDao.getRecruitingCircleListByKeyword(keyword);
    	else circleList = circleDao.getCompletedCircleListByKeyword(keyword);
		
		request.setAttribute("state", state);
		request.setAttribute("circleList", circleList);
		
		return "/views/circle/list.jsp";
    }
}
