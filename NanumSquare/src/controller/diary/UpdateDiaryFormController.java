package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
//import controller.user.UserSessionUtils;
import model.service.DiaryManager;
import model.Diary;

public class UpdateDiaryFormController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateDiaryController.class);

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int updateId = Integer.parseInt(request.getParameter("diaryNo"));
		
		log.debug("UpdateForm Request : {}", updateId);

		DiaryManager manager = DiaryManager.getInstance();
		Diary updateDiary = manager.selectDetailDiary(updateId);	// ���̾ ���� �˻�
		
//		System.out.println(updateDiary.getContent());
		
		request.setAttribute("updateId", updateId); /// ��!!! ???	
		request.setAttribute("diary", updateDiary); /// ��!!! ???						
           
		return "/views/diary/update.jsp";
    }
}
