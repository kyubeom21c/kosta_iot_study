package test.com.model;

import java.util.List;

public class NoteBookMain {
	
	public static void main(String[] args) {
		System.out.println("notebook...");
		
		NoteBookDAO dao = new NoteBookDAOimpl();
		
		String menu = "4";
		if(menu.equals("1")) {
			NoteBookVO vo = new NoteBookVO();
			vo.setProductNO("n002");
			vo.setProductName("noteBBBBB");
			vo.setModelName("sm333");
			vo.setPrice(500000);
			int result = dao.insert(vo);
			System.out.println("insert result:"+result);
		}else if(menu.equals("2")) {
			NoteBookVO vo = new NoteBookVO();
			vo.setNum(7);
			vo.setProductNO("n001");
			vo.setProductName("noteBBBBB1");
			vo.setModelName("sm111");
			vo.setPrice(100000);
			int result = dao.update(vo);
			System.out.println("update result:"+result);
		}else if(menu.equals("3")) {
			NoteBookVO vo = new NoteBookVO();
			vo.setNum(7);
			int result = dao.delete(vo);
			System.out.println("delete result:"+result);
		}else if(menu.equals("4")) {
			NoteBookVO vo = new NoteBookVO();
			System.out.println(vo);
			vo.setNum(2);
			
			NoteBookVO vo2 = dao.selectOne(vo);
			System.out.println(vo2.getNum());
			System.out.println(vo2.getProductNO());
			System.out.println(vo2.getProductName());
			System.out.println(vo2.getModelName());
			System.out.println(vo2.getPrice());
		}else if(menu.equals("5")) {
			List<NoteBookVO> vos = dao.selectAll();
			System.out.println("vos size:"+vos.size());
			for (NoteBookVO vo : vos) {
				System.out.print(vo.getNum()+" ");
				System.out.print(vo.getProductNO()+" ");
				System.out.print(vo.getProductName()+" ");
				System.out.print(vo.getModelName()+" ");
				System.out.println(vo.getPrice());
			}
		}
		
		
	}
}
