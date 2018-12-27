package test.com.component;

import java.util.List;

public interface TestService {
	
	
	public int insert(TestVO vo);

	public int update(TestVO vo);

	public int delete(TestVO vo);

	public TestVO selectOne(TestVO vo);

	public List<TestVO> selectAll();

}
