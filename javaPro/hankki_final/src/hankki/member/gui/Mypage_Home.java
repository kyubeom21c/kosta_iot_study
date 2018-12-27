package hankki.member.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hankki.member.model.MemberDAO;
import hankki.member.model.MemberDAOImpl;
import hankki.member.model.MemberVO;
import hankki.order.gui.OrderListGUI;

public class Mypage_Home extends JFrame {
	

	MemberVO vo;

	public Mypage_Home(String a,String b)  {
		System.out.println();
		 
		MemberDAO dao = new MemberDAOImpl();

		// 2
		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 2));

		// 3
		
		JLabel name = new JLabel("이름");
		JLabel tel = new JLabel("전화번호");
		JLabel email = new JLabel("e-mail");
		JLabel card = new JLabel("카드번호");
		JLabel address = new JLabel("주소");
		
		
		
		vo = dao.getClientInfo(a, b);//형이 준정보 여기다 넣을것
		JLabel userName = new JLabel(vo.getName());
		JLabel userTel = new JLabel(vo.getTel());
		JLabel userEmail = new JLabel(vo.getEmail());
		JLabel userCard = new JLabel(vo.getCard());
		JLabel userAddress = new JLabel(vo.getAddress());

		JButton btn_update = new JButton("개인정보수정");
		JButton btn_check = new JButton("주문확인");
		//5
		
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new Update_page(vo);
				setVisible(false);
				
			}
		});
		btn_check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				new OrderListGUI();
			}
		});
		

		
		

		// 4
		con.add(name);
		con.add(userName);
		con.add(tel);
		con.add(userTel);
		con.add(email);
		con.add(userEmail);
		con.add(card);
		con.add(userCard);
		con.add(address);
		con.add(userAddress);
		con.add(btn_update);
		con.add(btn_check);
		// 1
		setTitle("My page");
		setBounds(0, 0, 300, 400);
		setVisible(true);
	}// end Home

}// end class
