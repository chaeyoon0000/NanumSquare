package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CategoryDAO;
import model.dao.CircleDAO;
import model.Category;
import model.Circle;


/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
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
//			throw new ExistingUserException(user.getUserId() + "는 존재하는 아이디입니다.");
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
//			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
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
//			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
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
