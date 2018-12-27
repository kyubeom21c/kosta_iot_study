package test.com;

import java.util.ArrayList;
import java.util.List;

public class Test02FileReaderDAOimpl implements Test02FileReaderDAO {

	List<Test02FileReaderVO> vos = new ArrayList<>();
	
	@Override
	public int insert(Test02FileReaderVO vo) {
		System.out.println("insert()...");
		vos.add(vo);
		return 0;
	}

	@Override
	public List<Test02FileReaderVO> selectAll() {
		System.out.println("selectAll()...");
		return vos;
	}

}
