package test.com.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Autowired
	TestDAO dao;
	
	public TestServiceImpl() {
		logger.info("TestServiceImpl().......");
	}
	
	@Override
	public int insert(TestVO vo) {
		logger.info("insert().......");
		return dao.insert(vo);
	}

	@Override
	public int update(TestVO vo) {
		logger.info("update().......");
		return dao.update(vo);
	}

	@Override
	public int delete(TestVO vo) {
		logger.info("delete().......");
		return dao.delete(vo);
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		logger.info("selectOne().......");
		return dao.selectOne(vo);
	}

	@Override
	public List<TestVO> selectAll() {
		logger.info("selectAll().......");
		return dao.selectAll();
	}

}
