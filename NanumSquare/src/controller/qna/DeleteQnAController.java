package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.QnAManager;

public class DeleteQnAController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(DeleteQnAController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Integer deleteQnaNo = Integer.parseInt(request.getParameter("postno"));
		log.debug("Delete QnA : {}", deleteQnaNo);
		
		QnAManager manager = QnAManager.getInstance();
		manager.delete(deleteQnaNo);
		
		return "redirect:/views/qna/list";
	}

}
