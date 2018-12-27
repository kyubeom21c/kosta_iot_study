package test.com;

public class Test04NoteBookMain {
	
	//1.field
	//2.constructor
	//3.mothod
	
	public static void main(String[] args) {
		
		
//		Test04NoteBookVO vo = new Test04NoteBookVO();
		Test04NoteBookVO vo = new Test04NoteBookVO(
				"n001","notebook","hp009",1440000);
//		vo.productNO = "aaaa";
//		System.out.println(vo.productNO);
		System.out.println(vo);
		vo.setProductNO("n002");
		vo.setProductName("noteBBBBB");
		vo.setModelName("sm333");
		vo.setPrice(500000);
		//String productNO = vo.getProductNO();
		System.out.println(vo.getProductNO());
		System.out.println(vo.getProductName());
		System.out.println(vo.getModelName());
		System.out.println(vo.getPrice());
		
		
	}
}
