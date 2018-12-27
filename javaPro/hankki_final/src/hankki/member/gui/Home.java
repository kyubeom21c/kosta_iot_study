package hankki.member.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hankki.member.model.MemberDAO;
import hankki.member.model.MemberDAOImpl;
import hankki.member.model.MemberVO;

public class Home extends JFrame {

	public Home() {

		// 2.
		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 2));

		JLabel name = new JLabel("이름");
		JLabel tel = new JLabel("전화번호");
		JLabel email = new JLabel("E-Mail");
		JLabel card = new JLabel("카드번호");
		JLabel address = new JLabel("주소");

		JTextField tf_name = new JTextField("name");
		JTextField tf_tel = new JTextField("tel");
		JTextField tf_email = new JTextField("email");
		JTextField tf_card = new JTextField("card");
		JTextField tf_address = new JTextField("address");

		JButton btn_OK = new JButton("OK");

		// 5

		btn_OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입이 완료되었습니다.");
				new Complete_page();
				MemberVO vo = new MemberVO();
				MemberDAO dao = new MemberDAOImpl();
				vo.setName(tf_name.getText());
				vo.setTel(tf_tel.getText());
				vo.setEmail(tf_email.getText());
				vo.setCard(tf_card.getText());
				vo.setAddress(tf_address.getText());
				dao.insert(vo);
				setVisible(false);
			}
		});

		// 4.
		con.add(name);
		con.add(tf_name);
		con.add(tel);
		con.add(tf_tel);
		con.add(email);
		con.add(tf_email);
		con.add(card);
		con.add(tf_card);
		con.add(address);
		con.add(tf_address);
		con.add(btn_OK);

		// 1.
		setTitle("회원가입");
		setBounds(0, 0, 300, 400);
		setVisible(true);

	}// end method()
	

}// end class
