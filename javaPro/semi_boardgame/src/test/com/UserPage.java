package test.com;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserPage extends JFrame {
	public UserPage() {
		getContentPane().setLayout(new GridLayout(4, 1, 0, 0));

		JButton btn_register = new JButton("회원가입");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MemInsertPage();
			}
		});
		getContentPane().add(btn_register);

		JButton btn_login = new JButton("로그인");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
			}
		});
		getContentPane().add(btn_login);

		JButton btn_findId = new JButton("ID찾기");
		btn_findId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindIdPage();
			}
		});
		getContentPane().add(btn_findId);
		
		JButton btn_findpw= new JButton("비밀번호 찾기");
    	btn_findpw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_findpw");
				new FindPwPage();
				
			}
		}); 
    	getContentPane().add(btn_findpw);

		setBounds(new Rectangle(250, 0, 250, 300));
		setTitle("UserPage");
		setVisible(true);
	}
}
