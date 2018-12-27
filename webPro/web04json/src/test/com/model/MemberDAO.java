package test.com.model;

import java.util.List;

public interface MemberDAO {

	public List<MemberVO> selectAll();

	public MemberVO selectOne(MemberVO vo);

	public int insert(MemberVO vo);

}
