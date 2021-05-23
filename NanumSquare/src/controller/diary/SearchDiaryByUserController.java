package controller.diary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Diary;
import model.service.DiaryManager;

// Diary ���� Controller
public class SearchDiaryByUserController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
		String userId = request.getParameter("user");
		
		DiaryManager manager = DiaryManager.getInstance();
		List<Diary> diaryList = manager.getDiaryByUser(userId);
		
		request.setAttribute("diaryList", diaryList);						

		// ����� ����Ʈ ȭ������ �̵�(forwarding)
		return "/views/diary/list.jsp";  
	}
}

