package test.com;

import java.sql.Date;

import org.json.JSONObject;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestVO vo = new TestVO();
		vo.setNum(11);
		vo.setWDate(new Date(System.currentTimeMillis()));
		
		JSONObject obj = new JSONObject(vo);
		System.out.println(obj);
		
		String str = obj.toString();
		JSONObject obj2 = new JSONObject(str);
		System.out.println(obj2.getString("WDate"));
		
		
		//1.member 5회 미션자 : web05member01,...web05member05
		//2.member,board,score : web05member,web05board,web05score
		//3.semi : 본인파트 jsp/servlet 구현,
		
	}

}
