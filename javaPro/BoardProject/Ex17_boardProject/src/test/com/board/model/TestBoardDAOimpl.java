package test.com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestBoardDAOimpl implements TestBoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String JDBC_USER = "C##java";
	private final String JDBC_PASSWORD = "hi123456";
	
	
	private final String SQL_INSERT = "insert into board(num,title,content,name) values(seq_board.nextval,?,?,?)";
	private final String SQL_SELECT = "select * from board order by num desc";
	private final String SQL_SEARCH = "select * from board where num=?";
	private final String SQL_UPDATE = "update board set title=?,content=?,name=?,regDate=sysdate where num=?";
	private final String SQL_DELETE = "delete from board where num=?";

	public TestBoardDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(TestBoardVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
			System.out.println("insert conn successed...");

			String sql = SQL_INSERT;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getName());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public int update(TestBoardVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
			System.out.println("update conn successed...");

			String sql = SQL_UPDATE;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getNum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public int delete(TestBoardVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
			System.out.println("delete conn successed...");

			String sql = SQL_DELETE;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public TestBoardVO search(TestBoardVO vo) {
		TestBoardVO result = new TestBoardVO();
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
			System.out.println("search conn successed...");

			String sql = SQL_SEARCH;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.setNum(rs.getInt("num"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
				result.setName(rs.getString("name"));
				result.setRegDate(rs.getDate("regDate"));
			}

		} catch (SQLException e) {
			System.out.println("search failed...");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public List<TestBoardVO> select() {
		ArrayList<TestBoardVO> list = new ArrayList<TestBoardVO>();
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
			System.out.println("select conn successed...");

			String sql = SQL_SELECT;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestBoardVO vo = new TestBoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setName(rs.getString("name"));
				vo.setRegDate(rs.getDate("regDate"));
				// System.out.println(rs.getInt("num")+","+rs.getString("name")+","+rs.getString("tel"));
				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("select failed...");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return list;
	}

}
