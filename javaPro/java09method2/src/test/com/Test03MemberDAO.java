package test.com;

public class Test03MemberDAO {

	public int insert(Test03MemberVO vo) {
		System.out.println("insert()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return 0;
	}

	public int update(Test03MemberVO vo) {
		System.out.println("update()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return 0;
	}

	public int delete(Test03MemberVO vo) {
		System.out.println("delete()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return 0;
	}
	
	public Test03MemberVO[] selectAll() {
		System.out.println("selectAll()...");
		return null;
	}
	
	public Test03MemberVO selectOne(Test03MemberVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return null;
	}
	
	
	
}
