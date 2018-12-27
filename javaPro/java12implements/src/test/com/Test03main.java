package test.com;

import test.com.ex.Test03friend;

public class Test03main {

	public static void main(String[] args) {
		System.out.println("hello");
		
		Test03Me me = new Test03Me();
		me.speed();
		me.study();
		me.slow();
		me.drink();
		System.out.println(me.car);
		System.out.println(me.num);
		
		Test03father father = new Test03father();
		father.getMoney();
		father.slow();
		System.out.println(father.car);
		System.out.println(father.num);
		
		Test03uncle uncle = new Test03uncle() {
			@Override
			public void speed() {
				System.out.println("***speed()....");
			}
		};
		uncle.speed();
		
		Test03uncle uncle2 = new Test03Me();
		uncle2.speed();
		
		Test03friend friend = new Test03friend() {
			@Override
			public void drink() {
				System.out.println("***drink()...");
			}
		};
		friend.drink();
		
		//상속이 전제로될시 자식클래스의 생성자로 객체생성
		Test03friend friend2 = new Test03Me();
		friend2.drink();
		
		Test03father father2 = new Test03Me();
		father2.getMoney();
		father2.slow();
		
		Test03father father3 = new Test03father() {
			@Override
			public void slow() {
				System.out.println("***slow()...");
			}
			@Override
			public int getMoney() {
				System.out.println("***getMoney()...");
				return 900;
			}
		};
		father3.slow();
		father3.getMoney();
		
		Test03gf gf = new Test03gf();
		gf.slow();
		
		Test03gf gf2 = new Test03father();
		gf2.slow();
		
		Test03gf gf3 = new Test03Me();
		gf3.slow();
		
		Test03gf gf4 = new Test03gf() {
			@Override
			public void slow() {
				System.out.println("****slow()...");
			}
		};
		gf4.slow();
		
	}

}
