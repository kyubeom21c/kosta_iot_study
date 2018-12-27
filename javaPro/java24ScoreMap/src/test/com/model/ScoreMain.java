package test.com.model;

import java.util.List;
import java.util.Map;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("main...");
		//MVC model Design 
		//VO,DAO,DAOimpl >>> Model
		//main() >>> View
		//control >>> Controller
		
		//숙제>>java15Score프로젝트처럼
		//java16Member, java17Board
		
		ScoreDAO dao = new ScoreDAOimpl();
		ScoreVO vo2 = new ScoreVO();
		vo2.setNum(22);
		vo2.setName("kim22");
		vo2.setKor(22);
		vo2.setEng(22);
		vo2.setMath(22);
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
		System.out.println(dao.insert(vo2));
		System.out.println(dao.update(vo2));
		System.out.println(dao.delete(vo2));
		
		ScoreVO vo = dao.selectOne(vo2);
		System.out.println(vo);
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		
		List<ScoreVO> vos = dao.selectAll();
		System.out.println(vos);
		System.out.println("vos.size():"+vos.size());
		
		for (int i = 0; i < vos.size(); i++) {
			System.out.print(vos.get(i).getNum()+" ");
			System.out.print(vos.get(i).getName()+" ");
			System.out.print(vos.get(i).getKor()+" ");
			System.out.print(vos.get(i).getEng()+" ");
			System.out.print(vos.get(i).getMath()+" ");
			System.out.print(vos.get(i).getTotal()+" ");
			System.out.print(vos.get(i).getAvg()+" ");
			System.out.println(vos.get(i).getGrade());
		}
		System.out.println();
		
		
		Map<String, ScoreVO> m = dao.selectMap();
		System.out.println(m);
		System.out.println(m.size());
		for (String key : m.keySet()) {
			System.out.print(m.get(key).getNum()+" ");
			System.out.print(m.get(key).getName()+" ");
			System.out.print(m.get(key).getKor()+" ");
			System.out.print(m.get(key).getEng()+" ");
			System.out.print(m.get(key).getMath()+" ");
			System.out.print(m.get(key).getTotal()+" ");
			System.out.print(m.get(key).getAvg()+" ");
			System.out.println(m.get(key).getGrade());
		}
		System.out.println();
		
		Map<String, List<ScoreVO>> mList = dao.selectMapList();
		System.out.println(mList);
		for (String key : mList.keySet()) {
			List<ScoreVO> vos2 = mList.get(key);
			for (ScoreVO x : vos2) {
				System.out.print(x.getNum()+" ");
				System.out.print(x.getName()+" ");
				System.out.print(x.getKor()+" ");
				System.out.print(x.getEng()+" ");
				System.out.print(x.getMath()+" ");
				System.out.print(x.getTotal()+" ");
				System.out.print(x.getAvg()+" ");
				System.out.println(x.getGrade());
			}
			System.out.println();
		}
		
		//숙제
		//1~45 사이의 서로다른 정수 6개를 뽑아서
		//출력하시오.
		//옵션1. 작은수부터 큰수로 출력
		//옵션2. 오늘배운 Set을 활용할것
		
	}

}
