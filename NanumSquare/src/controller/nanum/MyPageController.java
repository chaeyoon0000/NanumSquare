package controller.nanum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.User;
import model.service.FriendManager;
import model.service.UserManager;

public class MyPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
		 
		UserManager manager = UserManager.getInstance();
		User myPage = manager.getMyPage(userId);
		
		//사용자의 친구 목록
		FriendManager user_friend_manager = FriendManager.getInstance();
		List<User> user_friend = user_friend_manager.getFriendListByUser(userId);
		
		//사용자에게 요청 온 목록
		FriendManager friend_request_manager = FriendManager.getInstance();
		List<User> friend_request = friend_request_manager.getFriendRequestList(userId);
		
		//사용자가 요청한 목록
		FriendManager user_request_manager = FriendManager.getInstance();
		List<User> user_request = user_request_manager.getRequestListByUser(userId);
		
		request.setAttribute("myPage", myPage);
		request.setAttribute("user_friend", user_friend);
		request.setAttribute("friend_request", friend_request);
		request.setAttribute("user_request", user_request);
		
		return "/views/user/mypage.jsp";
	}

}
