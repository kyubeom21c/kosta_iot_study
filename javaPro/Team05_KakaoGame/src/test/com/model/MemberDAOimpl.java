package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOimpl implements MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "team05";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into member(num,name) values (seq_member_num.nextval, ?)";
	private final String SQL_SELECT_ONE = "select * from member where num = ?";

	
	public MemberDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			String sql = SQL_INSERT;

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("pstmt failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
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
	public MemberVO selectOne(MemberVO vo) {
		MemberVO vo2 = new MemberVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			String sql = SQL_SELECT_ONE;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery(); // select

			while (rs.next()) {
				vo.setName(rs.getString("name"));
			}
			vo2.setNum(vo.getNum());
			vo2.setName(vo.getName());

		} catch (SQLException e) {
			System.out.println("pstmt failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
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
		return vo2;
	}

}
