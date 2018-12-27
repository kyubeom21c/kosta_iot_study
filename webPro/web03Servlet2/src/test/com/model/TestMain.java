package test.com.model;

import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		String sPath = "/insertOK.do";
		
		if(sPath.equals("/index.do")) {
			System.out.println("Test....index.jsp");
		}else if(sPath.equals("/insert.do")) {
			System.out.println("Test....insert.jsp");
		}else if(sPath.equals("/insertOK.do")) {
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(1);
			vo.setId("admin");
			int result = dao.insert(vo);
			if(result==1) {
				System.out.println("successed..");
			}else {
				System.out.println("failed..");
			}
		}else if(sPath.equals("/selectAll.do")) {
			System.out.println("Test....selectAll.jsp");
			TestDAO dao = new TestDAOimpl();
			List<TestVO> vos = dao.selectAll();
			for (TestVO vo : vos) {
				System.out.print(vo.getNum()+" ");
				System.out.println(vo.getId());
			}
		}else if(sPath.equals("/update.do")) {
			System.out.println("Test....update.jsp");
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(1);
			
			TestVO vo2 = dao.selectOne(vo);
			System.out.print(vo2.getNum()+" ");
			System.out.println(vo2.getId());
		}else if(sPath.equals("/updateOK.do")) {
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(1);
			vo.setId("admin");
			int result = dao.update(vo);
			if(result==1) {
				System.out.println("successed..");
			}else {
				System.out.println("failed..");
			}
		}else if(sPath.equals("/deleteOK.do")) {
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(1);
			int result = dao.delete(vo);
			if(result==1) {
				System.out.println("successed..");
			}else {
				System.out.println("failed..");
			}
		}
		
	}

}
