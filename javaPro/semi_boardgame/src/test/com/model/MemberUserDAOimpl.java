package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

public class MemberUserDAOimpl implements MemberUserDAO {
	public static int failCount=0;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "boardgame";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into member(num,id,pw,name,tel) values(seq_member_num.nextval,?,?,?,?)";
	private final String SQL_SELECT_ONE = "select * from member where name=? and tel=?";
	private final String SQL_SELECT_PW = "select * from member where name=? and tel=? and id=?";
	
	public MemberUserDAOimpl() {

		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("driver failed...");
		}

	}

	@Override
	public int insertMember(MemberVO vo) {
		System.out.println("insertMember()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());

		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("pstmt failed..");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public MemberVO findId(MemberVO vo) {
		System.out.println("findId()...");
		System.out.println(vo.getName());
		System.out.println(vo.getTel());

		MemberVO vo2 = new MemberVO();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setId(rs.getString("id"));

			}
		} catch (SQLException e) {
			System.out.println("pstmt failed...");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return vo2;
	}

	@Override
	public MemberVO findPw(MemberVO vo) {
		System.out.println("findPw()...");
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		System.out.println(vo.getId());

		MemberVO vo2 = new MemberVO();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_SELECT_PW);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setPw(rs.getString("pw"));

			}
		} catch (SQLException e) {
			System.out.println("pstmt failed...");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return vo2;
	}

	@Override
	public MemberVO loginCheck_1(MemberVO vo) {
		System.out.println("loginCheck()..");
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());

		List<MemberVO> vos = new ArrayList<>();
		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn success..");

			pstmt = conn.prepareStatement("select * from member where id=? and pw=?");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setName(rs.getString("name"));
				
			}

		} catch (SQLException e) {
			System.out.println("conn failed..");
			e.printStackTrace();
		}
		return vo2;
	}
	
	
	@Override
	public MemberVO loginCheck_2(MemberVO vo) {
		System.out.println("loginCheck()..");
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());

		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn success..");

			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if(rs.getString("pw").equals(vo.getPw())) {
					vo2 = new MemberVO();
					vo2.setId(rs.getString("id"));
					vo2.setName(rs.getString("name"));
					failCount = 0;
				}
				else {
					failCount++;
				}
				
			}

		} catch (SQLException e) {
			System.out.println("conn failed..");
			e.printStackTrace();
		}
		return vo2;
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("loginCheck()..");
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());

		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn success..");

			pstmt = conn.prepareStatement("select * from member where name=? and tel=?");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
			}

		} catch (SQLException e) {
			System.out.println("conn failed..");
			e.printStackTrace();
		}
		return vo2;
	}

	@Override
	public MemberVO pwCheck(MemberVO vo) {
		System.out.println("loginCheck()..");
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());

		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn success..");

			pstmt = conn.prepareStatement("select * from member where name=? and tel=? and id=?");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
				vo2.setTel(rs.getString("id"));
			}

		} catch (SQLException e) {
			System.out.println("conn failed..");
			e.printStackTrace();
		}
		return vo2;
	}


	
	


}
