package controller.nanum;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import controller.Controller;
import model.Category;
import model.Circle;
import model.User;
import model.dao.CategoryDAO;
import model.dao.CircleDAO;
import model.dao.UserDAO;

@SuppressWarnings("serial")
public class UpdateCircleController extends HttpServlet implements Controller{
	private CircleDAO circleDAO = new CircleDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		if(request.getMethod().equals("GET")) {
	    	Integer circleNo = Integer.parseInt(request.getParameter("circleNo"));
	    	
	    	Circle circle = circleDAO.getCircleDetailByNo(circleNo);
	    	String endDate = circleDAO.getCircleEndDate(circleNo);
	    	System.out.println(endDate);
	    	
	    	String[] date = endDate.split("");
	    	
	    	System.out.println(date.length);
	    	
	    	String day = date[8] + date[9];
	    	String month = date[5] + date[6];
	    	String year = date[0] + date[1] + date[2] + date[3];
	    	
	    	String hour = date[11] + date[12];
	    	String min = date[14] + date[15];
	    	String time = "";
	    	
	    	if(Integer.parseInt(hour) > 12) {
	    		hour = Integer.toString(Integer.parseInt(hour) - 12);
	    		time = "오후 " + hour + ":" + min;
	    	}else {
	    		time = "오전 " + hour + ":" + min;
	    	}
	    	
	    	String[] loc = circle.getLoc().split("\\s");
	    	
	    	for(int i = 4; i < loc.length; i++) {
	    		loc[3] += " " + loc[i];
	    	}
	    	
			request.setAttribute("circle", circle);
			request.setAttribute("loc", loc);
			request.setAttribute("time", time);
			request.setAttribute("date", month + "/" + day + "/" + year);
			
			List<Category> categoryList = categoryDAO.getCategoryList();
			request.setAttribute("categoryList", categoryList);
			
			return "/views/circle/update.jsp";
		}
		
		doPost(request, response);
		 
		return "redirect:/views/circle/list";
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String circleNo = "";
		String title = "";
		String content = "";
		String endDate = "";
		String time = "";
		String catNo = "";
		String loc = "";
		String max = "";
		String filename = "";
	
		boolean check = ServletFileUpload.isMultipartContent(request);
		
		if(check) {
			ServletContext context = request.getServletContext();
			//String path = context.getRealPath("/upload");
			String rootPath = request.getSession().getServletContext().getRealPath("/") ;
			String savePath = rootPath + "upload/" ;
			
			System.out.println(request.getContextPath());
			System.out.println(savePath);
			
			File dir = new File(savePath);
			if(!dir.exists()) dir.mkdir();
			
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(10 * 1024);
                factory.setRepository(dir);            
    
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setSizeMax(10 * 1024 * 1024);
                upload.setHeaderEncoding("EUC-KR");
                                
                List items = (List)upload.parseRequest(request);
                for(int i = 0; i < items.size(); ++i) {
                	FileItem item = (FileItem)items.get(i);
                	
                	String value = item.getString("euc-kr");
                	
                	if(item.isFormField()) {           		
                		if(item.getFieldName().equals("circleNo")) {circleNo = value;}
                		else if(item.getFieldName().equals("title")) {title = value;}
                		else if(item.getFieldName().equals("content")) {content = value;}
                		else if(item.getFieldName().equals("catNo")) {catNo = value;}
                		else if(item.getFieldName().equals("endDate")) { endDate = value; }
                		else if(item.getFieldName().equals("time")) { time = value;}
                		else if(item.getFieldName().equals("addr1")) loc += value + " ";
                		else if(item.getFieldName().equals("addr2")) loc += value + " ";
                		else if(item.getFieldName().equals("addr3")) loc += value + " ";
                		else if(item.getFieldName().equals("addr4")) loc += value + " ";
                		else if(item.getFieldName().equals("addr5")) loc += value + " ";
                		else if(item.getFieldName().equals("max")) max = value;
                	}
                	else {
                		if(item.getFieldName().equals("image")) {
                			filename = item.getName();
                			if(filename == null || filename.trim().length() == 0) continue;
                			filename = filename.substring(filename.lastIndexOf("\\") + 1);
                			File file = new File(dir, filename);
                			item.write(file);
                		}
                	}
                }               
			}catch(SizeLimitExceededException e) {
				e.printStackTrace();           
            }catch(FileUploadException e) {
                e.printStackTrace();
            }catch(Exception e) {            
                e.printStackTrace();
            }
            
            response.setContentType("text/html;charset=euc-kr");
            
            java.util.Date utilDate = new java.util.Date();
    		java.sql.Date sqlCurrDate = new java.sql.Date(utilDate.getTime());

    		Date d = null;
    		try {
    		    String str_date = endDate + " " + time;;
    		    DateFormat formatter ; 
    		    
    		    formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm");
    		    d = (Date)formatter.parse(str_date);
    		} catch (ParseException e) {}
    		Timestamp sqlEndDate = new java.sql.Timestamp(d.getTime());
    		
    		HttpSession session = request.getSession();
    		String userId = (String) session.getAttribute("userId");

    		UserDAO userDAO = new UserDAO();
    		User user = userDAO.findUser(userId);
    		System.out.println(user.getUserNo());
    		
            Circle circle = new Circle(Integer.parseInt(circleNo), user.getUserNo(), title, content, 
    				Integer.parseInt(catNo), sqlCurrDate, loc, sqlEndDate, filename, Integer.parseInt(max), 0,  0);
            
            System.out.println("image: " + circle.getImage());
    		
    		int update = circleDAO.updateCircle(circle);
    		System.out.println("update: " + update);
    		
    		String date = circleDAO.getCircleEndDate(circle.getCircleNo());
    		String[] dates = date.split("");
    		
    		String mm = dates[14] + dates[15];
    		String hh = dates[11] + dates[12];
    		String day = dates[8] + dates[9];
    		String month = dates[5] + dates[6];
    		String year = dates[0] + dates[1] + dates[2] + dates[3];
    		
    		String setDate =  0 + " " + mm + " " + hh + " " + day + " " + month + " ? *";
    		System.out.println(setDate);

    		request.setAttribute("circleNo", circle.getCircleNo());
    		
    		RegisterCircleController.circleNo.put(sqlEndDate, circle.getCircleNo());
    		
    		Iterator<Date> keys = RegisterCircleController.circleNo.keySet().iterator();
    		while( keys.hasNext() ){ 
    			Date key = keys.next(); 
    			System.out.println( "key : " + key + ", value : " + RegisterCircleController.getCircleNo().get(key)); 
    		}

    		JobScheduler js = new JobScheduler(JobExecuter.class, setDate);
    		js.triggerJob();
		}
	}
}
