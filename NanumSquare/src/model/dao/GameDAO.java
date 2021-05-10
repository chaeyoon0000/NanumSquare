package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Game;

public class GameDAO{
	private JDBCUtil jdbcUtil = null;
	
	public GameDAO() {			
		jdbcUtil = new JDBCUtil();
	}
	
	public int getSeq()
    {
		String sql = "SELECT SEQ_GAME.NEXTVAL FROM DUAL ";
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

	public List<Game> getGameList() {
		String sql = "SELECT game_no, NANUM_USER.id, end_date, state, b_point, max_point "
				+ "FROM GAME, NANUM_USER "
				+ "WHERE GAME.user_no = NANUM_USER.user_no AND b_point = max_point "
				+ "ORDER BY game_no DESC";
		
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Game> gameList = new ArrayList<Game>(); 
			while (rs.next()) {						
				Game game = new Game(rs.getInt("game_no"),
						rs.getString("id"),
						rs.getDate("end_date"),
						rs.getInt("state"),
						rs.getInt("b_point"),
						rs.getInt("max_point"));
				gameList.add(game);	
			}
			return gameList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public Game getGameByNo(Integer gameNo) {
		String sql = "SELECT game_no, b_point, NANUM_USER.id, upload_date, state, max_point, end_date "
				+ "FROM GAME, NANUM_USER "
				+ "WHERE game_no=? AND GAME.user_no = NANUM_USER.user_no AND ROWNUM = 1 " 
				+ "ORDER BY upload_date DESC";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {gameNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				Game game = new Game(gameNo,
						rs.getInt("b_point"),
						rs.getString("id"),
						rs.getDate("upload_date"),
						rs.getDate("end_date"),
						rs.getInt("state"),
						rs.getInt("max_point"));
				return game;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public int insertGame(Game game) {
		String sql = "INSERT INTO GAME (game_no, b_point, user_no, upload_date, state, max_point, end_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {game.getGameNo(), game.getbPoint(), game.getUser().getUserNo(), game.getUploadDate(),
				game.getState(), game.getMaxPoint(), game.getEndDate()};
		
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

	public int updateGame(Game game) {
		String sql = "UPDATE GAME "
				+ "SET b_point = ?, user_no = ?, upload_date = ?, state = ?, "
				+ "max_point = ?, end_date = ? "
				+ "WHERE game_no = ?";
		
		Object[] param = new Object[] {game.getbPoint(), game.getUser().getUserNo(), game.getUploadDate(),
				game.getState(), game.getMaxPoint(), game.getEndDate(), game.getGameNo()};
		
		jdbcUtil.setSqlAndParameters(sql, param);
			
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

	public int deleteGame(Integer gameNo) {
		String sql = "DELETE FROM GAME WHERE game_no=?";		
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
	
	public int updateGameState(Integer gameNo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE GAME SET state = '1' WHERE game_no = ?";
		
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

	public String getGameUploadUser(Integer gameNo) {
		// TODO Auto-generated method stub
		String sql = "SELECT NANUM_USER.id "
				+ "FROM GAME, NANUM_USER "
				+ "WHERE game_no=? AND GAME.user_no = NANUM_USER.user_no AND ROWNUM = 1 "
				+ "ORDER BY upload_date";
		
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

	public Integer getMaxPoint(Integer gameNo) {
		// TODO Auto-generated method stub
		String sql = "SELECT max_point "
				+ "FROM GAME "
				+ "WHERE game_no=? AND ROWNUM = 1 "
				+ "ORDER BY max_point";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {gameNo});
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				return rs.getInt("max_point");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public String getGameEndDate(Integer gameNo) {
		String sql = "SELECT TO_CHAR(end_date,'YYYY-MM-DD HH24:MI') AS end FROM GAME WHERE game_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {gameNo});
		
		String endDate = "";
        
        try {
        	ResultSet rs = jdbcUtil.executeQuery();	
            
            if(rs.next())
            	endDate = rs.getString("end");
 
        } catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
        
        return endDate;    
	}

	public Integer updateGameByEndDate(Integer gameNo) {
		String sql = "UPDATE GAME SET state = ? WHERE game_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {1, gameNo});
		
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

	public Integer updateMaxPoint(Integer gameNo, Integer bPoint) {
		String sql = "UPDATE GAME SET max_point = ? WHERE game_no = ?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {bPoint, gameNo});
		
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
