package test.com.model;

import java.util.List;

public interface MemberUserDAO {

	public int insertMember (MemberVO vo);
	public MemberVO findId (MemberVO vo);
	public MemberVO findPw (MemberVO vo);
	
	public MemberVO loginCheck_1(MemberVO vo);
	public MemberVO loginCheck_2(MemberVO vo);
	public MemberVO idCheck(MemberVO vo);
	public MemberVO pwCheck(MemberVO vo);
	


}
