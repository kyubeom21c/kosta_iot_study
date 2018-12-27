package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test01DAOimpl implements Test01DAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "java";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into test(num,name, age) values(seq_test_num.nextval,?,?)";
	private final String SQL_UPDATE = "update test set name=?, age=? where num=?";
	private final String SQL_DELETE = "delete from test where num=?";
	private final String SQL_SELECT_ALL = "select * from test order by num desc";
	private final String SQL_SELECT_ONE = "select * from test where num=?";

	public Test01DAOimpl() {
		// 1.드라이버 연결:해당 데이터베이스가 제공하는
		// 드라이버(api)
		// 설정해준 후 사용할 클래스를 찾아준다.
		// Class
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Test01VO vo) {
		System.out.println("insert()...");
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		// 2.설치된 데이터베이스에 생성한
		// 도메인(uri),아이디,비번 명시를 통해 커넥팅
		// java.sql.*; Connection
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			// default true
			// conn.setAutoCommit(false);//auto commit 해제
			// 3.sql실행문 구현 및 반환
			// 구현 : ***Statement
			// 반환 : int or ResultSet
			// table=test, num=seq,name=kim, age=30
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			result = pstmt.executeUpdate();// insert,update,delete
			System.out.println("result:" + result);
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
	public int update(Test01VO vo) {
		System.out.println("update()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		// 2.설치된 데이터베이스에 생성한
		// 도메인(uri),아이디,비번 명시를 통해 커넥팅
		// java.sql.*; Connection
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			// default true
			// conn.setAutoCommit(false);//auto commit 해제
			// 3.sql실행문 구현 및 반환
			// 구현 : ***Statement
			// 반환 : int or ResultSet
			// table=test, name=kim, age=30
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setInt(3, vo.getNum());
			result = pstmt.executeUpdate();// insert,update,delete
			System.out.println("result:" + result);
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
	public int delete(Test01VO vo) {
		System.out.println("delete()...");
		System.out.println(vo.getNum());
		// 2.설치된 데이터베이스에 생성한
		// 도메인(uri),아이디,비번 명시를 통해 커넥팅
		// java.sql.*; Connection
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			// default true
			// conn.setAutoCommit(false);//auto commit 해제
			// 3.sql실행문 구현 및 반환
			// 구현 : ***Statement
			// 반환 : int or ResultSet
			// table=test, name=kim, age=30
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			result = pstmt.executeUpdate();// insert,update,delete
			System.out.println("result:" + result);
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
	public Test01VO selectOne(Test01VO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getNum());
		// 2.설치된 데이터베이스에 생성한
		// 도메인(uri),아이디,비번 명시를 통해 커넥팅
		// java.sql.*; Connection
		Test01VO vo2 = new Test01VO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			// default true
			// conn.setAutoCommit(false);//auto commit 해제
			// 3.sql실행문 구현 및 반환
			// 구현 : ***Statement
			// 반환 : int or ResultSet
			// table=test, name=kim, age=30
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setName(rs.getString("name"));
				vo2.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println("pstmt failed...");
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
	public List<Test01VO> selectAll() {
		System.out.println("selectAll()....");
		// 2.설치된 데이터베이스에 생성한
		// 도메인(uri),아이디,비번 명시를 통해 커넥팅
		// java.sql.*; Connection
		List<Test01VO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			// default true
			// conn.setAutoCommit(false);//auto commit 해제
			// 3.sql실행문 구현 및 반환
			// 구현 : ***Statement
			// 반환 : int or ResultSet
			// table=test, name=kim, age=30
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				Test01VO vo = new Test01VO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("pstmt failed...");
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

}
