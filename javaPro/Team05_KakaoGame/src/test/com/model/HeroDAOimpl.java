package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HeroDAOimpl implements HeroDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "team05";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into hero(num, name, hp, attack, defense) values(seq_hero_num.nextval , ?, ?, ?, ?)";
	private final String SQL_DELETE = "delete from hero where num=?";
	private final String SQL_UPDATE = "update hero set hp = ?, attack = ?, defense = ? where num = ?";
	private final String SQL_SELECT_ONE = "select * from hero where num=? ";
	private final String SQL_CREATE_SEQ = "create sequence seq_hero_num";
	private final String SQL_DROP_SEQ = "drop sequence seq_hero_num";

	public HeroDAOimpl() {

		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}

	}

	@Override
	public int insert() {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_CREATE_SEQ);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HeroVO vo = new HeroVO();
		vo.setNum(1);
		vo.setName("Ryan");
		vo.setHp(150);
		vo.setAttack(80);
		vo.setDefense(25);

		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getHp());
		System.out.println(vo.getAttack());
		System.out.println(vo.getDefense());
		int result1 = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getHp());
			pstmt.setInt(3, vo.getAttack());
			pstmt.setInt(4, vo.getDefense());
			result1 = pstmt.executeUpdate();
			System.out.println("result : " + result1);
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
		}

		vo.setNum(2);
		vo.setName("Frodo");
		vo.setHp(150);
		vo.setAttack(40);
		vo.setDefense(50);

		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getHp());
		System.out.println(vo.getAttack());
		System.out.println(vo.getDefense());
		int result2 = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getHp());
			pstmt.setInt(3, vo.getAttack());
			pstmt.setInt(4, vo.getDefense());
			result2 = pstmt.executeUpdate();
			System.out.println("result : " + result2);
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
		}

		vo.setNum(3);
		vo.setName("Tube");
		vo.setHp(300);
		vo.setAttack(40);
		vo.setDefense(25);

		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getHp());
		System.out.println(vo.getAttack());
		System.out.println(vo.getDefense());
		int result3 = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getHp());
			pstmt.setInt(3, vo.getAttack());
			pstmt.setInt(4, vo.getDefense());
			result3 = pstmt.executeUpdate();
			System.out.println("result : " + result3);
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
		}

		int finalResult = result1 + result2 + result3;

		return finalResult;
	}

	@Override
	public int delete() {
		// 게임이 끝날 때 능력치가 향상된 주인공을 지우는 역할
		// stage에서 져서 게임이 끝나게 되면 향상된 능력치를 가진 주인공을 지운다
		// 그다음에 초기화된 능력치를 가진 주인공을 다시 가져와야겠지
		System.out.println("Hero delete...");

		
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, 1);
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
		}

		int result2 = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, 2);
			result2 = pstmt.executeUpdate();
			System.out.println("result : " + result2);
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
		}

		int result3 = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, 3);
			result3 = pstmt.executeUpdate();
			System.out.println("result : " + result3);
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
		}

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_DROP_SEQ);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int finalResult = result + result2 + result3;

		return finalResult;
	}

	@Override
	public HeroVO selectOne(HeroVO vo) {
		// 처음 게임을 시작 할 때 주인공 캐릭터를 호출하는 역할
		System.out.println("Hero selectOne...");
		HeroVO vo2 = new HeroVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setName(rs.getString("name"));
				vo2.setAttack(rs.getInt("attack"));
				vo2.setDefense(rs.getInt("defense"));
				vo2.setHp(rs.getInt("hp"));
			}
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
		}
		return vo2;
	}

	@Override
	public int update(HeroVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			String sql = SQL_UPDATE;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getHp());
			pstmt.setInt(2, vo.getAttack());
			pstmt.setInt(3, vo.getDefense());
			pstmt.setInt(4, vo.getNum());

			result = pstmt.executeUpdate();

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
		}
		return result;
	}
}
