package controller.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.CategoryManager;
import controller.Controller;

import model.dao.DiaryDAO;
import model.Category;
import model.Diary;

public class DiaryViewCategoryController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		Category cat = null;
		CategoryManager manager = CategoryManager.getInstance();
		
		DiaryDAO diaryDAO = new DiaryDAO();
		
		int catNo = Integer.parseInt(request.getParameter("catNo"));
		List<Diary> diaryList = diaryDAO.getDiaryByCategory(catNo);
	
    	request.setAttribute("diaryList", diaryList);					
		return "/views/category/DiaryView.jsp";		
		
		
	}

}
