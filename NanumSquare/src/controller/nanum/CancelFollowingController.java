package controller.nanum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.nanum.CancelFollowingController;
import model.service.FriendManager;

public class CancelFollowingController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CancelFollowingController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Integer cancelFriendNo = Integer.parseInt(request.getParameter("friendno"));
		log.debug("Cancel Following : {}", cancelFriendNo);
		
		FriendManager manager = FriendManager.getInstance();
		manager.cancelFollowing(cancelFriendNo);
		
		return "redirect:/views/user/mypage";
	}
}
