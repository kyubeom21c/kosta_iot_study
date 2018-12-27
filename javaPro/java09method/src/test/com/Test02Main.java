package test.com;

public class Test02Main {

	public static void main(String[] args) {
		System.out.println("dao...");

		Test02DAO dao = new Test02DAO();
		System.out.println(dao);

		// 홍길동이라는 문자열을 name변수에 할당하고
		String name = "홍길동2";
		// dao객체의 insert메소드에 인자로 전달 후
//		dao.insert(name);
		// 반환값을 출력하시오.
		int result = dao.insert(name);
		System.out.println(result);

		if (result == 1) {
			System.out.println("입력성공");
		} else {
			System.out.println("입력실패");
		}
		////////////////////////////////

		boolean result2 = dao.update(new String[] { "aaa", "bbb", "ccc" });
		System.out.println(result2);

		////////////////////////////////
		
		int result3 = dao.delete(99);
		System.out.println(result3);
		
		////////////////////////////////
		
		String[] datas = dao.selectAll();
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		
		////////////////////////////////
		String name2 = dao.selectOne(77);
		System.out.println(name2);
		

	}// end main()

}
