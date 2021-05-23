package controller.comment_d;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
//import controller.user.UserSessionUtils;
import model.Comment_d;
import model.service.Comment_dManager;

// Diary 삭제 Controller
public class Comment_dDeleteController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(Comment_dDeleteController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int diaryNo = Integer.parseInt(request.getParameter("diaryNo"));
    	int deleteId = Integer.parseInt(request.getParameter("commentNo"));
    	log.debug("Delete Diary : {}", deleteId);

		Comment_dManager manager = Comment_dManager.getInstance();		
		manager.deleteComment_d(deleteId);				// Diary 정보 삭제
			
		return "redirect:/views/diary/detail?diaryNo=" + diaryNo;		// diary 삭제 한 후, 다이어리 리스트로 이동
    	
    	
    }
}
