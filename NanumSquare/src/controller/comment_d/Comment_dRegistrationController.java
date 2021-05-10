package controller.comment_d;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Comment_d;
import model.User;
import model.service.Comment_dManager;
import model.service.UserManager;

//  등록 Controller
public class Comment_dRegistrationController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(Comment_dRegistrationController.class);

	// ParseInt!
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	String strDate = request.getParameter("uploadDate");
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Date date = sdf.parse(strDate);
    	
    	HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		UserManager manager2 = UserManager.getInstance();
		User user = manager2.findUser(userId);
		
		Integer diaryNo = Integer.parseInt(request.getParameter("diaryNo"));
    	
    	System.out.println("diaryNo: " + Integer.parseInt(request.getParameter("diaryNo")));

    	Comment_d comment_d = new Comment_d(0, user.getUserNo(), null, Integer.parseInt(request.getParameter("diaryNo")), request.getParameter("content"), null);
    	
		System.out.println("덧글 내용:" + comment_d.getContent());
		
		try {
			Comment_dManager manager = Comment_dManager.getInstance();
			manager.insertComment_d(comment_d);
			manager.UpdatePoint(user.getUserNo());
		
			request.setAttribute("diaryNo", Integer.parseInt(request.getParameter("diaryNo")));
			
	        return "redirect:/views/diary/detail?diaryNo=" + diaryNo;		// 성공 시 다이어리 리스트 화면으로 redirect
	        
		} catch (Exception ex) {
			//request.setAttribute("comment_d", comment_d);// 예외 발생 시 새로고침. (일단은)
			return "/views/diary/list.jsp";
		}
    
    }
}
