package hankki.info.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hankki.member.model.MemberVO;

public class InfoDAOImpl implements InfoDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "KOSTA";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "INSERT INTO order_info (ORDERNUM,ADDRESS, TEL, STAT)  VALUES (SEQ_INFO_NUM.NEXTVAL, ?, ?, ?, ?)";
	private final String SQL_UPDATE = "update order_info set address=?,  tel=?, stat=?      where ORDERNUM = ?";
	private final String SQL_UPDATE_STAT = "update order_info set stat=?      where ORDERNUM = ?";
	private final String SQL_DELETE = "DELETE FROM order_info WHERE ORDERNUM = ?";
	private final String SQL_SELECTONE = "SELECT * FROM order_info WHERE ORDERNUM=?";
	private final String SQL_SELECTALL = "SELECT * FROM order_info";

	@Override
	public int insert(InfoVO vo) {
		System.out.println("Insert()...");

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getOrderNum());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getStat());
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(InfoVO vo) {

		try {
			// "UPDATE INFO SET ORDERNUM=? , ADDRESS=?, TEL=?, STAT=? WHERE NUM = ?";
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getAddress());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getStat());
			pstmt.setString(4, vo.getOrderNum());
			int result = pstmt.executeUpdate();
			System.out.println("Update()..." + result);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(InfoVO vo) {
		System.out.println("delete()...");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_DELETE);
			System.out.println(vo.getOrderNum());
			pstmt.setString(1, vo.getOrderNum());
			int result = pstmt.executeUpdate();
			System.out.println("Delete()..." + result);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public InfoVO selectOne(InfoVO vo) {
		System.out.println("selectOne()...");

		InfoVO vo2 = new InfoVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTONE);
			pstmt.setString(1, vo.getOrderNum());
			rs = pstmt.executeQuery(); // 반환값이 온다

			while (rs.next()) {

				vo2.setNum(rs.getInt("NUM"));
				vo2.setOrderNum(rs.getString("ORDERNUM"));
				vo2.setAddress(rs.getString("ADDRESS"));
				vo2.setTel(rs.getString("TEL"));
				vo2.setStat(rs.getString("STAT"));

			}

			System.out.println(vo2.getOrderNum());
			System.out.println(vo2.getAddress());
			System.out.println(vo2.getTel());
			System.out.println(vo2.getStat());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo2;
	}

	@Override
	public List<InfoVO> selectAll() {
		System.out.println("selectAll()...");
		List<InfoVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				InfoVO vo3 = new InfoVO();

				vo3.setOrderNum(rs.getString("ORDERNUM"));
				vo3.setAddress(rs.getString("ADDRESS"));
				vo3.setTel(rs.getString("TEL"));
				vo3.setStat(rs.getString("STAT"));
				vos.add(vo3);
				System.out.println(vo3.getOrderNum());
				System.out.println(vo3.getAddress());
				System.out.println(vo3.getTel());
				System.out.println(vo3.getStat());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vos;

	}

	@Override
	public int update_stat(InfoVO vo) {
		try {
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE_STAT);
			pstmt.setString(1, vo.getStat());
			pstmt.setString(2, vo.getOrderNum());

			int result = pstmt.executeUpdate();
			System.out.println("Update_Stat()..." + result);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public InfoVO selectOne(String orderNum) {
		
		InfoVO vo4 = new InfoVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTONE);
			pstmt.setString(1, orderNum);
			rs = pstmt.executeQuery(); // 반환값이 온다

			while (rs.next()) {

				vo4.setOrderNum(rs.getString("ORDERNUM"));
				vo4.setAddress(rs.getString("ADDRESS"));
				vo4.setTel(rs.getString("TEL"));
				vo4.setStat(rs.getString("STAT"));

			}

			System.out.println(vo4.getOrderNum());
			System.out.println(vo4.getAddress());
			System.out.println(vo4.getTel());
			System.out.println(vo4.getStat());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo4;
	}

}
