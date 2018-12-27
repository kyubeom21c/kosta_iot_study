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

public class LoginSelectPage extends JFrame {

	public LoginSelectPage() {

		Container con = getContentPane();

		JPanel jp_title = new JPanel();
		jp_title.setFont(new Font("����", Font.PLAIN, 50));
		con.add(jp_title, BorderLayout.NORTH);

		JLabel title = new JLabel("Member");
		jp_title.add(title);

		///////////////////////////////////

		JPanel jp_center = new JPanel();
		con.add(jp_center, BorderLayout.CENTER);
		jp_center.setLayout(new GridLayout(1, 2, 5, 5));

		// ȸ��

		JButton btn_login = new JButton("�α���");
		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new LoginPage();
				dispose();
			}
		});

		jp_center.add(btn_login);

		// ȸ������

		JButton btn_new = new JButton("ȸ������");
		btn_new.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new NewMemberPage();
				dispose();
			}
		});

		jp_center.add(btn_new);

		setTitle("LoginSelectPage");
		setBounds(200, 200, 500, 200);
		setVisible(true);

	}
}
