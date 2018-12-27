package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonsterDAOimpl implements MonsterDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "team05";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into monster (num,name,hp,attack,defense) values (seq_monster_num.nextval,?,?,?,? )";
	private final String SQL_DELETE = "delete from monster";
	private final String SQL_DROP = "drop sequence seq_monster_num";
	private final String SQL_CREATE = "create sequence seq_monster_num";
	private final String SQL_SELECT_ONE = "select * from monster where num=?";
	private final String SQL_UPDATE = "update monster set hp=?, attack=?, defense=? where num=?";

	public MonsterDAOimpl() {

		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("driver failed");
		}

	}// end

	public void setStat() {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = conn.prepareStatement(SQL_CREATE);
			result = pstmt.executeUpdate();

			MonsterVO vo1 = new MonsterVO();

			vo1.setName("Apeach");
			vo1.setHp(100);
			vo1.setAttack(30);
			vo1.setDefense(5);

			MonsterVO vo2 = new MonsterVO();

			vo2.setName("Neo");
			vo2.setHp(150);
			vo2.setAttack(40);
			vo2.setDefense(10);

			MonsterVO vo3 = new MonsterVO();////////////

			vo3.setName("JayG");
			vo3.setHp(200);
			vo3.setAttack(50);
			vo3.setDefense(15);

			MonsterVO vo4 = new MonsterVO();

			vo4.setName("Muzi_Con");
			vo4.setHp(250);
			vo4.setAttack(60);
			vo4.setDefense(20);

			insert(vo1);
			insert(vo2);
			insert(vo3);
			insert(vo4);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int insert(MonsterVO vo) {
		System.out.println("insert()...........");

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getHp());
			pstmt.setInt(3, vo.getAttack());
			pstmt.setInt(4, vo.getDefense());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}// end insert

	@Override
	public int deleteAll() {
		System.out.println("deleteAll()...........");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_DELETE);
			result = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(SQL_DROP);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public MonsterVO selectOne(MonsterVO vo) {
		System.out.println("selectOne()...........");
		MonsterVO vo2 = new MonsterVO();
		try {
			int num = vo.getNum();
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setName(rs.getString("name"));
				vo2.setHp(rs.getInt("hp"));
				vo2.setAttack(rs.getInt("attack"));
				vo2.setDefense(rs.getInt("defense"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo2;
	}

	@Override
	public int update(MonsterVO vo) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setInt(1, vo.getHp());
			pstmt.setInt(2, vo.getAttack());
			pstmt.setInt(3, vo.getDefense());
			pstmt.setInt(4, vo.getNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}// end class
