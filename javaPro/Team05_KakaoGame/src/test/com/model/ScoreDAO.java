package test.com.model;

import java.util.List;

public interface ScoreDAO{
		
	public int insert(ScoreVO vo);
	
	public List<ScoreVO> selectAll();

}
