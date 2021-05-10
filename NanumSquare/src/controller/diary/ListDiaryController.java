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
		
		// diaryList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
		request.setAttribute("diaryList", diaryList);						

		// ����� ����Ʈ ȭ������ �̵�(forwarding)
		return "/views/diary/list.jsp";  
	}
}
