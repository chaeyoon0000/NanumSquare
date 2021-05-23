package controller.category;

import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Circle;
import model.Diary;
import model.dao.CircleDAO;
import model.dao.DiaryDAO;
import model.service.CategoryManager;
import model.service.DiaryManager;
import controller.Controller;

public class CircleListCategoryController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	      CircleManager Cmanager = CircleManager.getInstance();
	      CircleDAO circleDAO = new CircleDAO();
	      
	      CategoryManager manager = CategoryManager.getInstance();
	      List<model.Category> CategoryList = manager.getCategoryList();
	      
	      DiaryManager Dmanager = DiaryManager.getInstance();
	      DiaryDAO diaryDAO = new DiaryDAO();

	      if(request.getParameter("catNo") != null)
	      {
	         int catNo = Integer.parseInt(request.getParameter("catNo"));
	         List<Circle> circleList = circleDAO.getCircleByCategory(catNo);
	         List<Diary> diaryList = diaryDAO.getDiaryByCategory(catNo);
	         
	         System.out.println(circleList.size());
	         
	         request.setAttribute("circleList", circleList);
	         request.setAttribute("diaryList", diaryList);
	         request.setAttribute("CategoryList", CategoryList);   
	         return "/views/category/CircleCategoryList.jsp";   
	      }
	   
	      List<Circle> circleList = Cmanager.getCircleList();
	      List<Diary> diaryList = Dmanager.getDiaryList();
	      request.setAttribute("circleList", circleList);
	      request.setAttribute("diaryList", diaryList);
	      request.setAttribute("CategoryList", CategoryList);   
	      
	      
		return "/views/category/CircleCategoryList.jsp";        
		
		
		
    }


}
