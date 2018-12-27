package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDirDAOimpl implements MemberDirDAO {

	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "boardgame";
	private final String PASSWORD = "hi123456";

	private final String SQL_DELETE = "delete from member where num=?";
	private final String SQL_SELECT_ALL = "select * from member order by num asc";
	private final String SQL_SELECT_ONE = "select * from member where num=?";

	public MemberDirDAOimpl() {

		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("update()..");
		System.out.println(vo.getNum());
		MemberVO vo2 = new MemberVO();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
			}
			
			vo2.setId(vo.getId());
			vo2.setPw(vo.getPw());
			vo2.setName(vo.getName());
			vo2.setTel(vo.getTel());
			
		} catch (SQLException e) {
			System.out.println("pstmt failed...");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()..");
		List<MemberVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn success..");

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vos.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("conn failed..");
			e.printStackTrace();
		}

		return vos;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		System.out.println("deleteMember()....");
		System.out.println(vo.getNum());

		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed..");

			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			result = pstmt.executeUpdate();
			System.out.println("result:" + result);
		} catch (SQLException e) {
			System.out.println("pstmt failed..");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return result;
	}

}
