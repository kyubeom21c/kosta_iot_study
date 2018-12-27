package test.com.model;

import java.util.List;

public interface GameDirDAO {
   
   public int insert(GameVO vo);

   public int update(GameVO vo);

   public int delete(GameVO vo);

   public GameVO selectOne(GameVO vo);
   
   public int updatePopularity(GameVO vo);
   
   public int showPopularity(GameVO vo);

   public List<GameVO> selectAll();

   
   
   
}