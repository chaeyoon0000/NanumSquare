package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.QnAManager;
import model.service.UserManager;
import model.QnA;
import model.User;

public class RegistertQnAController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(RegistertQnAController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		UserManager manager2 = UserManager.getInstance();
		User user = manager2.findUser(userId);
		
		QnA insertQna = new QnA(
			0, request.getParameter("title"),
				request.getParameter("content"),
				null, user.getUserNo());
		
        try {
        	QnAManager manager = QnAManager.getInstance();
    		manager.insert(insertQna);
    		
    		log.debug("Insert QnA : {}", insertQna);
    		
            return "redirect:/views/qna/list";
	        
		} catch (Exception e) { //예외 발생 시 입력 form으로 forwarding
			request.setAttribute("insertQna", insertQna);
			return "/views/qna/form.jsp";
		}
	}

}
