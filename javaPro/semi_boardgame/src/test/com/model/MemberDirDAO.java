package test.com.model;

import java.util.List;

public interface MemberDirDAO {

	public MemberVO selectOne(MemberVO vo);
	public List<MemberVO> selectAll();
	public int deleteMember (MemberVO vo);
	
}
