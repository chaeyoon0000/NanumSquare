package controller.nanum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.User;
import model.dao.UserDAO;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if(request.getMethod().equals("GET")) {
    		return "/views/user/registerForm.jsp";
    	}
    	
    	String address = request.getParameter("addr1") + " " + request.getParameter("addr2") + " " + request.getParameter("addr13") + " " + request.getParameter("addr4") 
		+ " " + request.getParameter("addr5");
		
    	User user = new User(new UserDAO().getSeq(),
			request.getParameter("id"),
			request.getParameter("name"),
			request.getParameter("password"),
			request.getParameter("phone"),
			request.getParameter("email"),			
			address,
			0);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
			return "redirect:/views/home";		// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingUserException e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/views/user/registerForm.jsp";
		}
    }
}
