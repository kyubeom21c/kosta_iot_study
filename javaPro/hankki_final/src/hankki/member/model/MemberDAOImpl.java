package hankki.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "KOSTA";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into client_info (num,name,tel,email,card,address) values (seq_mem_num.nextval, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE = "UPDATE CLIENT_INFO SET NAME=? , TEL=?,  CARD=?, EMAIL=? ,ADDRESS=?     WHERE NUM = ?";
	private final String SQL_DELETE = "DELETE FROM CLIENT_INFO WHERE NUM = ?";
	private final String SQL_SELECTONE = "SELECT * FROM CLIENT_INFO WHERE NUM=?";
	private final String SQL_SELECTALL = "SELECT * FROM CLIENT_INFO";
	private final String SQL_SELECTCLIENTINFO = "SELECT NUM,NAME,TEL,CARD,EMAIL,ADDRESS FROM CLIENT_INFO WHERE EMAIL=? AND TEL=?";

	public MemberDAOImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Succesed...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Failed...");
			e.printStackTrace();
		}

	}

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()...");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getCard());
			pstmt.setString(5, vo.getAddress());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		System.out.println("update()...");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getCard());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setInt(6, vo.getNum());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete()...");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()...");
		MemberVO vo2 = new MemberVO();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery(); // 반환값이 온다

			while (rs.next()) {
			
				vo2.setNum(rs.getInt("NUM"));			
				vo2.setName(rs.getString("NAME"));
				vo2.setTel(rs.getString("TEL"));
				vo2.setEmail(rs.getString("EMAIL"));
				vo2.setCard(rs.getString("CARD"));
				vo2.setAddress(rs.getString("ADDRESS"));

				

			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo2;
	}
//	public MemberVO selectOne(MemberVO vo) {
//		MemberVO vo2 = new MemberVO();
//		System.out.println("selectOne()...");
//		try {
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			pstmt = conn.prepareStatement(SQL_SELECTONE);
//			pstmt.setInt(1, vo.getNum());
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				System.out.println("NUM: " + rs.getInt("NUM"));
//				System.out.println("NAME: " + rs.getString("NAME"));
//				System.out.println("PW: " + rs.getString("PW"));
//				System.out.println("ID: " + rs.getString("ID"));
//				System.out.println("TEL: " + rs.getString("TEL"));
//				
//				vo2.setNum(rs.getInt("NUM"));
//				vo2.setName(rs.getString("NAME"));
//				vo2.setPw(rs.getString("PW"));
//				vo2.setId(rs.getString("ID"));
//				vo2.setTel(rs.getString("TEL"));
//				
//				
//			}
//			
//			
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//		return vo2;
//	}

	
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()...");
		List <MemberVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				MemberVO vo3 = new MemberVO();
				
				vo3.setNum(rs.getInt("NUM"));
				vo3.setName(rs.getString("NAME"));
				vo3.setTel(rs.getString("TEL"));
				vo3.setEmail(rs.getString("EMAIL"));
				vo3.setCard(rs.getString("CARD"));
				vo3.setAddress(rs.getString("ADDRESS"));
				vos.add(vo3);
			}
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return vos;
	

		
	}
	
	@Override
	public MemberVO getClientInfo(String email, String tel) {
		MemberVO vo4 = new MemberVO();
		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTCLIENTINFO);
			pstmt.setString(1, email);
			pstmt.setString(2, tel);
			rs = pstmt.executeQuery(); // 반환값이 온다

			while (rs.next()) {
				vo4.setNum(rs.getInt("NUM"));
				vo4.setName(rs.getString("NAME"));
				vo4.setTel(rs.getString("TEL"));
				vo4.setEmail(rs.getString("EMAIL"));
				vo4.setCard(rs.getString("CARD"));
				vo4.setAddress(rs.getString("ADDRESS"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo4;
	}
}// end class
