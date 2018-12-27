package hankki.login.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hankki.member.gui.Mypage_Home;
import hankki.menuadd.gui.MenuAddMainGUI;
import hankki.menucho.gui.MenuChoiceGUI;

public class LoginOKGUI extends JFrame {
	
	
	

	public LoginOKGUI() {

		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(5,1));

		// 3.필요한 컴포넌트 오브젝트들 생성
		JLabel jl_title = new JLabel("한끼식사 ");


		JButton btn_ordercho = new JButton("주문");
		JButton btn_mypage = new JButton("마이페이지");
		JButton btn_menuAdd = new JButton("메뉴관리");
		JButton btn_exit = new JButton("종료");

		// 4.이벤트처리
		btn_menuAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuAddMainGUI();

			}
		});
		btn_ordercho.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuChoiceGUI();
				setVisible(false);

			}
		});
		btn_mypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Mypage_Home(LoginGUI.email,LoginGUI.tel);

			}
		});
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_exit click");
				System.exit(0);
				//dispose();

			}
		});

		// 5.컨테이너에 컴포넌트 추가
		con.add(jl_title);
		con.add(btn_ordercho);
		con.add(btn_mypage);
		con.add(btn_menuAdd);
		con.add(btn_exit);
		// 1.
		setTitle("Login");
		setBounds(0, 0, 400, 300);
		setVisible(true);
	}
	
	public void loginOK() {
		
	}

}
