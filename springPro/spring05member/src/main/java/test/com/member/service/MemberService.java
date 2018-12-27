package test.com.member.service;

import java.util.List;

import test.com.member.model.MemberVO;

public interface MemberService {

	public int insert(MemberVO vo);

	public int update(MemberVO vo);

	public int delete(MemberVO vo);

	public List<MemberVO> selectAll();

	public MemberVO selectOne(MemberVO vo);

	public List<MemberVO> search(String searchKey, String searchWord);

}
