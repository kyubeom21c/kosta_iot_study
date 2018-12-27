package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DirLoginPage extends JFrame {
	
	private final String dirPw = "1"; // 관리자 비밀번호

	public DirLoginPage() {
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 1));
		
		JLabel msg = new JLabel("관리자 비밀번호를 입력하세요");
		JTextField inputPw = new JTextField();
		
		
		JButton check = new JButton("관리자 화면 접속하기");
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputPw.getText().equals(dirPw)) {

					new DirPage();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 맞지않습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);

				}
				
			}
		});
		
		con.add(msg);
		con.add(inputPw);
		con.add(check);
		
		
		setBounds(250, 0, 250, 300);
		setTitle("관리자 로그인");
		setVisible(true);
	}
	
}
