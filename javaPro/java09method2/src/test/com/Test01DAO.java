package test.com;

public class Test01DAO {

	public int insert(Test01VO vo) {
		System.out.println("insert()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getEmail());
		return 1;
	}

	public int update(Test01VO vo) {
		System.out.println("update()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getEmail());
		return 0;
	}

	public int delete(Test01VO vo) {
		System.out.println("delete()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getEmail());
		return 0;
	}
	
	public Test01VO[] selectAll() {
		System.out.println("selectAll()...");
		
		Test01VO[] vos = new Test01VO[3];
		
		for (int i = 0; i < vos.length; i++) {
			Test01VO vo = new Test01VO();
			vo.setNum(i);
			vo.setName("name"+i);
			vo.setEmail("email@sss.sss"+i);
			vos[i] = vo;
		}
		return vos;
	}
	
	public Test01VO selectOne(Test01VO vo) {
		System.out.println("selectOne()....");
		
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getEmail());
		
		Test01VO vo2 = new Test01VO();
		vo2.setNum(9);
		vo2.setName("name"+9);
		vo2.setEmail("email@sss.sss"+9);
		
		return vo2;
	}
	

}
