package test.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HeroSelectPage extends JFrame {

	public HeroSelectPage(String member) {

		getContentPane().setLayout(null);
		
		JButton btn_Ryan = new JButton("");
		btn_Ryan.setIcon(new ImageIcon("resource/Hero_Ryan.png"));
		btn_Ryan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BattlePage(1,1,member);
				dispose();
			}
		});
		btn_Ryan.setBounds(28, 113, 280, 100);
		getContentPane().add(btn_Ryan);

		JButton btn_Frodo = new JButton("");
		btn_Frodo.setIcon(new ImageIcon("resource/Hero_Frodo.png"));
		btn_Frodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BattlePage(1,2,member);
				dispose();
			}
		});
		btn_Frodo.setBounds(28, 223, 280, 100);
		getContentPane().add(btn_Frodo);
		
		JButton btn_Tube = new JButton("");
		btn_Tube.setIcon(new ImageIcon("resource/Hero_Tube.png"));
		btn_Tube.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BattlePage(1,3,member);
				dispose();
			}
		});
		btn_Tube.setBounds(28, 333, 280, 100);
		getContentPane().add(btn_Tube);

		setBounds(new Rectangle(500, 80, 350, 600));
		getContentPane().setBackground(Color.ORANGE);
		
		JLabel lb_Select = new JLabel("< \uCE90\uB9AD\uD130\uB97C \uC120\uD0DD\uD558\uC138\uC694 >");
		lb_Select.setForeground(Color.WHITE);
		lb_Select.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Select.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lb_Select.setBounds(55, 37, 229, 48);
		getContentPane().add(lb_Select);
		
		JButton btn_MonsterBook = new JButton("\uC0C1\uB300 \uCE90\uB9AD\uD130 \uC815\uBCF4");
		btn_MonsterBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BookPage(member);
				dispose();
			}
		});
		btn_MonsterBook.setForeground(Color.DARK_GRAY);
		btn_MonsterBook.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		btn_MonsterBook.setBounds(88, 471, 153, 59);
		getContentPane().add(btn_MonsterBook);
		setTitle("CHARACTER SELECT");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
