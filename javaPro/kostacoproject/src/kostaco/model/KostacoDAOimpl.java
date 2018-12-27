package kostaco.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KostacoDAOimpl implements KostacoDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kostaco";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into list_table(name, price, amount) values(?, ?, ?)";
	private final String SQL_UPDATE = "update kostaco_table set amount=amount-? where name=?";
	private final String SQL_DELETE = "delete from list_table";
	private final String SQL_SELECT_ALL = "select * from list_table";
	private final String SQL_SELECT_ONE = "select * from kostaco_table where name=?";
	private final String SQL_SELECT_CODE3 = "select * from kostaco_table where code=? and amount>0";
	private final String SQL_SELECT_CODE2 = "select * from kostaco_table where code=? and amount>0";
	private final String SQL_SELECT_CODE1 = "select * from kostaco_table where code=? and amount>0";

	private int result = 0;
	private ResultSet rs = null;

	public KostacoDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(KostacoVO vo) {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPrice());
			pstmt.setInt(3, vo.getAmount());

			result = pstmt.executeUpdate();
			System.out.println("insert result : " + result);
		} catch (SQLException e) {
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
	public int update(KostacoVO vo) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				pstmt = conn.prepareStatement(SQL_UPDATE);
				
				pstmt.setInt(1, rs.getInt("amount"));
				pstmt.setString(2, rs.getString("name"));
				
				result = pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			System.out.println("pstmt failed");
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
	public int delete() {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_DELETE);

			result = pstmt.executeUpdate();
			System.out.println("delete result : " + result);
		} catch (SQLException e) {
			System.out.println("pstmt failed");
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
	public List<KostacoVO> selectAll() {
		List<KostacoVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				KostacoVO vo = new KostacoVO();

				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getString("price"));
				vo.setAmount(Integer.parseInt(rs.getString("amount")));

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
	public KostacoVO selectOne(KostacoVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getName());
		KostacoVO vo2 = new KostacoVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectOne conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setString(1, vo.getName());
			System.out.println("selectOne sql ok..");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo2.setName(rs.getString("name"));
				vo2.setPrice(rs.getString("price"));
				vo2.setAmount(rs.getInt("amount"));
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
	public List<KostacoVO> selectCode3() {
		List<KostacoVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_CODE3);
			
			pstmt.setInt(1, 3);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				KostacoVO vo = new KostacoVO();
				
				vo.setImg(rs.getString("img"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getString("price"));
				vo.setAmount(Integer.parseInt(rs.getString("amount")));
				
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	public List<KostacoVO> selectCode2() {
		List<KostacoVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_CODE2);
			
			pstmt.setInt(1, 2);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				KostacoVO vo = new KostacoVO();
				
				vo.setImg(rs.getString("img"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getString("price"));
				vo.setAmount(Integer.parseInt(rs.getString("amount")));
				
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	public List<KostacoVO> selectCode1() {
		List<KostacoVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_CODE1);
			
			pstmt.setInt(1, 1);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				KostacoVO vo = new KostacoVO();
				
				vo.setImg(rs.getString("img"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getString("price"));
				vo.setAmount(Integer.parseInt(rs.getString("amount")));
				

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
