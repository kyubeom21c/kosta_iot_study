package hankki.member.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Complete_page extends JFrame {

	public Complete_page() {

		// 2.
		Container con = getContentPane();
		con.setLayout(new GridLayout(2, 1));

		// 4.
		JLabel complete = new JLabel("                 회원가입 완료!");

		JButton btn_complete = new JButton("확인");
		btn_complete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(" ");
				dispose();
			}
		});

		// 3.
		con.add(complete);
		con.add(btn_complete);
		
		// 1.
		setTitle(" ");
		setBounds(301, 0, 200, 100);
		setVisible(true);

	}
	
	
	
}
