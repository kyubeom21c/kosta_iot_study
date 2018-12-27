package test.com.model;

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
	public ScoreVO[] selectAll() {
		System.out.println("selectAll()....");
		
		ScoreVO[] vos = new ScoreVO[3];
		
		for (int i = 0; i < vos.length; i++) {
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
			vos[i] = vo2;
		}
		
		
		return vos;
	}

}
