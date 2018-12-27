package hankki.order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hankki.member.model.MemberVO;
import hankki.menucho.model.MenuChoiceVO;

public class OrderDAOimpl implements OrderDAO {

	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	ResultSet rs2 = null;

	int result = 1;
	
	private final String CLASSNAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	private final String SQL_INSERT_LIST = "insert into order_list(num,kind,name,cooktm,price,ordernum)  values(seq_order_list_num.nextval,?,?,?,?,?)";
	private final String SQL_INSERT_INFO = "insert into order_info (ordernum, address, tel) values (?,?,?)";
	private final String SQL_SELECT_USER_INFO = "select * from client_info where tel=? and email=?";
	private final String SQL_SELECT_ORDER_INFO = "select * from order_info where tel=?";
	private final String SQL_SELECT_ORDER_LIST = "select * from order_list where ordernum=?";

	public OrderDAOimpl() {
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String[][] listConvertArray(List<OrderVO> vos, int columnsCnt) {

		int count = 0;
		String[][] datas = new String[vos.size()][columnsCnt];

		for (OrderVO vo : vos) {
			datas[count] = new String[] { (count+1) + "", vo.getKind(), vo.getName(), vo.getCookTm() + "",
					vo.getPrice() + "" };
			count++;
		}
		return datas;
	}
	


	@Override
	public int[] insertBatch(List<OrderVO> vos,String orderNum) {
		int[] result = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT_LIST);
			for (OrderVO x : vos) {
				//kind,name,cooktm,price,ordernum
				pstmt.setString(1,x.getKind() );
				pstmt.setString(2,x.getName() );
				pstmt.setInt(3,x.getCookTm() );
				pstmt.setInt(4,x.getPrice() );
				pstmt.setString(5,orderNum );
				pstmt.addBatch();
			}
			
			result = pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	
	}



	@Override
	public int insert(OrderVO vo) {
		try {
			//ORDERNUM, ADRESS, TEL, STAT
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_INSERT_INFO);
			pstmt.setString(1, vo.getOrdernum());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getTel());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MemberVO userLogin(String tel, String email) {

		MemberVO vo2 = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_USER_INFO);
			pstmt.setString(1, tel);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setName(rs.getString("NAME"));
				vo2.setTel(rs.getString("TEL"));
				vo2.setAddress(rs.getString("ADDRESS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return vo2;
	}

	@Override
	public List<OrderVO> selectOrderList(String orderNum) {

		List<OrderVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ORDER_LIST);
			pstmt.setString(1, orderNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO vo2 = new OrderVO();
				vo2.setOrdernum(rs.getString("ORDERNUM"));
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
	public List<OrderVO> selectOrderinfo(String tel) {

		List<OrderVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ORDER_INFO);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO vo2 = new OrderVO();
				vo2.setOrdernum(rs.getString("ORDERNUM"));
				vo2.setAddress(rs.getString("ADDRESS"));
				vo2.setTel(rs.getString("TEL"));
				vo2.setStat(rs.getString("STAT"));
				vos.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vos;
	}

}
