package model.dao;

import java.sql.ResultSet;

import java.util.*;

import model.dao.JDBCUtil;

import model.Diary;
import model.QnA;


public class DiaryDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	private static String query = 	"SELECT DIARY.DIARY_NO AS DIARY_NO, " +
	  								"       DIARY.TITLE AS TITLE, " +
	  								"       DIARY.CONTENT AS CONTENT, " +
	  								"       DIARY.USER_NO AS USER_NO, " +
	  								"       DIARY.CAT_NO AS CAT_NO " +
	  								"       DIARY.UPLOAD_DATE AS UPLOAD_DATE, " +
	  								"       DIARY.IMAGE AS IMAGE, " +
	  								"       DIARY.CNT AS CNT, " +
	  								"       DIARY.LOC AS LOC, " +
	  								"       DIARY.LIKEY AS LIKEY, " +
	  								"FROM DIARY ";
	
	public DiaryDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public List<Diary> getDiaryList() {
		// TODO Auto-generated method stub
		
		String allQuery = "SELECT DIARY_NO, TITLE, CONTENT, USER_NO, CAT_NO, UPLOAD_DATE, IMAGE, CNT, LOC, LIKEY "
				+ "FROM dbp0101.DIARY "
				+ "ORDER BY DIARY_NO";
						
		
		jdbcUtil.setSqlAndParameters(allQuery, null);	// JDBCUtil �� query ����

		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			List<Diary> list = new ArrayList<Diary>();		// Diary ��ü���� ������� list ��ü
			
			while (rs.next()) {
			    Diary dto = new Diary(
				rs.getInt("DIARY_NO"),
				rs.getInt("USER_NO"),
				rs.getInt("CAT_NO"),
			    rs.getString("TITLE"),
			    rs.getString("CONTENT"),
			    rs.getDate("UPLOAD_DATE"),
			    rs.getString("IMAGE"),
				rs.getInt("CNT"),
			    rs.getString("LOC"),
				rs.getInt("LIKEY"));
				
				list.add(dto);
			}
			
			return list;		// Diary������ ������ dto ���� ����� ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		
		return null;	
	
	}
	
	public List<Diary> selectDiary() {
		// TODO Auto-generated method stub
		
		String selectQuery = "SELECT DIARY_NO, TITLE, CONTENT, USER_NO, CAT_NO, UPLOAD_DATE, IMAGE, CNT, LOC, LIKEY "
				+ "FROM dbp0101.DIARY "
				+ "ORDER BY DIARY_NO";
		
		jdbcUtil.setSqlAndParameters(selectQuery, null);		// JDBCUtil �� query ����

		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			
			List<Diary> list = new ArrayList<Diary>();		// Diary ��ü���� ������� list ��ü
			
			while (rs.next()) {
				Diary dto = new Diary(
					rs.getInt("DIARY_NO"),
					rs.getInt("USER_NO"),
					rs.getInt("CAT_NO"),
					rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getDate("UPLOAD_DATE"),
					rs.getString("IMAGE"),
					rs.getInt("CNT"),
					rs.getString("LOC"),
					rs.getInt("LIKEY"));
						
					list.add(dto);
			}
			
			return list;		// Diary������ ������ dto ���� ����� ��ȯ
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return null;
	}
	
	public Diary selectDetailDiary(int diaryNo) {
		// TODO Auto-generated method stub
		String detailQuery = "SELECT DIARY_NO, TITLE, CONTENT, USER_NO, CAT_NO, UPLOAD_DATE, IMAGE, CNT, LOC, LIKEY "
				+ "FROM dbp0101.DIARY "
				+ "WHERE DIARY_NO = ?";
	
		Object[] param = new Object[] { diaryNo };
		jdbcUtil.setSqlAndParameters(detailQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			
			Diary dto = null;
			if (rs.next()) {
				dto = new Diary(
						rs.getInt("DIARY_NO"),
						rs.getInt("USER_NO"),
						rs.getInt("CAT_NO"),
						rs.getString("TITLE"),
						rs.getString("CONTENT"),
						rs.getDate("UPLOAD_DATE"),
						rs.getString("IMAGE"),
						rs.getInt("CNT"),
						rs.getString("LOC"),
						rs.getInt("LIKEY"));
			}
			
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public Diary insertDiary(Diary diary) {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO DIARY (DIARY_NO, USER_NO, CAT_NO, TITLE, CONTENT, UPLOAD_DATE, IMAGE, CNT, LOC, LIKEY) " +
							"VALUES (SEQ_DIARY.NEXTVAL, ?, 1, ?, ?, SYSDATE, ?, 0, ?, 0) ";
		
		Object[] param = new Object[] {diary.getUserNo(), diary.getTitle(), diary.getContent(), diary.getImage(), diary.getLoc()};		

		jdbcUtil.setSqlAndParameters(insertQuery, param);			// JDBCUtil �� insert �� ����	
		
		String key[] = {"DIARY_NO"};
		
		try {				
			//jdbcUtil.executeUpdate();		// insert �� ����
			//jdbcUtil.getGeneratedKeys();

		   	int generatedKey = jdbcUtil.executeUpdate();   // ������ PK ��
		   	diary.setDiaryNo(generatedKey);

			
		   	return diary;
		   	
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		
		return null;	
	
	}

	public int updateDiary (Diary diary) {
		// TODO Auto-generated method stub
		String sql = "UPDATE DIARY "
				+ "SET TITLE=?, CONTENT=?, IMAGE=?, LOC=? "
				+ "WHERE DIARY_NO=? ";
		
		Object[] param = new Object[] {diary.getTitle(), diary.getContent(), 
				diary.getImage(), diary.getLoc(), diary.getDiaryNo()};				
		
		System.out.print(diary);
		
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// update �� ����
			return result;			// update �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return 0;
	}

	public int deleteDiary(int diaryNo) {
		// TODO Auto-generated method stub
		
		String deleteQuery = "DELETE FROM DIARY WHERE DIARY_NO = ?";

		Object[] param = new Object[] {diaryNo};
		jdbcUtil.setSqlAndParameters(deleteQuery, param);

		try {
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return 0;
	}

	public List<Diary> getDiaryByKeyword(String keyword) {
		// TODO Auto-generated method stub
		String query = "SELECT DIARY_NO, TITLE, CONTENT, USER_NO, CAT_NO, UPLOAD_DATE, IMAGE, CNT, LOC, LIKEY "
				+ "FROM DIARY "
				+ "WHERE TITLE LIKE ? OR CONTENT LIKE ?";

		String k = "%"+ keyword +"%";
		Object[] param = new Object[] {k, k};
		
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Diary> list = new ArrayList<Diary>();
			
			while (rs.next()) {
				Diary dto = new Diary(
						rs.getInt("diary_no"),
						rs.getInt("user_no"),
						rs.getInt("cat_no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("upload_date"),
						rs.getString("image"),
						rs.getInt("cnt"),
						rs.getString("loc"),
						rs.getInt("likey"));
				list.add(dto);
			}
			
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	
	}

	public List<Diary> getDiaryByCategory(int catNo) { //
		// TODO Auto-generated method stub
		String catQuery = "SELECT diary_no, NANUM_USER.name, Diary.cat_no, title, content, " + 
				"upload_date, image, cnt, loc, likey " + 
				"FROM DIARY, NANUM_USER, CATEGORY " + 
				"WHERE DIARY.user_no = NANUM_USER.user_no and DIARY.cat_no = CATEGORY.cat_no and CATEGORY.cat_no = ? "
				+ "ORDER BY upload_date desc";
				

		jdbcUtil.setSqlAndParameters(catQuery, new Object[] { catNo });

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query �� ����
			List<Diary> diarylist = new ArrayList<Diary>(); // Diary ��ü���� ������� list ��ü
			while (rs.next()) {
				Diary diary = new Diary(
						rs.getInt("diary_no"), 
						rs.getString("name"), 
						catNo, 
						rs.getString("title"),
						rs.getString("content"), 
						rs.getDate("upload_date"), 
						rs.getString("image"), 
						rs.getInt("cnt"),
						rs.getString("loc"), 
						rs.getInt("likey"));
				diarylist.add(diary);
			}

			return diarylist;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return null;

	}

	public List<Diary> getDiaryByUser(String id) {
		// TODO Auto-generated method stub
		
		String userQuery =
				"SELECT DIARY.DIARY_NO AS DIARY_NO, "
				+ "       DIARY.TITLE AS TITLE, "
				+ "       DIARY.CONTENT AS CONTENT, "
				+ "       DIARY.USER_NO AS USER_NO, "
				+ "       DIARY.CAT_NO AS CAT_NO, "
				+ "       DIARY.UPLOAD_DATE AS UPLOAD_DATE, "
				+ "       DIARY.IMAGE AS IMAGE, "
				+ "       DIARY.CNT AS CNT, "
				+ "       DIARY.LOC AS LOC, "
				+ "       DIARY.LIKEY AS LIKEY, id "
				+ "FROM DIARY, NANUM_USER "
				+ "WHERE DIARY.user_no = NANUM_USER.user_no "
				+ "AND id = ?";
	
		jdbcUtil.setSqlAndParameters(userQuery, new Object[] {id});
		
		List<Diary> list = new ArrayList<Diary>();		// Diary ��ü���� ������� list ��ü
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			Diary dto = null;
			
			while (rs.next()) {
				dto = new Diary();
				dto.setDiaryNo(rs.getInt("DIARY_NO"));
				dto.setUserNo(rs.getInt("USER_NO"));
				dto.setCatNo(rs.getInt("CAT_NO"));
			    dto.setTitle(rs.getString("TITLE"));
			    dto.setContent(rs.getString("CONTENT"));
			    dto.setUploadDate(rs.getDate("UPLOAD_DATE"));
			    dto.setImage(rs.getString("IMAGE"));
				dto.setCnt(rs.getInt("CNT"));
			    dto.setLoc(rs.getString("LOC"));
				dto.setLikey(rs.getInt("LIKEY"));
				dto.setUserId(id);
				list.add(dto);
			}
			
			return list;		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;	
	}

	public int UpdateLikey(int diaryNo) {
			// TODO Auto-generated method stub
			
		String LikeyQuery = "UPDATE DIARY "
				+ "SET LIKEY = LIKEY + 1 "
				+ "WHERE DIARY_NO=? ";

		Object[] param = new Object[] {diaryNo};
		jdbcUtil.setSqlAndParameters(LikeyQuery, param);

		try {
			
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		
		} catch (Exception ex) {
		
			jdbcUtil.rollback();
			ex.printStackTrace();		
		
		} finally {
		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		
		}
			return 0;
	}
	
	public List<Diary> getDiaryListByCnt() {
			// TODO Auto-generated method stub
			
		String CntQuery =
					"SELECT DIARY.DIARY_NO AS DIARY_NO, " +
					"       DIARY.CNT AS CNT " +
					"FROM DIARY;";
		
//		jdbcUtil.setSql(CntQuery);
		
		List<Diary> list = new ArrayList<Diary>();		// Diary ��ü���� ������� list ��ü
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			Diary dto = null;
			
			if (rs.next()) {
				dto = new Diary();
				dto.setCnt(rs.getInt("CNT"));
				list.add(dto);
			}
			
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
		return null;
		
	}
	
	public int UpdatePoint(int userNo) {
		// TODO Auto-generated method stub
		
		String PointQuery = "UPDATE NANUM_USER "
				+ "SET POINT = POINT + 10 "
				+ "WHERE USER_NO=? ";
	
		Object[] param = new Object[] {userNo};
		jdbcUtil.setSqlAndParameters(PointQuery, param);
	
		try {
			
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		
		} catch (Exception ex) {
		
			jdbcUtil.rollback();
			ex.printStackTrace();		
		
		} finally {
		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		
		}
		
		return 0;
	}
	
	public int DeletePoint(int diaryNo) {
		// TODO Auto-generated method stub
		
		String PointQuery = "UPDATE NANUM_USER "
				+ "SET POINT = POINT - 10 "
				+ "WHERE USER_NO = (SELECT USER_NO FROM DIARY WHERE DIARY_NO = ?) ";
	
		Object[] param = new Object[] {diaryNo};
		jdbcUtil.setSqlAndParameters(PointQuery, param);
	
		try {
			
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		
		} catch (Exception ex) {
		
			jdbcUtil.rollback();
			ex.printStackTrace();		
		
		} finally {
		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		
		}
		
		return 0;
	}

    public int updateDiaryCnt (Integer diaryNo) {
        
        String plusCntSql = "UPDATE DIARY SET cnt = cnt + 1 WHERE diary_no = ? ";
        
        jdbcUtil.setSqlAndParameters(plusCntSql, new Object[] {diaryNo});
        
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