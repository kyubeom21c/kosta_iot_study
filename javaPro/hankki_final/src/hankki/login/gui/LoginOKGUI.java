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

		// 2.�����̳� + ���̾ƿ�
		Container con = getContentPane();
		con.setLayout(new GridLayout(5,1));

		// 3.�ʿ��� ������Ʈ ������Ʈ�� ����
		JLabel jl_title = new JLabel("�ѳ��Ļ� ");


		JButton btn_ordercho = new JButton("�ֹ�");
		JButton btn_mypage = new JButton("����������");
		JButton btn_menuAdd = new JButton("�޴�����");
		JButton btn_exit = new JButton("����");

		// 4.�̺�Ʈó��
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

		// 5.�����̳ʿ� ������Ʈ �߰�
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
