package hankki.menucho.model;

import java.util.Date;

public class MenuChoiceVO {

	private int num;
	private String kind;
	private String name;
	private int cookTm;
	private int price;

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

}
