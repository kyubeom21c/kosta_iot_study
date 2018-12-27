package test.com.model;

public interface MemberDAO {
	
	public int insert(MemberVO vo);
	
	public MemberVO selectOne(MemberVO vo);

}
