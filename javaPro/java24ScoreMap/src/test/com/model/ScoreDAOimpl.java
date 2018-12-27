package test.com.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ScoreDAOimpl implements ScoreDAO {

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
		return 1;
	}

	@Override
	public int update(ScoreVO vo) {
		System.out.println("update()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		return 1;
	}

	@Override
	public int delete(ScoreVO vo) {
		System.out.println("delete()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		return 1;
	}

	@Override
	public ScoreVO selectOne(ScoreVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		
		ScoreVO vo2 = new ScoreVO();
		vo2.setNum(9);
		vo2.setName("kim");
		vo2.setKor(99);
		vo2.setEng(99);
		vo2.setMath(99);
		vo2.setTotal(vo2.getKor()+vo2.getEng()+vo2.getMath());
		vo2.setAvg(vo2.getTotal()/3.0);
		String grade = "";
		if(vo2.getAvg() >= 90) {
			grade = "A";
		}else if(vo2.getAvg() >= 80) {
			grade = "B";
		}else if(vo2.getAvg() >= 70) {
			grade = "C";
		}else {
			grade = "F";
		}
		vo2.setGrade(grade);
		return vo2;
	}

	@Override
	public List<ScoreVO> selectAll() {
		System.out.println("selectAll()....");
		List<ScoreVO> vos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ScoreVO vo2 = new ScoreVO();
			vo2.setNum(3);
			vo2.setName("kim33");
			vo2.setKor(33);
			vo2.setEng(33);
			vo2.setMath(33);
			vo2.setTotal(vo2.getKor()+vo2.getEng()+vo2.getMath());
			vo2.setAvg(vo2.getTotal()/3.0);
			String grade = "";
			if(vo2.getAvg() >= 90) {
				grade = "A";
			}else if(vo2.getAvg() >= 80) {
				grade = "B";
			}else if(vo2.getAvg() >= 70) {
				grade = "C";
			}else {
				grade = "F";
			}
			vo2.setGrade(grade);
			
			vos.add(vo2);
		}
		
		
		return vos;
	}

	@Override
	public Map<String, ScoreVO> selectMap() {
		System.out.println("selectMap()....");
		
		Map<String, ScoreVO> m = new Hashtable<>();
		
		ScoreVO vo1 = new ScoreVO();
		vo1.setNum(9);
		vo1.setName("kim");
		vo1.setKor(99);
		vo1.setEng(99);
		vo1.setMath(99);
		vo1.setTotal(vo1.getKor()+vo1.getEng()+vo1.getMath());
		vo1.setAvg(vo1.getTotal()/3.0);
		String grade = "";
		if(vo1.getAvg() >= 90) {
			grade = "A";
		}else if(vo1.getAvg() >= 80) {
			grade = "B";
		}else if(vo1.getAvg() >= 70) {
			grade = "C";
		}else {
			grade = "F";
		}
		vo1.setGrade(grade);
		
		
		ScoreVO vo2 = new ScoreVO();
		vo2.setNum(9);
		vo2.setName("kim");
		vo2.setKor(99);
		vo2.setEng(99);
		vo2.setMath(99);
		vo2.setTotal(vo2.getKor()+vo2.getEng()+vo2.getMath());
		vo2.setAvg(vo2.getTotal()/3.0);
		String grade2 = "";
		if(vo2.getAvg() >= 90) {
			grade2 = "A";
		}else if(vo2.getAvg() >= 80) {
			grade2 = "B";
		}else if(vo2.getAvg() >= 70) {
			grade2 = "C";
		}else {
			grade2 = "F";
		}
		vo2.setGrade(grade2);
		
		m.put("vo1", vo1);
		m.put("vo2", vo2);
		return m;
	}

	@Override
	public Map<String, List<ScoreVO>> selectMapList() {
		System.out.println("selectMapList()....");
		
		Map<String, List<ScoreVO>> m = new Hashtable<>();
		
		List<ScoreVO> vos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ScoreVO vo2 = new ScoreVO();
			vo2.setNum(3);
			vo2.setName("kim33");
			vo2.setKor(33);
			vo2.setEng(33);
			vo2.setMath(33);
			vo2.setTotal(vo2.getKor()+vo2.getEng()+vo2.getMath());
			vo2.setAvg(vo2.getTotal()/3.0);
			String grade = "";
			if(vo2.getAvg() >= 90) {
				grade = "A";
			}else if(vo2.getAvg() >= 80) {
				grade = "B";
			}else if(vo2.getAvg() >= 70) {
				grade = "C";
			}else {
				grade = "F";
			}
			vo2.setGrade(grade);
			
			vos.add(vo2);
		}
		
		List<ScoreVO> vos2 = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ScoreVO vo2 = new ScoreVO();
			vo2.setNum(32);
			vo2.setName("kim32");
			vo2.setKor(32);
			vo2.setEng(32);
			vo2.setMath(32);
			vo2.setTotal(vo2.getKor()+vo2.getEng()+vo2.getMath());
			vo2.setAvg(vo2.getTotal()/3.0);
			String grade = "";
			if(vo2.getAvg() >= 90) {
				grade = "A";
			}else if(vo2.getAvg() >= 80) {
				grade = "B";
			}else if(vo2.getAvg() >= 70) {
				grade = "C";
			}else {
				grade = "F";
			}
			vo2.setGrade(grade);
			
			vos2.add(vo2);
		}
		
		m.put("vos", vos);
		m.put("vos2", vos2);
		
		return m;
	}

}
