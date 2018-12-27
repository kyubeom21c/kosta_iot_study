package test.com.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(MemberVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}

	@Override
	public List<MemberVO> search(String searchKey, String searchWord) {
		return dao.search(searchKey,searchWord);
	}

}
