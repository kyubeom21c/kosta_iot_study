package test.com;

public class Test02Main {

	public static void main(String[] args) {
		System.out.println("dao...");

		Test02DAO dao = new Test02DAO();
		System.out.println(dao);

		// ȫ�浿�̶�� ���ڿ��� name������ �Ҵ��ϰ�
		String name = "ȫ�浿2";
		// dao��ü�� insert�޼ҵ忡 ���ڷ� ���� ��
//		dao.insert(name);
		// ��ȯ���� ����Ͻÿ�.
		int result = dao.insert(name);
		System.out.println(result);

		if (result == 1) {
			System.out.println("�Է¼���");
		} else {
			System.out.println("�Է½���");
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
