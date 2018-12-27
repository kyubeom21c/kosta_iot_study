package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAOimpl implements ScoreDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "team05";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into score(num,name,score) values(seq_score_num.nextval,?,?)";
	private final String SQL_SELECT_ALL = "select * from score";

	public ScoreDAOimpl() {
		System.out.println("ScoreDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(ScoreVO vo) {
		System.out.println("insert()....");
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("inser conn successed..");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getScore());
		
			result = pstmt.executeUpdate();
			System.out.println("insert result:"+result);
		} catch (SQLException e) {
			System.out.println("inser sql failed..");
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	@Override
	public List<ScoreVO> selectAll() {
		System.out.println("selectAll....");
		List<ScoreVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectAll conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			System.out.println("selectAll sql ok..");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setScore(rs.getInt("score"));
				vos.add(vo);
			} 
		} catch (SQLException e) {
			System.out.println("selectAll sql failed..");
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt !=null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn !=null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vos;
	}
}
