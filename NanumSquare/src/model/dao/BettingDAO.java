package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Betting;
import model.Game;

public class BettingDAO {
	private JDBCUtil jdbcUtil = null;
	
	public BettingDAO() {			
		jdbcUtil = new JDBCUtil();
	}
	
	public int getSeq()
    {
		String sql = "SELECT SEQ_BETTING.NEXTVAL FROM DUAL ";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		int gameNo = 0;
        
        try {
        	ResultSet rs = jdbcUtil.executeQuery();	
            
            if(rs.next())
            	gameNo = rs.getInt("NEXTVAL");
 
        } catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
        
        return gameNo;    
    }

	public int insertBetting(Betting betting) {
		String sql = "INSERT INTO BETTING (bet_no, b_point, game_no, upload_date, user_no) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {betting.getBetNo(), betting.getbPoint(), betting.getGameNo(), betting.getUploadDate(), betting.getUserNo()};
		
		jdbcUtil.setSqlAndParameters(sql, param);

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
	}

	public List<Betting> getGameBetting(Integer gameNo) {
		String sql = "SELECT bet_no, b_point, game_no, upload_date, NANUM_USER.id "
				+ "FROM BETTING, NANUM_USER "
				+ "WHERE game_no=? AND BETTING.user_no = NANUM_USER.user_no";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {gameNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Betting> bettingList = new ArrayList<Betting>(); 
			while (rs.next()) {						
				Betting betting = new Betting(rs.getInt("bet_no"),
						rs.getInt("b_point"),
						rs.getInt("game_no"),
						rs.getDate("upload_date"),
						rs.getString("id"));
				bettingList.add(betting);	
			}
			return bettingList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public String getMaxbPoinUser(Integer gameNo) {
		// TODO Auto-generated method stub
		String sql = "SELECT NANUM_USER.id "
				+ "FROM BETTING, NANUM_USER "
				+ "WHERE game_no=? AND BETTING.user_no = NANUM_USER.user_no AND ROWNUM = 1"
				+ "ORDER BY b_point, upload_date";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {gameNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				return rs.getString("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int redeemPoint(Integer userNo, Integer bPoint) {
		String sql = "UPDATE NANUM_USER SET point = point - ? WHERE user_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {bPoint, userNo});
		
		try {				
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	public Integer deleteBetting(Integer gameNo) {
		String sql = "DELETE FROM BETTING WHERE game_no=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {gameNo});	

		try {				
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}
}
