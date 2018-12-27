package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteBookDAOimpl implements NoteBookDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	
	private final String SQL_INSERT = "insert into notebook(num,productno,productname,modelname,price) values(seq_notebook_num.nextval,?,?,?,?)";
	private final String SQL_UPDATE = "update notebook set productno=?,productname=?,modelname=?,price=? where num=?";
	private final String SQL_DELETE = "delete from notebook where num=?";
	private final String SQL_SELECT_ALL = "select * from notebook order by num desc";
	private final String SQL_SELECT_ONE = "select * from notebook where num=?";


	public NoteBookDAOimpl() {
		System.out.println("NoteBookDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(NoteBookVO vo) {
		System.out.println("insert()....");
		System.out.println(vo.getProductNO());
		System.out.println(vo.getProductName());
		System.out.println(vo.getModelName());
		System.out.println(vo.getPrice());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("insert conn successed..");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getProductNO());
			pstmt.setString(2, vo.getProductName());
			pstmt.setString(3, vo.getModelName());
			pstmt.setInt(4, vo.getPrice());
			System.out.println("insert sql ok..");
			result = pstmt.executeUpdate();
			System.out.println("insert result:"+result);
		} catch (SQLException e) {
			System.out.println("insert sql failed..");
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
	public int update(NoteBookVO vo) {
		System.out.println("update()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getProductNO());
		System.out.println(vo.getProductName());
		System.out.println(vo.getModelName());
		System.out.println(vo.getPrice());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("update conn successed..");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getProductNO());
			pstmt.setString(2, vo.getProductName());
			pstmt.setString(3, vo.getModelName());
			pstmt.setInt(4, vo.getPrice());
			pstmt.setInt(5, vo.getNum());
			System.out.println("update sql ok..");
			result = pstmt.executeUpdate();
			System.out.println("update result:"+result);
		} catch (SQLException e) {
			System.out.println("update sql failed..");
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
	public int delete(NoteBookVO vo) {
		System.out.println("delete()....");
		System.out.println(vo.getNum());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("delete conn successed..");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			System.out.println("delete sql ok..");
			result = pstmt.executeUpdate();
			System.out.println("delete result:"+result);
		} catch (SQLException e) {
			System.out.println("delete sql failed..");
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
	public NoteBookVO selectOne(NoteBookVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getNum());
		NoteBookVO vo2 = new NoteBookVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectOne conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			System.out.println("selectOne sql ok..");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setProductNO(rs.getString("productno"));
				vo2.setProductName(rs.getString("productname"));
				vo2.setModelName(rs.getString("modelname"));
				vo2.setPrice(rs.getInt("price"));
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
	public List<NoteBookVO> selectAll() {
		System.out.println("selectAll()....");
		List<NoteBookVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectAll conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			System.out.println("selectAll sql ok..");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoteBookVO vo = new NoteBookVO();
				vo.setNum(rs.getInt("num"));
				vo.setProductNO(rs.getString("productno"));
				vo.setProductName(rs.getString("productname"));
				vo.setModelName(rs.getString("modelname"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll sql failed..");
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
