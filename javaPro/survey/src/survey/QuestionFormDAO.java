package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class QuestionFormDAO{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "kosta";
	private final String PASSWORD = "hi123456";
	private final String SQL_INSERT = "insert into form(num,title,questionno,qnas,summary) values(SEQ_FORM_NUM.nextval,?,?,?,?)";
	private final String SQL_DELETE = "delete from form where num = ?";
	private final String SQL_SELECT_ALL = "select * from form order by num asc";
	private final String SQL_SELECT_ONE = "select * from form where num=?";
	
			
	public QuestionFormDAO() {
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

			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.questionNum);
			String[] strs = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"" };

			for (int i = 0; i < vo.questionNum; i++) {
				for (int x = 0; x < 5; x++) {
					if (x < 4)
						strs[i] += vo.qnaL.get(i)[x] + ":";
					else
						strs[i] += vo.qnaL.get(i)[x];
				}
			}

			
			for (int i = 1 ; i < vo.questionNum; i++) {
				strs[0] += "-"+strs[i];
				
			}
			pstmt.setString(3, strs[0]);
			
			pstmt.setString(4, vo.getSummary());
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
		return result;
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
				vo.setTitle((rs.getString("title")));
				vo.questionNum = rs.getInt("questionno");
				vo.setSummary(rs.getString("summary"));

				vos.add(vo);
			}
			new SelectAllFormGUI(vos);
			
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
	
	public void selectOne(int num) {
		try {
			int choice = num;
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = SQL_SELECT_ONE;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, choice);
			
			rs = pstmt.executeQuery();
			rs.next();
			QuestionVO vo = new QuestionVO();
			
			vo.setNum(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.questionNum = rs.getInt(3);
			
			
			for(int i = 0 ; i < vo.questionNum ; i++) {
				
				String[] strs = new String[5];  // 5칸짜리 스플릿된 문자열을 받을 배열선언 질문,보기1,보기2,...보기4
				strs = rs.getString(4).split("-")[i].split(":"); // -로 나눈 문자열을 다시 :로 나눠서 배열에 저장
				vo.qnaL.add(new String[6]);	// i만큼 6칸 짜리 배열을 qnal 리스트에 저장
				vo.qnaL.get(i)[0] = strs[0];	// i 번째 배열의 0,1,2,3,4 에 질문,보기1,보기2,..보기4 저장 
				vo.qnaL.get(i)[1] = strs[1];
				vo.qnaL.get(i)[2] = strs[2];
				vo.qnaL.get(i)[3] = strs[3];
				vo.qnaL.get(i)[4] = strs[4];
				
			}
			vo.setSummary(rs.getString("SUMMARY"));
			new Infomation(vo);

			
			return;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return;
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			
			return;
		} 
	
		
		
		
	}
	public int delete(int num) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
		selectAll();
		return 0;
	}
	
	
	
}
