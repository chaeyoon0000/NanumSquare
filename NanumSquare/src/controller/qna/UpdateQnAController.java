package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.QnAManager;
import model.QnA;

//import java.text.SimpleDateFormat;

public class UpdateQnAController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(UpdateQnAController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Integer updateQnaNo = Integer.parseInt(request.getParameter("postno"));
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: 커뮤니티 수정 form 요청	
			QnAManager manager = QnAManager.getInstance();
			QnA updateQna = manager.getDetailQnA(updateQnaNo);	// 사용자 정보 검색
			request.setAttribute("updateQna", updateQna);		
				
			return "/views/qna/update.jsp"; //forwarding
	    }
		
		System.out.println("확인" + request.getParameter("title"));
		
		// POST request (QnA 정보가 parameter로 전송됨)
		QnA updateQna = new QnA(
				Integer.parseInt(request.getParameter("postno")),
				request.getParameter("title"),
				request.getParameter("content"),
				null, "");
		
		log.debug("Update QnA : {}", updateQna);

		QnAManager manager = QnAManager.getInstance();
		manager.update(updateQna);
		
        return "redirect:/views/qna/list";
	}

}
