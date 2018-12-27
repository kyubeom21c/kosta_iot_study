package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDirDAOimpl implements RoomDirDAO {
	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private final String USER = "boardgame";
	private final String PASSWORD = "hi123456";

	private final String SQL_INSERT = "insert into room(num) values(seq_room_num.nextval)";
	private final String SQL_DELETE = "delete from room where num=?";
	private final String SQL_SELECT_ONE = "select * from room where num=?";
	private final String SQL_SELECT_ALL = "select * from room order by num asc";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;

	@Override
	public int insert(RoomVO vo) {
		System.out.println("insert()");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = conn.prepareStatement(SQL_INSERT);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // end finally
		return result;
	}

	@Override
	public int delete(RoomVO vo) {
		System.out.println("delete");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // end finally
		return result;
	}

	@Override
	public List<RoomVO> selectAll() {
		System.out.println("selectAll()..");
		List<RoomVO> roomList = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RoomVO vo = new RoomVO();
				vo.setNum(rs.getInt("num"));
				vo.setTime(rs.getInt("time"));
				vo.setRemain(rs.getInt("remain"));
				vo.setRoomGame(rs.getString("roomGame"));
				roomList.add(vo);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // end finally
		return roomList;
	}

	@Override
	public RoomVO selectOne(RoomVO vo) {
		System.out.println("selectOne");
		
		RoomVO vo2 = new RoomVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setTime(rs.getInt("time"));
				vo2.setRemain(rs.getInt("remain"));
				vo2.setRoomGame(rs.getString("roomGame"));
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // end finally
		
		return vo2;
	}
	
	public void selectAllList() {
		List<RoomVO> roomList = selectAll();
		System.out.println("방번호/이용시간/이용여부");
		for (RoomVO vo2 : roomList) {
			System.out.print(vo2.getNum()+ " / ");
			System.out.print(vo2.getTime()+ " / ");
			if (vo2.getRemain() == 1) {
				System.out.println("이용중");
			}
			else if (vo2.getRemain() == 0) {
				System.out.println("이용안함");
			}
		} // end for
	}

}
