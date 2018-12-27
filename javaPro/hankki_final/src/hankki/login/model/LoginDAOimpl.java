package hankki.login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginDAOimpl implements LoginDAO {

	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;

	private final String CLASSNAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	private final String SQL_LOGIN = "select name from client_info where email=? and tel=?";

	public LoginDAOimpl() {
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean userLogin(String email, String tel) {
		boolean loginCheck = false;
		System.out.println(SQL_LOGIN);
		System.out.println(email);
		System.out.println(tel);
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_LOGIN);
			pstmt.setString(1, email);
			pstmt.setString(2, tel);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("¼º°ø");
				loginCheck = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginCheck;
	}

}
