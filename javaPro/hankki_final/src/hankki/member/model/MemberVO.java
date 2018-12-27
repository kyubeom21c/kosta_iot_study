package hankki.member.model;

public class MemberVO {
	
	private int num;
	private String name;
	private String tel;
	private String email;
	private String card;
	private String address;
	public MemberVO() {
		
	}
	
	public MemberVO(int num, String name, String tel, String email, String card, String address) {
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.card = card;
		this.address = address;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	


}
