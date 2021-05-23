package controller.diary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Diary;
import model.service.DiaryManager;

// Diary list Controller
public class ListDiaryController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	System.out.println("list");
    	/*
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
    	*/
    	
		DiaryManager manager = DiaryManager.getInstance();
		List<Diary> diaryList = manager.getDiaryList();

		System.out.println(diaryList);
		
		// diaryList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("diaryList", diaryList);						

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/views/diary/list.jsp";  
	}
}
