package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDirDAOimpl implements GameDirDAO {

   private Connection conn;// 커넥션
   private PreparedStatement pstmt;// 조작하는 용
   private PreparedStatement pstmt1;// 조작하는 용
   private ResultSet rs;

   private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
   private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
   private final String USER = "boardgame";
   private final String PASSWORD = "hi123456";

   private final String SQL_INSERT = "insert into game(num,name, gameLevel,peopleCount,popularity) values (seq_game_num.nextval,?, ?,?,0)";
   private final String SQL_UPDATE = "update game set name =?,gameLevel=?,peopleCount=? where num=?";
   private final String SQL_DELETE = "delete from game where num=?";
   private final String SQL_SELECT_ALL = "select * from game order by num asc";
   private final String SQL_SELECT_ONE = "select * from game where num=?";
   private final String SQL_UPDATE_POP = "update game set popularity=popularity+1 where num=?";
   private final String SQL_SHOW_POP = "select popularity ,name from game where popularity = (select max(popularity) from game)";
   
   
   

   public GameDirDAOimpl(){

      try {
         Class.forName(DRIVER_NAME);
         System.out.println("driver seccessed");
      } catch (ClassNotFoundException e) {
         System.out.println("driver failed");
         e.printStackTrace();
      }

   }

   @Override
   public int insert(GameVO vo) {
      System.out.println("insert()...");
      System.out.print(vo.getName() + "  ");
      System.out.print(vo.getGameLevel() + "  ");
      System.out.println(vo.getPeopleCount() + "  ");
      int result = 0;
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         String sql = SQL_INSERT;// insert 정적 쿼리처리
         pstmt = conn.prepareStatement(sql);// setting

         pstmt.setString(1, vo.getName());
         pstmt.setInt(2, vo.getGameLevel());
         pstmt.setInt(3, vo.getPeopleCount());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // fin
      return result;
   }

   @Override
   public int update(GameVO vo) {
      System.out.println("update()...");
      System.out.print(vo.getName() + "  ");
      System.out.print(vo.getGameLevel() + "  ");
      System.out.println(vo.getPeopleCount() + "  ");
      int result = 0;
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         String sql = SQL_UPDATE;
         pstmt = conn.prepareStatement(sql);// setting

         pstmt.setString(1, vo.getName());
         pstmt.setInt(2, vo.getGameLevel());
         pstmt.setInt(3, vo.getPeopleCount());
         pstmt.setInt(4, vo.getNum());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // fin
      return result;
   }

   @Override
   public int delete(GameVO vo) {
      System.out.println(vo.getNum());
      int result = 0;
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         String sql = SQL_DELETE;// delete
         pstmt = conn.prepareStatement(sql);// setting

         pstmt.setInt(1, vo.getNum());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // end fin

      return result;
   }

   @Override
   public GameVO selectOne(GameVO vo) {
      System.out.println("selectOne...");

      GameVO vo2 = new GameVO();
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         pstmt = conn.prepareStatement(SQL_SELECT_ONE);// setting
         pstmt.setInt(1, vo.getNum());

         rs = pstmt.executeQuery();// select(결과값이 표처럼 담김) DQL
         while (rs.next()) {// select
            vo2.setNum(rs.getInt("num"));
            vo2.setName(rs.getString("name"));
            vo2.setGameLevel(rs.getInt("gameLevel"));
            vo2.setPeopleCount(rs.getInt("peopleCount"));
            vo2.setPopularity(rs.getInt("popularity"));
         }
         
      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // end fin

      return vo2;
   }

   @Override
   public List<GameVO> selectAll() {
      System.out.println("selectAll()...");

      List<GameVO> vos = new ArrayList<>();
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         pstmt = conn.prepareStatement(SQL_SELECT_ALL);

         rs = pstmt.executeQuery();
         while (rs.next()) {
            GameVO vo = new GameVO();
            vo.setNum(rs.getInt("num"));
            vo.setName(rs.getString("name"));
            vo.setGameLevel(rs.getInt("gameLevel"));
            vo.setPeopleCount(rs.getInt("peopleCount"));
            vo.setPopularity(rs.getInt("popularity"));
            vos.add(vo);
         }

      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // end fin

      return vos;
      
   }

   
   
   @Override
   public int updatePopularity(GameVO vo) {
      System.out.println("selectOne...");

      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         pstmt = conn.prepareStatement(SQL_UPDATE_POP);// setting
         pstmt.setInt(1, vo.getNum());

         pstmt.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // end fin

      return 0;
   }
   
   
   public int showPopularity(GameVO vo) {
      System.out.println("showPopularity...");

      GameVO vo2 = new GameVO();
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);

         pstmt = conn.prepareStatement(SQL_SHOW_POP);// setting

         rs = pstmt.executeQuery();// select(결과값이 표처럼 담김) DQL
         while (rs.next()) {// select
            vo.setName(rs.getString("name"));
            vo.setPopularity(rs.getInt("popularity"));
         }
         
      } catch (SQLException e) {
         System.out.println("pstmt failed");
         e.printStackTrace();
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (pstmt != null) {
            try {
               pstmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } // end fin

      return 0;
   }
   
}