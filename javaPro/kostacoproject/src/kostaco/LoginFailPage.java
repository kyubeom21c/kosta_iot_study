package kostaco;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFailPage extends JFrame {

	public LoginFailPage() {

		Container con = getContentPane();

		JPanel content = new JPanel();
		con.add(content, BorderLayout.CENTER);
		content.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel jl_content = new JLabel("비밀번호가 틀렸습니다.");
		content.add(jl_content);

		JPanel btn = new JPanel();
		con.add(btn, BorderLayout.SOUTH);

		JButton btn_ok = new JButton("확인");
		btn_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btn.add(btn_ok);

		setTitle("LoginFailed");
		setBounds(200, 0, 300, 150);
		setVisible(true);
	}

}
