package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

import model.service.DiaryManager;

// Diary ���� Controller
public class DeleteDiaryController implements Controller {
	
	private static final Logger log = LoggerFactory.getLogger(DeleteDiaryController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int deleteId = Integer.parseInt(request.getParameter("diaryNo"));
    	log.debug("Delete Diary : {}", deleteId);
    	
		DiaryManager manager = DiaryManager.getInstance();		
		manager.DeletePoint(deleteId);
		manager.deleteDiary(deleteId);				// Diary ���� ����
		
		
			
		return "redirect:/views/diary/list";		// diary ���� �� ��, ���̾ ����Ʈ�� �̵�
		
		
//		/* ������ �Ұ����� ��� */
//		Diary diary = manager.selectDetailDiary(deleteId);	// ���̾ ���� �˻�
//		request.setAttribute("diary", diary); // ?????						
//		request.setAttribute("deleteFailed", true);
//		String msg = (UserSessionUtils.isLoginUser("0", session)) 
//				   ? "�ý��� ������ ������ ������ �� �����ϴ�."		
//				   : "Ÿ���� ������ ������ �� �����ϴ�.";													
//		request.setAttribute("exception", new IllegalStateException(msg));            
//		
//		return "/diary/list.jsp";		// ����� ���� ȭ������ �̵� (forwarding)
		
    }

}
