package controller.nanum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.nanum.DeleteFriendController;
import model.service.FriendManager;

public class DeleteFriendController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeleteFriendController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Integer deleteFriendNo = Integer.parseInt(request.getParameter("friendno"));
		log.debug("Delete Friend : {}", deleteFriendNo);
		
		FriendManager manager = FriendManager.getInstance();
		manager.deleteFriend(deleteFriendNo);
		
		return "redirect:/views/user/mypage";
	}
}
