package controller.category;



import java.sql.SQLException;
import java.util.List;

import model.Circle;
import model.dao.CircleDAO;


public class CircleManager {
   private static CircleManager circleMan = new CircleManager();
   private CircleDAO circleDAO;
   //private UserAnalysis userAanlysis;
   
   private CircleManager() {
      try {
         circleDAO = new CircleDAO();
      }catch (Exception e) {e.printStackTrace(); }
   }
   
   public static CircleManager getInstance() {
      return circleMan;
   }
   
   public List<Circle> getCircleList(int catNo) throws SQLException{
      return circleDAO.getCircleList();
   }

   public List<Circle> getCircleList() throws SQLException {
      // TODO Auto-generated method stub
      return circleDAO.getCircleList();
   }
   
}