package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.QnAManager;
import model.QnA;

public class DetailQnAController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		QnA detailQna = null;
		QnAManager manager = QnAManager.getInstance();
		
		Integer detailQnaNo = Integer.parseInt(request.getParameter("postno"));
		detailQna = manager.getDetailQnA(detailQnaNo);		
		
		request.setAttribute("detailQna", detailQna);
		
		return "/views/qna/detail.jsp";	
	}

}
