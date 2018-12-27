package test.com;

public class Test01Main {

	public static void main(String[] args) {
		System.out.println("main....");

		
		Test01DAO dao = new Test01DAO();
		
		System.out.println("======insert=======");
		Test01VO vo = new Test01VO();
		vo.setNum(11);
		vo.setName("name11");
		vo.setEmail("email11");
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		System.out.println("======update=======");
		Test01VO vo2 = new Test01VO();
		vo2.setNum(22);
		vo2.setName("name22");
		vo2.setEmail("email22");
		
		int result2 = dao.update(vo2);
		System.out.println(result2);
		
		System.out.println("======delete=======");
		Test01VO vo3 = new Test01VO();
		vo3.setNum(33);
		vo3.setName("name33");
		vo3.setEmail("email33");
		
		int result3 = dao.delete(vo3);
		System.out.println(result3);
		
		System.out.println("======selectAll=======");
		Test01VO[] vos = dao.selectAll();
		System.out.println("vos.length:"+vos.length);
		
		for (int i = 0; i < vos.length; i++) {
			System.out.print(vos[i].getNum()+" ");
			System.out.print(vos[i].getName()+" ");
			System.out.println(vos[i].getEmail());
		}
		
		System.out.println("======selectOne=======");
		Test01VO vo4 = dao.selectOne(vo3);
		System.out.print(vo4.getNum()+" ");
		System.out.print(vo4.getName()+" ");
		System.out.println(vo4.getEmail());
		
	}//end main()

}
