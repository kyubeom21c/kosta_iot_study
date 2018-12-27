package member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kostaco.model.KostacoVO;

public class MemberDAOimpl implements MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ORACLE_USER = "kostaco";
	private final String ORACLE_PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into member_list (name, id, pw, address, tel) values (?, ?, ?, ?, ?) ";
	private final String SQL_UPDATE = "update member_list set id=?, pw=?, name=?, tel=? where num=? ";
	private final String SQL_DELETE = "delete from member_list where num=? ";
	private final String SQL_SELECTONE = "select * from member_list where id=?";
	private final String SQL_SELECT_ALL = "select * from member_list ";

	public MemberDAOimpl() {

		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver sucessed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}

	}

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert...");
		int result = 0;

		try {
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PASSWORD);

			System.out.println("conn successed...\n");

			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getTel());

			result = pstmt.executeUpdate();

			System.out.println("result : " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll===");

		List<MemberVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();

				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));

				vos.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return vos;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()....");

		MemberVO vo2 = new MemberVO();

		try {

			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PASSWORD);

			System.out.println("selectOne conn successed..");

			System.out.println(vo.getId());

			pstmt = conn.prepareStatement(SQL_SELECTONE);

			pstmt.setString(1, vo.getId());

			System.out.println("selectOne sql ok..");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setName(rs.getString("name"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setAddress(rs.getString("address"));
				vo2.setTel(rs.getString("tel"));
			}

		} catch (SQLException e) {
			System.out.println("selectOne sql failed..");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}