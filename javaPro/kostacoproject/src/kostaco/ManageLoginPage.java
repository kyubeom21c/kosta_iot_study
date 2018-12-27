package kostaco;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class ManageLoginPage extends JFrame {
	private JTextField textField;

	public ManageLoginPage() {
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout(0, 0));
		
		JPanel jp_title = new JPanel();
		con.add(jp_title, BorderLayout.NORTH);
		
		JLabel jl_ManagerLogin = new JLabel("Manager Login");
		jp_title.add(jl_ManagerLogin);
		////////////////////////////////////////////////////////
		JPanel jp_login = new JPanel();
		con.add(jp_login, BorderLayout.CENTER);
		jp_login.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel jp_id = new JPanel();
		jp_login.add(jp_id);
		
		JLabel jl_id = new JLabel("ID : ");
		jp_id.add(jl_id);
		
		JLabel jl_system = new JLabel("SYSTEM");
		jp_id.add(jl_system);
		/////////////////////////////
		JPanel jp_pw = new JPanel();
		jp_login.add(jp_pw);
		
		JLabel jl_pw = new JLabel("PASSWORD : ");
		jp_pw.add(jl_pw);
		
		JPasswordField tf_pw = new JPasswordField();
		jp_pw.add(tf_pw);
		tf_pw.setColumns(10);
		////////////////////////////////////////////////////////////
		JPanel jp_btn = new JPanel();
		con.add(jp_btn, BorderLayout.SOUTH);
		
		JButton btn_login = new JButton("로그인");
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_pw.getText().equals("hi123456")) {
					new ManagePage();
					dispose();
				}
				else
					new LoginFailPage();

			}
		});
		jp_btn.add(btn_login);
		
		JButton btn_back = new JButton("이전");
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomePage();
				dispose();
			}
		});
		jp_btn.add(btn_back);
		

		setTitle("manageloginpage");
		setBounds(200, 0, 500, 200);
		setVisible(true);
	}
	
}
