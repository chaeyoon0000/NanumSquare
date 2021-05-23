package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.QnAManager;
import model.QnA;

import java.util.List;

public class ListQnAController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		QnAManager manager = QnAManager.getInstance();
		List<QnA> qnaList = manager.getQnAList();
		
		request.setAttribute("qnaList", qnaList);
		//qnaList 객체를 request에 저장하여 qna_list 화면으로 이동 (forwarding)
		
		return "/views/qna/list.jsp";
	}
}
