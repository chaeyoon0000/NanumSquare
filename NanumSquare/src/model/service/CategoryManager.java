package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CategoryDAO;
import model.dao.CircleDAO;
import model.Category;
import model.Circle;


/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class CategoryManager {
	private static CategoryManager categoryMan = new CategoryManager();
	private CategoryDAO categoryDAO;
	private CircleDAO circleDAO;
	//private UserAnalysis userAanlysis;
	
	private CategoryManager() {
		try {
			categoryDAO = new CategoryDAO();
		}catch (Exception e) {e.printStackTrace(); }
	}
	
	public static CategoryManager getInstance() {
		return categoryMan;
	}
	
	public List<model.Category> getCategoryList() throws SQLException{
		return categoryDAO.getCategoryList();
	}
	
	public Category findCategory(int catNo) throws SQLException {
		Category cat = categoryDAO.findCategory(catNo); 
		
		System.out.println(cat + "xxxxxxxxxxxx");
		
		List<Circle> memberList = circleDAO.getCircleByCategory(catNo);
		cat.setCircleList(memberList);
		
		//System.out.println(memberList + "2222222222222222222222");
//		int numOfMembers = categoryDAO.getNumberOfUsersInCommunity(catNo);
//		catno.setNumOfMembers(numOfMembers);
		return cat;
	}


}
	

//	private CategoryManager() {
//		try {
//			category = new Category();
//			userAanlysis = new UserAnalysis(category);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}			
//	}
//	
//	public static CategoryManager getInstance() {
//		return CatMan;
//	}
//	
//	public int create(User user) throws SQLException, ExistingUserException {
//		if (category.existingUser(user.getUserId()) == true) {
//			throw new ExistingUserException(user.getUserId() + "�� �����ϴ� ���̵��Դϴ�.");
//		}
//		return category.create(user);
//	}
//
//	public int update(User user) throws SQLException {
//		return category.update(user);
//	}	
//
//	public int remove(String userId) throws SQLException {
//		return category.remove(userId);
//	}
//
//	public User findUser(String userId)
//		throws SQLException, UserNotFoundException {
//		User user = category.findUser(userId);
//		
//		if (user == null) {
//			throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
//		}		
//		return user;
//	}
//
//	public List<User> findUserList() throws SQLException {
//			return category.findUserList();
//	}
//	
//	public List<User> findUserList(int currentPage, int countPerPage)
//		throws SQLException {
//		return category.findUserList(currentPage, countPerPage);
//	}
//
//	public boolean login(String userId, String password)
//		throws SQLException, UserNotFoundException, PasswordMismatchException {
//		User user = findUser(userId);
//
//		if (!user.matchPassword(password)) {
//			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
//		}
//		return true;
//	}
//
//	public List<User> makeFriends(String userId) throws Exception {
//		return userAanlysis.recommendFriends(userId);
//	}
//	
//	public UserDAO getUserDAO() {
//		return this.category;
//	}
