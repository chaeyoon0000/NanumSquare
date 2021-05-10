package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

import model.service.DiaryManager;

// Diary ªË¡¶ Controller
public class LikeyDiaryController implements Controller {
	
	private static final Logger log = LoggerFactory.getLogger(LikeyDiaryController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int diaryNo = Integer.parseInt(request.getParameter("diaryNo"));

		DiaryManager manager = DiaryManager.getInstance();		
		manager.UpdateLikey(diaryNo);			
			
		return "redirect:/views/diary/detail?diaryNo=" + diaryNo;
		
    }

}
