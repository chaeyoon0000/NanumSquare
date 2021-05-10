package controller.nanum;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import model.dao.CircleDAO;

public class JobExecuter implements Job{
	private CircleDAO circleDAO = new CircleDAO();
	static int i = 0;
	static Date recent = new Date();
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
//		Map<Integer, Integer> circleNo = MyJob.getCircleNo();
//		System.out.println("-----" + MyJob.getCircleNo());
//		
//		Iterator<Integer> keys = MyJob.circleNo.keySet().iterator();
//		while( keys.hasNext() ){ 
//			Integer key = keys.next();
//			System.out.println( "key : " + key + ", value : " + MyJob.getCircleNo().get(key)); 
//		}
//		
//		System.out.println(MyJob.circleNo.get(i) + i + " update: " + circleDAO.updateCircleByEndDate(MyJob.circleNo.get(i++)));
		
		Map<Date, Integer> circleNo = RegisterCircleController.getCircleNo();
		System.out.println("-----" + circleNo);
		
		Iterator<Date> keys = RegisterCircleController.circleNo.keySet().iterator();

		recent = keys.next();
		while( keys.hasNext() ){ 
			Date key = keys.next();
			if(key.compareTo(recent) < 0) recent = key;
		}
		
		System.out.println(recent);
		
		System.out.println(RegisterCircleController.circleNo.get(recent) + i 
				+ " update: " + circleDAO.updateCircleByEndDate(RegisterCircleController.circleNo.get(recent)));
		
		RegisterCircleController.circleNo.remove(recent);
	}
}