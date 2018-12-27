package kostaco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import member.model.MemberDAO;
import member.model.MemberDAOimpl;
import member.model.MemberVO;

public class LoginPage extends JFrame {
	static MemberVO vo2;

	public LoginPage() {

		Container con = getContentPane();

		JPanel jp_title = new JPanel();
		jp_title.setFont(new Font("����", Font.PLAIN, 50));
		con.add(jp_title, BorderLayout.NORTH);

		JLabel title = new JLabel("�α���");
		jp_title.add(title);

		///////////////////////////////////

		JPanel jp_center = new JPanel();
		con.add(jp_center, BorderLayout.CENTER);
		jp_center.setLayout(new GridLayout(2, 2, 5, 5));

		// �α���â
		JLabel id = new JLabel("���̵�");
		JTextField tf_id = new JTextField();
		jp_center.add(id);
		jp_center.add(tf_id);

		JLabel pw = new JLabel("��й�ȣ");
		JPasswordField tf_pw = new JPasswordField();
		jp_center.add(pw);
		jp_center.add(tf_pw);

		// �α���
		JPanel jp_OK = new JPanel();
		con.add(jp_OK, BorderLayout.SOUTH);
		jp_OK.setLayout(new GridLayout(1, 1, 0, 0));

		JButton btn_OK = new JButton("Ȯ��");
		jp_OK.add(btn_OK);

		btn_OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MemberVO vo = new MemberVO();
				MemberDAO dao = new MemberDAOimpl();

				vo.setId(tf_id.getText());

				vo2 = dao.selectOne(vo);

				if (vo2.getPw().equals(tf_pw.getText())) {
					new HomePage();
					dispose();
				} else {
					new LoginFailPage();
					
				}
				
			}

		});
		
		JButton btn_main = new JButton("��������");
		jp_OK.add(btn_main);
		btn_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_main");
				new MainPage();
				dispose();
			}
		});

////////////////////////////

		setTitle("LoginPage");
		setBounds(700, 0, 500, 300);
		setVisible(true);

	}// end loginpage

}// end class
