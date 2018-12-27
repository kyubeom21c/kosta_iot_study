package test.com.board.model;

import java.util.List;

public interface TestBoardDAO {

	public int insert(TestBoardVO vo);
	public int update(TestBoardVO vo);
	public int delete(TestBoardVO vo);
	
	public TestBoardVO search(TestBoardVO vo);
	
	public List<TestBoardVO> select();

	
}
