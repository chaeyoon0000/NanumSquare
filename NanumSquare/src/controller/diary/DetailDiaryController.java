package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.Comment_dManager;
import model.service.Comment_d_cManager;
import model.service.DiaryManager;
import model.Diary;
import model.dao.DiaryDAO;
import model.Comment_d;
import model.Comment_dchild;
import java.util.List;

public class DetailDiaryController implements Controller {
	private DiaryDAO diaryDAO = new DiaryDAO();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
    	
		DiaryManager manager = DiaryManager.getInstance();
		System.out.println("detailController: " + request.getParameter("diaryNo"));
		Integer diaryNo = Integer.parseInt(request.getParameter("diaryNo"));
		
		Diary selectDiary = manager.selectDetailDiary(diaryNo);
		
		Comment_dManager manager2 = Comment_dManager.getInstance();
		List<Comment_d> comment_dList = manager2.Comment_dList(diaryNo);
		
		Comment_d_cManager manager3 = Comment_d_cManager.getInstance();
		List<Comment_dchild> comment_d_cList = manager3.Comment_d_cList();
		
		diaryDAO.updateDiaryCnt(diaryNo);
		
		System.out.println(comment_d_cList);
		
		request.setAttribute("comment_d_cList", comment_d_cList);
		
		request.setAttribute("selectDiary", selectDiary);
		request.setAttribute("diaryNo", diaryNo);
		
		request.setAttribute("comment_dList", comment_dList);
				
		return "/views/diary/detail.jsp";				
    }
}
