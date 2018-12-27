package test.com.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardDAO dao;
	
	public BoardServiceImpl() {
		logger.info("BoardServiceImpl().....");
	}

	@Override
	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(BoardVO vo) {
		return dao.delete(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<BoardVO> search(String searchKey, String searchWord) {
		return dao.search(searchKey, searchWord);
	}

}
