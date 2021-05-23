package controller.nanum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.User;
import model.service.FriendManager;
import model.service.UserManager;

public class AcceptFollowingController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		UserManager manager2 = UserManager.getInstance();
		User user = manager2.findUser(userId);
		
		Integer friendNo = Integer.parseInt(request.getParameter("friendno"));
		
		User following = new User(
				user.getUserNo(),
				friendNo);

		FriendManager manager = FriendManager.getInstance();
		manager.acceptFollowing(following);
		
		return "redirect:/views/user/mypage";
	}
}

