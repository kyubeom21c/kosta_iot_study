package test.com.member;

public class Test01MemberVO {
	//VO:Value Object, DTO:Data Transfer Object
	public int num;
	public String id;
	public String pw;
	public String name;
	public String tel;
	
	public Test01MemberVO() {
		num = 1;
		id = "admin";
		pw = "hi123456";
		name = "kim";
		tel = "010";
	}
	public Test01MemberVO(
			int num,String id,String pw,String name,String tel) {
		this.num = num;
		this.id = id;
		this.pw = tel;
		this.name = name;
		this.tel = tel;
	}
}
