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
		//qnaList ��ü�� request�� �����Ͽ� qna_list ȭ������ �̵� (forwarding)
		
		return "/views/qna/list.jsp";
	}
}
