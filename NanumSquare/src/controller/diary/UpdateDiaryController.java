package controller.diary;

//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
//import controller.user.UserSessionUtils;
import model.Diary;
import model.User;
import model.service.DiaryManager;
import model.service.UserManager;

// Diary ªË¡¶ Controller
public class UpdateDiaryController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(UpdateDiaryController.class);

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
//	    	String strDate = request.getParameter("uploadDate");
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    	Date date = sdf.parse(strDate);
	    	
	    	HttpSession session = request.getSession();
			
			String userId = (String) session.getAttribute("userId");
			UserManager manager2 = UserManager.getInstance();
			User user = manager2.findUser(userId);
	    	
	    	Diary updateDiary = new Diary(
	    			Integer.parseInt(request.getParameter("updateId")),
	    			user.getUserNo(),
					1,
					request.getParameter("title"),
					request.getParameter("content"),
					null,
					request.getParameter("image"),
					10,
					request.getParameter("loc"),
					10);
	    	
	    	log.debug("Update Diary : {}", updateDiary);

			DiaryManager manager = DiaryManager.getInstance();
			
			manager.updateDiary(updateDiary);

//			System.out.println(updateDiary.getContent());
			System.out.println(updateDiary.getContent());
			
	        return "redirect:/views/diary/list";			
	    }
}
