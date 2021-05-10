package controller.comment_d_c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
//import controller.user.UserSessionUtils;
import model.service.Comment_d_cManager;

// Diary 삭제 Controller
public class Comment_d_cDeleteController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(Comment_d_cDeleteController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int diaryNo = Integer.parseInt(request.getParameter("diaryNo"));
    	int deleteId = Integer.parseInt(request.getParameter("dChildNo"));
    	log.debug("Delete Diary : {}", deleteId);
    	
    	System.out.println("aaaa" + deleteId);

		Comment_d_cManager manager = Comment_d_cManager.getInstance();		
		manager.deleteComment_d_c(deleteId);				// Diary 정보 삭제
			
		return "redirect:/views/diary/detail?diaryNo=" + diaryNo;		// diary 삭제 한 후, 다이어리 리스트로 이동
    	
    	
    }
}
