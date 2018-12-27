package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class AnswerDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	private final String SQL_INSERT = "insert into person(num,name,age,gender,qnas,title) values(seq_person_num.nextval,?,?,?,?,?)";
	private final String SQL_DELETE = "delete from person where num = ?";
	private final String SQL_SELECT_ALL = "select * from person order by num asc";

	public AnswerDAO() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	public int insert(QuestionVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = SQL_INSERT;

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getGender());
			pstmt.setString(3, vo.getName());
			pstmt.setString(2, vo.getAge());
			String str = "";

			for (int i = 0; i < vo.questionNum; i++) {
				if(i < vo.questionNum-1)
				str += vo.qnaL.get(i)[5]+"-";
				else
				str += vo.qnaL.get(i)[5];
			}
			pstmt.setString(4, str); // 사용자가 선택한 번호만 DB에 저장
			pstmt.setString(5, vo.getTitle());
			result = pstmt.executeUpdate();

			new Popup_sugo();
			
		} catch (SQLException e) {
			System.out.println("실패하였습니다.");
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
//
//	@Override
//	public int update(QuestionVO vo) {
//		 TODO Auto-generated method stub
//		return 0;
//	}

	public int delete(int num) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			String sql = SQL_DELETE;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("실패하였습니다.");
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
		new testMain().main(new String[1]);
		return 0;
	}

	public List<QuestionVO> selectAll() {

		List<QuestionVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = SQL_SELECT_ALL;

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				QuestionVO vo = new QuestionVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setGender(rs.getString("gender"));
				vo.setTitle(rs.getString("title"));
				for(int i = 0 ; i < rs.getString("qnas").split("-").length ; i++) {
				vo.answers.add(rs.getString("qnas").split("-")[i]);
				}
				vos.add(vo);

			}
			new LastSelectAllGUI(vos);
		} catch (SQLException e) {
			System.out.println("실패");
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
		return vos;
	}
}
