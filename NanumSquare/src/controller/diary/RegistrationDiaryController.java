package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Diary;
import model.User;
import model.service.DiaryManager;
import model.service.UserManager;

// DiaryController, comment_d Controller, comment_d impl
// Controller�� ����Ǵ� JSP ���ϵ�!!
// content - LIKE ������


// Diary ��� Controller
public class RegistrationDiaryController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegistrationDiaryController.class);

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
    	
    	Diary diary = new Diary(
    			0,
				user.getUserNo(),
				1,
				request.getParameter("title"),
				request.getParameter("content"),
				null,
				request.getParameter("image"),
				null,
				request.getParameter("loc"),
				null);	
		
    	System.out.println(diary.getTitle());
    	System.out.println(diary.getContent());

        log.debug("Create Diary : {}", diary);

		try {
			DiaryManager manager = DiaryManager.getInstance();
			manager.insertDiary(diary);
			manager.UpdatePoint(user.getUserNo());
			
	        return "redirect:/views/diary/list";		// ���� �� ���̾ ����Ʈ ȭ������ redirect
	        
		} catch (Exception ex) {
			request.setAttribute("diary", diary);// ���� �߻� �� ���ΰ�ħ. (�ϴ���)
			return "/views/diary/register.jsp";
		}
    }
}
