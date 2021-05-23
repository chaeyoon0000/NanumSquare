package controller.comment_d_c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
//import controller.user.UserSessionUtils;
import model.Comment_dchild;
import model.User;
import model.service.Comment_d_cManager;
import model.service.UserManager;

// Diary 삭제 Controller
public class Comment_d_cRegistrationController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(Comment_d_cRegistrationController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		UserManager manager2 = UserManager.getInstance();
		User user = manager2.findUser(userId);
		Integer diaryNo = Integer.parseInt(request.getParameter("diaryNo"));
		
    	Comment_dchild comment_d_c = new Comment_dchild(0, user.getUserNo(), null, Integer.parseInt(request.getParameter("commentNo")), request.getParameter("content"), null);
    	
		System.out.println("덧글 내용:" + comment_d_c.getContent());
		
		try {
			Comment_d_cManager manager = Comment_d_cManager.getInstance();
			manager.insertComment_d_c(comment_d_c);
			manager.UpdatePoint(user.getUserNo());
			
			request.setAttribute("commentNo", Integer.parseInt(request.getParameter("commentNo")));
			
	        return "redirect:/views/diary/detail?diaryNo=" + diaryNo;		// 성공 시 다이어리 리스트 화면으로 redirect
	        
		} catch (Exception ex) {
			//request.setAttribute("comment_d", comment_d);// 예외 발생 시 새로고침. (일단은)
			return "/views/diary/list.jsp";
		}
    	
    	
    }
}
