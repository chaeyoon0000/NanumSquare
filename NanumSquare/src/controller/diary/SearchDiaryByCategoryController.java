package controller.diary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

//import controller.user.UserSessionUtils;

import model.Diary;

import model.service.DiaryManager;

// Diary 삭제 Controller
public class SearchDiaryByCategoryController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
    	/*
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
    	*/
    	
		DiaryManager manager = DiaryManager.getInstance();
		List<Diary> key_diaryList = manager.getDiaryByKeyword(request.getParameter("keyword"));

		// diaryList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("key_diaryList", key_diaryList);
		
//		request.setAttribute("curUserId", 
//				UserSessionUtils.getLoginUserId(request.getSession()));		

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/views/diary/key.jsp";  
	}
}
