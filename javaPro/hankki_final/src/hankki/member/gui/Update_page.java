package hankki.member.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hankki.member.model.MemberDAO;
import hankki.member.model.MemberDAOImpl;
import hankki.member.model.MemberVO;

public class Update_page extends JFrame {

	public Update_page(MemberVO vo) {

		// MemberDAO dao = MemberDAOImpl();

		// 2
		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 2));

		// 3
		JLabel name = new JLabel("이름");
		JLabel tel = new JLabel("전화번호");
		JLabel email = new JLabel("e-mail");
		JLabel card = new JLabel("카드번호");
		JLabel address = new JLabel("주소");

		JTextField tf_name = new JTextField(vo.getName());
		JTextField tf_tel = new JTextField(vo.getTel());
		JTextField tf_email = new JTextField(vo.getEmail());
		JTextField tf_card = new JTextField(vo.getCard());
		JTextField tf_address = new JTextField(vo.getAddress());

		JButton btn_confirm = new JButton("수정완료");
		
		//4
		btn_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				MemberVO vo = new MemberVO();
				MemberDAO dao = new MemberDAOImpl();
				
//				vo = dao.getClientInfo("ddd", "bbb");
				
				vo.setName(tf_name.getText());
				vo.setTel(tf_tel.getText());
				vo.setEmail(tf_email.getText());
				vo.setCard(tf_card.getText());
				vo.setAddress(tf_address.getText());
				dao.update(vo);
				setVisible(false);
				
				
			}
		});
		

		// 5
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
		con.add(btn_confirm);

		// 1
		setTitle("개인정보수정");
		setBounds(601, 0, 300, 400);
		setVisible(true);
	}

}
