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

public class BookPage extends JFrame {
	
	public BookPage(String member) {
		
		setTitle("EnemyInfo");
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);

		JButton btn_Apeach = new JButton("");
		btn_Apeach.setIcon(new ImageIcon("resource/APEACH1.jpg"));
		btn_Apeach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MonsterBookPage(1,member);
				dispose();
			}
		});
		btn_Apeach.setBounds(12, 137, 150, 120);
		getContentPane().add(btn_Apeach);
		
		JButton btn_Neo = new JButton("");
		btn_Neo.setIcon(new ImageIcon("resource/NEO1.png"));
		btn_Neo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MonsterBookPage(2,member);
				dispose();
			}
		});
		btn_Neo.setName("");
		btn_Neo.setBounds(172, 137, 150, 120);
		getContentPane().add(btn_Neo);
		
		JButton btn_JayG = new JButton("");
		btn_JayG.setIcon(new ImageIcon("resource/JAYG1.jpg"));
		btn_JayG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MonsterBookPage(3,member);
				dispose();
			}
		});
		btn_JayG.setBounds(12, 267, 150, 120);
		getContentPane().add(btn_JayG);

		JButton btn_Muzi_Con = new JButton("");
		btn_Muzi_Con.setIcon(new ImageIcon("resource/MUZI1.jpg"));
		btn_Muzi_Con.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MonsterBookPage(4,member);
				dispose();
			}
		});
		btn_Muzi_Con.setBounds(172, 267, 150, 120);
		getContentPane().add(btn_Muzi_Con);

		JLabel lblNewLabel = new JLabel("~ \uC0C1\uB300 \uCE90\uB9AD\uD130 \uC815\uBCF4 ~");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		lblNewLabel.setBounds(40, 50, 249, 32);
		getContentPane().add(lblNewLabel);
		
		JButton btn_Back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HeroSelectPage(member);
				dispose();
			}
		});
		btn_Back.setForeground(Color.DARK_GRAY);
		btn_Back.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_Back.setBounds(100, 463, 132, 50);
		getContentPane().add(btn_Back);

		setBounds(new Rectangle(500, 80, 350, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
