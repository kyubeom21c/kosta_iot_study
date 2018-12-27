package test.com;

import java.util.List;

public class Test01Main {

	public static void main(String[] args) {
		System.out.println("jdbc");
		
		Test01DAO dao = new Test01DAOimpl();
		int menu = 5;
		if(menu==1) {
			//1.insert
			Test01VO vo = new Test01VO();
			vo.setName("yang");
			vo.setAge(30);
			int result = dao.insert(vo);
			System.out.println("insert result:"+result);
		}else if(menu==2) {
			//2.update
			Test01VO vo = new Test01VO();
			vo.setNum(13);
			vo.setName("yang4");
			vo.setAge(44);
			int result = dao.update(vo);
			System.out.println("update result:"+result);
		}else if(menu==3) {
			//3.delete
			Test01VO vo = new Test01VO();
			vo.setNum(12);
			int result = dao.delete(vo);
			System.out.println("delete result:"+result);
		}else if(menu==4) {
			//4.selectAll
			List<Test01VO> vos = dao.selectAll();
			System.out.println("selectAll vos.size():"+vos.size());
			for (Test01VO vo : vos) {
				System.out.print(vo.getNum()+" ");
				System.out.print(vo.getName()+" ");
				System.out.println(vo.getAge());
			}
		}else if(menu==5) {
			//5.selectOne
			Test01VO vo = new Test01VO();
			vo.setNum(11);
			Test01VO vo2 = dao.selectOne(vo);
			System.out.println("selectOne vo2:"+vo2);
			System.out.print(vo2.getNum()+" ");
			System.out.print(vo2.getName()+" ");
			System.out.println(vo2.getAge());
		}
		System.out.println();
		//4.selectAll
		List<Test01VO> vos = dao.selectAll();
		System.out.println("selectAll vos.size():"+vos.size());
		for (Test01VO vo : vos) {
			System.out.print(vo.getNum()+" ");
			System.out.print(vo.getName()+" ");
			System.out.println(vo.getAge());
		}
		
	}

}
