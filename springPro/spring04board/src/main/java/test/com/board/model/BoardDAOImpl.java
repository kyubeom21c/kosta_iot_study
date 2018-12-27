package test.com.board.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Autowired
	SqlSession sqlSession;
	
	
	public BoardDAOImpl() {
		logger.info("BoardDAOImpl().....");
	}

	@Override
	public int insert(BoardVO vo) {
		logger.info("insert()...");
		logger.info("title : "+vo.getTitle());
		logger.info("content : "+vo.getContent());
		logger.info("writer : "+vo.getWriter());
		
		int result = sqlSession.insert("insert", vo);
		logger.info("insert result..."+result);
		
		return result;
	}

	@Override
	public int update(BoardVO vo) {
		logger.info("update()...");
		logger.info("num : "+vo.getNum());
		logger.info("title : "+vo.getTitle());
		logger.info("content : "+vo.getContent());
		logger.info("writer : "+vo.getWriter());
		
		int result = sqlSession.update("update", vo);
		logger.info("update result..."+result);
		
		return result;
	}

	@Override
	public int delete(BoardVO vo) {
		logger.info("delete()...");
		logger.info("num : "+vo.getNum());
		
		int result = sqlSession.delete("delete", vo);
		logger.info("delete result..."+result);
		
		return result;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		logger.info("selectOne()...");
		logger.info("num : "+vo.getNum());
		
		BoardVO vo2 = sqlSession.selectOne("selectOne", vo);
		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		logger.info("selectAll()...");
		
		List<BoardVO> vos = sqlSession.selectList("selectAll");
		
		return vos;
	}

	@Override
	public List<BoardVO> search(String searchKey, String searchWord) {
		logger.info("search()...");
		logger.info("searchKey : "+searchKey);
		logger.info("searchWord : "+searchWord);
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey);
		map.put("searchWord", "%"+searchWord+"%");
		
		List<BoardVO> vos = sqlSession.selectList("search",map);
		return vos;
	}

}
