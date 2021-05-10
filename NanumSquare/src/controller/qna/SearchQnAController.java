package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.QnAManager;
import model.QnA;

import java.util.List;

public class SearchQnAController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String keyword = request.getParameter("keyword");
		
		QnAManager manager = QnAManager.getInstance();
		List<QnA> k_qnaList = manager.getQnAByKeyword(keyword);
		
		request.setAttribute("qnaList", k_qnaList);
		
		return "/views/qna/list.jsp";
	}

}
