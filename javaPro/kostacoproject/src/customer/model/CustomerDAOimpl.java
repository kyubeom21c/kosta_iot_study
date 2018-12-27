package customer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kostaco.model.KostacoVO;

public class CustomerDAOimpl implements CustomerDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ORACLE_USER = "kostaco";
	private final String ORACLE_PASSWORD = "hi123456";

//	private final String sql_insert = "insert into list(name, price, amount) values ( ?, ?, ?) ";
	private final String sql_update = "update kostaco_table set amount = ? where name = ? ";
	private final String sql_delete = "delete from list_table";
//	private final String sql_selectOne = "select * from list where num=?";
	private final String sql_selectAll = "select * from list";

	public CustomerDAOimpl() {

		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver sucessed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}

	}

	@Override
	public int insert(CustomerVO vo) {
		return 0;
	}

	@Override
	public int update(KostacoVO vo) {
		System.out.println("\n 2.update...");
		int result = 0;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PASSWORD);
			System.out.println("conn successed...\n");

			pstmt = conn.prepareStatement(sql_update);

			pstmt.setInt(1, vo.getAmount());
			pstmt.setString(2, vo.getName());

			System.out.println("update sql ok..");

			result = pstmt.executeUpdate();

			System.out.println("result : " + result);

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
		} // end finally
		return result;
	}

	@Override
	public int delete(CustomerVO vo) {
		return 0;
	}

	@Override
	public List<CustomerVO> selectAll() {
		System.out.println("\n 5.selectAll...");
		List<CustomerVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(sql_selectAll);

			rs = pstmt.executeQuery();// select

			System.out.println("rs:" + rs);

			while (rs.next()) {

				CustomerVO vo1 = new CustomerVO();

				vo1.setName(rs.getString("name"));
				vo1.setAdress(rs.getString("adress"));
				vo1.setTel(rs.getString("tel"));
				vo1.setSumprice(rs.getString("sumprice"));
				vos.add(vo1);

			} // end while

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
		} // end finally

		return vos;
	}

	@Override
	public CustomerVO selectOne(CustomerVO vo) {
		return vo;
	}

}
