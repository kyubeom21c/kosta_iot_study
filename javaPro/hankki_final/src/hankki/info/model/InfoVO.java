package hankki.info.model;

public class InfoVO {

	int num;
	String orderNum;
	String address;
	String tel;
	String stat;

	public InfoVO() {

	}

	public InfoVO(int num, String orderNum, String address, String tel, String stat) {
		this.num = num;
		this.orderNum = orderNum;
		this.address = address;
		this.tel = tel;
		this.stat = stat;

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

}
