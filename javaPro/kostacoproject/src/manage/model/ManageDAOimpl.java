package manage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageDAOimpl implements ManageDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kostaco";
	private final String PASSWORD = "hi123456";

	//private final String SQL_INSERT = "insert into list_table(name, price, amount) values(?, ?, ?)";
	private final String SQL_UPDATE = "update kostaco_table set amount=amount+? where name=?";
	//private final String SQL_DELETE = "delete from list_table";
	private final String SQL_SELECT_ALL = "select * from kostaco_table";
	private final String SQL_SELECT_ONE = "select * from kostaco_table where name=?";
	
	private int result = 0;
	private ResultSet rs = null;

	public ManageDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed");
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(ManageVO vo) {
		return 0;
	}

	@Override
	public int update(ManageVO vo) {
		System.out.println("update======");

		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE);

			pstmt.setInt(1, vo.getAmount());
			pstmt.setString(2, vo.getName());

			result = pstmt.executeUpdate();

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
	public int delete(ManageVO vo) {
		return 0;
	}

	@Override
	public List<ManageVO> selectAll() {
		List<ManageVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ManageVO vo = new ManageVO();

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
	public ManageVO selectOne(ManageVO vo) {
		ManageVO vo2 = new ManageVO();
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

}
