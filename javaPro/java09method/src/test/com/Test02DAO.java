package test.com;

public class Test02DAO {

	//4.인자값 유, 반환값 유
	public int insert(String name) {
		System.out.println(name);
		String result = "실패";//실패
		if(result.equals("성공")) {
			return 1;
		}else {
			return 0;
		}
	}//end insert()
	
	public boolean update(String[] args) {
		System.out.println("update...");
		System.out.println(args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		if(args.length==3)return true;
		else return false;
	}//end update()
	
	
	public int delete(int num) {
		System.out.println("delete..."+num);
		return 1;
	}
	
	public String[] selectAll() {
		System.out.println("selectAll()...");
		
		String[] datas = new String[3];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = "aaa"+i;
		}
		return datas;
	}
	
	public String selectOne(int num) {
		System.out.println("selectOne()...."+num);
		
		String name = "kim";
		
		return name;
	}
	
	
	
}
