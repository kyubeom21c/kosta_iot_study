package test.com.component;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOimpl implements TestDAO {
	private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);

	public TestDAOimpl() {
		logger.info("TestDAOimpl().......");
	}

	@Override
	public int insert(TestVO vo) {
		logger.info("insert().......");
		logger.info(vo.getNum() + "");
		logger.info(vo.getName());
		logger.info(vo.getAge() + "");
		return 0;
	}

	@Override
	public int update(TestVO vo) {
		logger.info("update().......");
		logger.info(vo.getNum() + "");
		logger.info(vo.getName());
		logger.info(vo.getAge() + "");
		return 0;
	}

	@Override
	public int delete(TestVO vo) {
		logger.info("delete().......");
		logger.info(vo.getNum() + "");
		return 0;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		logger.info("selectOne().......");
		logger.info(vo.getNum() + "");
		TestVO vo2 = new TestVO();
		vo2.setNum(99);
		vo2.setName("lee");
		vo2.setAge(11);
		return vo2;
	}

	@Override
	public List<TestVO> selectAll() {
		logger.info("selectAll().......");
		List<TestVO> vos = new ArrayList<TestVO>();
		for (int i = 0; i < 5; i++) {
			TestVO vo = new TestVO();
			vo.setNum(i);
			vo.setName("lee"+i);
			vo.setAge(11*i);
			vos.add(vo);
		}
		return vos;
	}

}
