package controller.comment_d_c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
//import controller.user.UserSessionUtils;
import model.service.Comment_d_cManager;
import model.Comment_dchild;

public class Comment_d_cRegistrationFormController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(Comment_d_cRegistrationFormController.class);

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int diaryNo = Integer.parseInt(request.getParameter("diaryNo"));
		
		System.out.println("diaryNo:" + diaryNo);
		
		log.debug("UpdateForm Request : {}", commentNo);

		Comment_d_cManager manager = Comment_d_cManager.getInstance();
		
//		System.out.println(updateDiary.getContent());
		
		request.setAttribute("diaryNo", diaryNo);
		request.setAttribute("commentNo", commentNo); 	
           
		return "/views/diary/c_register.jsp";
    }
}
