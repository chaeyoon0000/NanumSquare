package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.QnAManager;
import model.QnA;

import java.util.List;

public class SearchQnAByUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("user");
		
		QnAManager manager = QnAManager.getInstance();
		List<QnA> u_qnaList = manager.getQnAByUser(userId);
		
		request.setAttribute("qnaList", u_qnaList);
		
		return "/views/qna/list.jsp";
	}
}

