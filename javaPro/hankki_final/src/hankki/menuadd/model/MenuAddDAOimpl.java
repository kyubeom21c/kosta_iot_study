package hankki.menuadd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuAddDAOimpl implements MenuAddDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	
	private final String SQL_INSERT = "insert into menu_info(num,kind,name,cooktm,price)values (seq_order_num.nextval,?,?,?,?)";
	private final String SQL_UPDATE = "update menu_info set kind=?,name=?,cooktm=?,price=? where num=?";
	private final String SQL_DELETE = "delete from menu_info where num=?";
	private final String SQL_SELECT_ALL = "select * from menu_info order by num asc";//숫자 위에서 아래로 : asc, 숫자 아래서 위로 : desc
	private final String SQL_SELECT_ONE = "select * from menu_info where num=?";
	private final String SQL_SELECT_KIND = "select *from menu_info where kind=?";
	private final String SQL_SELECT_LIKE = "select* from menu_info where name like ?";
	//name like '%흑%';

	public MenuAddDAOimpl() {
		System.out.println("hankkiAddDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MenuAddVO vo) {
		System.out.println("insert()....");
		System.out.println(vo.getKind());
		System.out.println(vo.getName());
		System.out.println(vo.getCooktm());
		System.out.println(vo.getPrice());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("insert conn successed..");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getKind());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getCooktm());
			pstmt.setInt(4, vo.getPrice());
			System.out.println("insert sql ok..");
			result = pstmt.executeUpdate();
			System.out.println("insert result:"+result);
		} catch (SQLException e) {
			System.out.println("insert sql failed..");
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
	public int update(MenuAddVO vo) {
		System.out.println("update()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getKind());
		System.out.println(vo.getName());
		System.out.println(vo.getCooktm());
		System.out.println(vo.getPrice());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("update conn successed..");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getKind());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getCooktm());
			pstmt.setInt(4, vo.getPrice());
			pstmt.setInt(5, vo.getNum());
			System.out.println("update sql ok..");
			result = pstmt.executeUpdate();
			System.out.println("update result:"+result);
			
		} catch (SQLException e) {
			System.out.println("update sql failed..");
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
	public int delete(MenuAddVO vo) {
		System.out.println("delete()....");
		System.out.println(vo.getNum());
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("delete conn successed..");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			System.out.println("delete sql ok..");
			result = pstmt.executeUpdate();
			System.out.println("delete result:"+result);
		} catch (SQLException e) {
			System.out.println("delete sql failed..");
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
	public MenuAddVO selectOne(MenuAddVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getNum());
		MenuAddVO vo2 = new MenuAddVO();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectOne conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			System.out.println("selectOne sql ok..");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setKind(rs.getString("kind"));
				vo2.setName(rs.getString("name"));
				vo2.setCooktm(rs.getInt("cooktm"));
				vo2.setPrice(rs.getInt("price"));
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
	public List<MenuAddVO> selectAll() {
		System.out.println("selectAll()....");
		List<MenuAddVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectAll conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			System.out.println("selectAll sql ok..");
			rs = pstmt.executeQuery();//쿼리 받고 = 쿼리 날리기
			while(rs.next()) {
				MenuAddVO vo = new MenuAddVO();
				vo.setNum(rs.getInt("num"));
				vo.setKind(rs.getString("kind"));
				vo.setName(rs.getString("name"));
				vo.setCooktm(rs.getInt("cooktm"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll sql failed..");
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
	public List<MenuAddVO> selectKind(String keyword) {
		//selectAll 똑같이

		System.out.println("selectKind()....");
		List<MenuAddVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectKind conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_KIND);
			pstmt.setString(1, keyword);//int는 int타입 String은 String타입으로!!
			System.out.println("selectKind sql ok..");
			rs = pstmt.executeQuery();//쿼리 받고 = 쿼리 날리기
			while(rs.next()) {
				MenuAddVO vo = new MenuAddVO();
				vo.setNum(rs.getInt("num"));
				vo.setKind(rs.getString("kind"));
				vo.setName(rs.getString("name"));
				vo.setCooktm(rs.getInt("cooktm"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll sql failed..");
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
	
		//쿼리 변경 SQL_SELEC_TALL => SQL_SELECT_KIND
		//? 개수 맞게 세팅
	}

	@Override
	public List<MenuAddVO> like(String keyword) {
		System.out.println("like()....");
		List<MenuAddVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("selectKind conn successed..");
			pstmt = conn.prepareStatement(SQL_SELECT_LIKE);
			pstmt.setString(1, "%"+keyword+"%");//int는 int타입 String은 String타입으로!!
			System.out.println("selectKind sql ok..");
			rs = pstmt.executeQuery();//쿼리 받고 = 쿼리 날리기
			while(rs.next()) {
				MenuAddVO vo = new MenuAddVO();
				vo.setNum(rs.getInt("num"));
				vo.setKind(rs.getString("kind"));
				vo.setName(rs.getString("name"));
				vo.setCooktm(rs.getInt("cooktm"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll sql failed..");
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
		
//	
//	   @Override
//	   public String[][] listConvertArray(List<MenuAddVO> vos, int columnsCnt) {
//
//	      int count = 0;
//	      String[][] datas = new String[vos.size()][columnsCnt];
//
//	      for (MenuAddVO vo : vos) {
//	         System.out.print((count+1) + " ");
//	         System.out.print(vo.getKind() + " ");
//	         System.out.print(vo.getName() + " ");
//	         System.out.print(vo.getCooktm() + " ");
//	         System.out.println(vo.getPrice());
//	         datas[count] = new String[] { vo.getNum() + "", vo.getKind(), vo.getName(), vo.getCookTm() + "",
//	               vo.getPrice() + "" };
//	         count++;
//	      }
//	      return datas;
//	   }
		
	
}
