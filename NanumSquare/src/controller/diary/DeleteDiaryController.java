package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

import model.service.DiaryManager;

// Diary 삭제 Controller
public class DeleteDiaryController implements Controller {
	
	private static final Logger log = LoggerFactory.getLogger(DeleteDiaryController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int deleteId = Integer.parseInt(request.getParameter("diaryNo"));
    	log.debug("Delete Diary : {}", deleteId);
    	
		DiaryManager manager = DiaryManager.getInstance();		
		manager.DeletePoint(deleteId);
		manager.deleteDiary(deleteId);				// Diary 정보 삭제
		
		
			
		return "redirect:/views/diary/list";		// diary 삭제 한 후, 다이어리 리스트로 이동
		
		
//		/* 삭제가 불가능한 경우 */
//		Diary diary = manager.selectDetailDiary(deleteId);	// 다이어리 정보 검색
//		request.setAttribute("diary", diary); // ?????						
//		request.setAttribute("deleteFailed", true);
//		String msg = (UserSessionUtils.isLoginUser("0", session)) 
//				   ? "시스템 관리자 정보는 삭제할 수 없습니다."		
//				   : "타인의 정보는 삭제할 수 없습니다.";													
//		request.setAttribute("exception", new IllegalStateException(msg));            
//		
//		return "/diary/list.jsp";		// 사용자 보기 화면으로 이동 (forwarding)
		
    }

}
