package hankki.order.model;

import java.util.Date;

public class OrderVO {

	private int num;
	private String kind;
	private String name;
	private int cookTm;
	private int price;
	private String ordernum;
	private String tel;
	private String address;
	private String stat;
	
	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public OrderVO() {
		// TODO Auto-generated constructor stub
	}

	public OrderVO(String kind, String name, int cookTm, int price, String ordernum) {
		super();
		this.kind = kind;
		this.name = name;
		this.cookTm = cookTm;
		this.price = price;
		this.ordernum = ordernum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCookTm() {
		return cookTm;
	}

	public void setCookTm(int cookTm) {
		this.cookTm = cookTm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
