package test.com;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DirPage extends JFrame {
	public DirPage() {
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btn_memberdir = new JButton("Member 包府");
		btn_memberdir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MemSelectAllPage();
			}
		});
		getContentPane().add(btn_memberdir);
		
		JButton btn_roomdir = new JButton("Room 包府");
		btn_roomdir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomSelectAllPage(2018); // 包府磊其捞瘤
				
			}
		});
		getContentPane().add(btn_roomdir);
		
		JButton btn_gamedir = new JButton("Game 包府");
		btn_gamedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameSelectAllPage(2018);
			}
		});
		getContentPane().add(btn_gamedir);
		
		setVisible(true);
		setBounds(new Rectangle(250, 0, 250, 300));
		setTitle("DirPage");
	}

}
