package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "java";
	private final String PASSWORD = "hi123456";
	
	private final String SQL_SELECT_ALL = "select * from member order by num desc";
	private final String SQL_SELECT_ONE = "select * from member where num=?";
	private final String SQL_INSERT = "insert into member(num,id,pw,name,tel) values(seq_member_num.nextval,?,?,?,?)";


	public MemberDAOimpl() {
		System.out.println("MemberDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed..");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed..");
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()...");
		List<MemberVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll failed...");
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return vos;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo.getNum());
		MemberVO vo2 = new MemberVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne failed...");
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return vo2;
	}

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()...");
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		int result = 0;
		
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert failed...");
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
		
		return result;
	}

}
