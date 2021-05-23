package controller.diary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.User;
import model.service.FriendManager;

// Diary list Controller
public class FriendListController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
		HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        
		FriendManager f_manager = FriendManager.getInstance();
		List<User> f_list = f_manager.getFriendListByUser(userId);
		
		request.setAttribute("friendList", f_list);
		
		return "/views/diary/f_list.jsp";  
	}
}