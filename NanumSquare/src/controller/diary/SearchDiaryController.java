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

// Diary ªË¡¶ Controller
public class SearchDiaryController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
		String keyword = request.getParameter("keyword");
		
		DiaryManager manager = DiaryManager.getInstance();
		List<Diary> k_diaryList = manager.getDiaryByKeyword(keyword);
		
		request.setAttribute("diaryList", k_diaryList);
		
		return "/views/diary/list.jsp";
	}
}
