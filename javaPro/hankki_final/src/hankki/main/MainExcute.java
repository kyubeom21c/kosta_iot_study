package hankki.main;

import hankki.info.gui.InfoHomeGUI;
import hankki.login.gui.LoginGUI;
import hankki.member.gui.Mypage_Home;

public class MainExcute{

	public static void main(String[] args) {
		System.out.println("TestMain");
		new LoginGUI();
//		new InfoHomeGUI();
//		new test01();
//		new MenuAddGUI();
//		new LoginOKGUI();
//		new MenuChoiceGUI();
//		new MenuListGUI();
//		new Mypage_Home();
//		new MenuAddMainGUI();
//		new MenuAddSelectGUI();
/*		String orderNum=new Date().getTime()+"01027270602";
		List<OrderVO> vos = new ArrayList<>();
		vos.add(new OrderVO(1, "��","���", 10, 1000,orderNum , "01027270602", "��õ"));
		vos.add(new OrderVO(1, "��","�̿���", 11, 1500,orderNum , "01027270602", "��õ"));
		new OrderGUI(vos);*/
//		new OrderListGUI();
	}//end main()

}
