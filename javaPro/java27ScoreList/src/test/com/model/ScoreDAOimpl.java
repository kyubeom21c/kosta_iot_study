package test.com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAOimpl implements ScoreDAO {
	
	//¿˙¿Âº“
	List<ScoreVO> vos = new ArrayList<>();
	
	
	@Override
	public int insert(ScoreVO vo) {
		System.out.println("insert()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		vos.add(vo);
		
		return 1;
	}

	@Override
	public int update(ScoreVO vo) {
		System.out.println("update()....");
		System.out.println(vo.getNum());
		vo.setName(vo.getName()+"ss");
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).getNum()==vo.getNum()) {
				vos.set(i,vo);
			}
		}
		
		return 1;
	}

	@Override
	public int delete(ScoreVO vo) {
		System.out.println("delete()....");
		System.out.println(vo.getNum());
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).getNum()==vo.getNum()) {
				vos.remove(i);
			}
		}
		return 1;
	}

	@Override
	public ScoreVO selectOne(ScoreVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getNum());
		ScoreVO vo2 = null;
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).getNum()==vo.getNum()) {
				vo2 = vos.get(i);
			}
		}

		return vo2;
	}

	@Override
	public List<ScoreVO> selectAll() {
		System.out.println("selectAll()....");
		return vos;
	}

}
