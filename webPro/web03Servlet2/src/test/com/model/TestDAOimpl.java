package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {

	
	
	public TestDAOimpl() {
		System.out.println("TestDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed..");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed..");
			e.printStackTrace();
		}
	}
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "java";
	private final String PASSWORD = "hi123456";
	
	private final String SQL_INSERT = "insert into test2(num,id) values(?,?)";
	private final String SQL_UPDATE = "update test2 set id=? where num=?";
	private final String SQL_DELETE = "delete from test2 where num=?";
	private final String SQL_SELECT_ALL = "select * from test2 order by num desc";
	private final String SQL_SELECT_ONE = "select * from test2 where num=?";

	
	@Override
	public int insert(TestVO vo) {
		System.out.println("insert()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getId());
			
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

	@Override
	public int update(TestVO vo) {
		System.out.println("update()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update failed...");
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

	@Override
	public int delete(TestVO vo) {
		System.out.println("delete()...");
		System.out.println(vo.getNum());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete failed...");
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

	@Override
	public TestVO selectOne(TestVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo.getNum());
		
		TestVO vo2 = new TestVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
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
	public List<TestVO> selectAll() {
		System.out.println("selectAll()...");
		List<TestVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TestVO vo = new TestVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
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

}
