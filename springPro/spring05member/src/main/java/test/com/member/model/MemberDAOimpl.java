package test.com.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOimpl implements MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOimpl.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVO vo) {
		logger.info("insert()...");
		logger.info("id : "+vo.getId());
		logger.info("pw : "+vo.getPw());
		logger.info("name : "+vo.getName());
		logger.info("tel : "+vo.getTel());
		
		return sqlSession.insert("insert", vo);
	}

	@Override
	public int update(MemberVO vo) {
		logger.info("update()...");
		logger.info("num : "+vo.getNum());
		logger.info("id : "+vo.getId());
		logger.info("pw : "+vo.getPw());
		logger.info("name : "+vo.getName());
		logger.info("tel : "+vo.getTel());
		
		return sqlSession.update("update", vo);
	}

	@Override
	public int delete(MemberVO vo) {
		logger.info("delete()...");
		logger.info("num : "+vo.getNum());
		
		return sqlSession.delete("delete", vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		logger.info("selectAll()...");
		return sqlSession.selectList("selectAll");
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		logger.info("selectOne()...");
		return sqlSession.selectOne("selectOne",vo);
	}

	@Override
	public List<MemberVO> search(String searchKey, String searchWord) {
		logger.info("search()...");
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey);
		map.put("searchWord", "%"+searchWord+"%");
		
		return sqlSession.selectList("search",map);
	}

}
