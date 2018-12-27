package test.com;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame{

	public Home() {
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btn_user = new JButton("¼Õ´Ô");
		getContentPane().add(btn_user);
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserPage();
			}
		});
		
		JButton btn_dir = new JButton("°ü¸®ÀÚ");
		getContentPane().add(btn_dir);
		btn_dir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new DirPage();
				new DirLoginPage();
			}
		});

		setBounds(new Rectangle(0, 0, 250, 300));
		setVisible(true);
		setTitle("Home");
	}
	
}
