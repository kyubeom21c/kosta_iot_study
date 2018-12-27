package hankki.menucho.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuChoiceDAOimpl implements MenuChoiceDAO {

	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	ResultSet rs2 = null;

	int result = 1;

	private final String CLASSNAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	private final String SQL_SELECTLIKE = "select * from menu_info where name like ?";
	private final String SQL_SELECTKIND = "select * from menu_info where kind = ?";
	private final String SQL_SELECTALL = "select * from menu_info";

	public MenuChoiceDAOimpl() {
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String[][] listConvertArray(List<MenuChoiceVO> vos, int columnsCnt) {

		int count = 0;
		String[][] datas = new String[vos.size()][columnsCnt];

		for (MenuChoiceVO vo : vos) {
/*			System.out.print((count+1) + " ");
			System.out.print(vo.getKind() + " ");
			System.out.print(vo.getName() + " ");
			System.out.print(vo.getCookTm() + " ");
			System.out.println(vo.getPrice());*/
			datas[count] = new String[] { (count+1) + "", vo.getKind(), vo.getName(), vo.getCookTm() + "",
					vo.getPrice() + "" };
			count++;
		}
		return datas;
	}

	@Override
	public List<MenuChoiceVO> selectLike(String keword) {
		System.out.println("menuSelectLike()...");
		List<MenuChoiceVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTLIKE);
			pstmt.setString(1, "%"+keword+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuChoiceVO vo2 = new MenuChoiceVO();
				vo2.setNum(rs.getInt("NUM"));
				vo2.setKind(rs.getString("KIND"));
				vo2.setName(rs.getString("NAME"));
				vo2.setCookTm(rs.getInt("COOKTM"));
				vo2.setPrice(rs.getInt("PRICE"));
				vos.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vos;
	}

	@Override
	public List<MenuChoiceVO> selectAll() {
		List<MenuChoiceVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTALL);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuChoiceVO vo2 = new MenuChoiceVO();
				vo2.setNum(rs.getInt("NUM"));
				vo2.setKind(rs.getString("KIND"));
				vo2.setName(rs.getString("NAME"));
				vo2.setCookTm(rs.getInt("COOKTM"));
				vo2.setPrice(rs.getInt("PRICE"));
				vos.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vos;
	}

	@Override
	public List<MenuChoiceVO> selectKind(String keword) {
		List<MenuChoiceVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECTKIND);
			pstmt.setString(1, keword);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuChoiceVO vo2 = new MenuChoiceVO();
				vo2.setNum(rs.getInt("NUM"));
				vo2.setKind(rs.getString("KIND"));
				vo2.setName(rs.getString("NAME"));
				vo2.setCookTm(rs.getInt("COOKTM"));
				vo2.setPrice(rs.getInt("PRICE"));
				vos.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vos;
	}

}
