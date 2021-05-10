package controller.game;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import model.dao.BettingDAO;
import model.dao.GameDAO;
import model.dao.UserDAO;

public class GameJobExecuter implements Job{
	private GameDAO gameDAO = new GameDAO();
	private UserDAO userDAO = new UserDAO();
	private BettingDAO bettingDAO = new BettingDAO();
	static int i = 0;
	static Date recent1 = new Date();
	static Date recent2 = new Date();
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Map<Date, Integer> circleNo1 = RegisterGameController.getGameNo();
		Map<Date, Integer> circleNo2 = UpdateGameController.getGameNo();
		System.out.println("-----" + circleNo1);
		System.out.println("-----" + circleNo2);
		
		Iterator<Date> keys1 = RegisterGameController.gameNo.keySet().iterator();
		Iterator<Date> keys2 = UpdateGameController.gameNo.keySet().iterator();

		recent1 = keys1.next();
		while( keys1.hasNext() ){ 
			Date key1 = keys1.next();
			if(key1.compareTo(recent1) < 0) recent1 = key1;
		}
		
		recent2 = keys2.next();
		while( keys2.hasNext() ){ 
			Date key2 = keys2.next();
			if(key2.compareTo(recent2) < 0) recent2 = key2;
		}
		
		System.out.println(recent1);
		System.out.println(recent2);
		
		System.out.println(RegisterGameController.gameNo.get(recent1) + i 
				+ " update: " + gameDAO.updateGameByEndDate(RegisterGameController.gameNo.get(recent1)));
		
		Integer point1 = gameDAO.getGameByNo((RegisterGameController.gameNo.get(recent1))).getMaxPoint();	
		String id1 = bettingDAO.getMaxbPoinUser(RegisterGameController.gameNo.get(recent1));	
		userDAO.addPoint(id1, point1);
		
		System.out.println(UpdateGameController.gameNo.get(recent2) + i 
				+ " update: " + gameDAO.updateGameByEndDate(UpdateGameController.gameNo.get(recent2)));
		
		Integer point2 = gameDAO.getGameByNo((UpdateGameController.gameNo.get(recent2))).getMaxPoint();	
		String id2 = bettingDAO.getMaxbPoinUser(UpdateGameController.gameNo.get(recent2));	
		userDAO.addPoint(id2, point2);
		
		RegisterGameController.gameNo.remove(recent1);
		UpdateGameController.gameNo.remove(recent2);
	}
}