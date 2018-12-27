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
import javax.swing.border.LineBorder;

import test.com.model.MonsterDAO;
import test.com.model.MonsterDAOimpl;
import test.com.model.MonsterVO;

public class MonsterBookPage extends JFrame {
	
	
	public MonsterBookPage(int num,String member) {
		setTitle("EnemyInfo");
		getContentPane().setBackground(Color.ORANGE);
		setBounds(new Rectangle(500, 80, 350, 600));
		getContentPane().setLayout(null);
		
		JLabel lb_hp = new JLabel("\uCCB4\uB825");
		lb_hp.setForeground(Color.DARK_GRAY);
		lb_hp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lb_hp.setBackground(Color.WHITE);
		lb_hp.setHorizontalAlignment(SwingConstants.CENTER);
		lb_hp.setBounds(55, 393, 57, 31);
		getContentPane().add(lb_hp);
		
		MonsterDAO dao = new MonsterDAOimpl();
		MonsterVO vo = new MonsterVO();
		MonsterVO vo2 = new MonsterVO();
		
		vo.setNum(num);
		
		vo2 = dao.selectOne(vo);
		
		JLabel lb_hp_int = new JLabel(Integer.toString(vo2.getHp()));
		lb_hp_int.setBorder(new LineBorder(Color.WHITE, 2));
		lb_hp_int.setForeground(new Color(0, 128, 0));
		lb_hp_int.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lb_hp_int.setHorizontalAlignment(SwingConstants.CENTER);
		lb_hp_int.setBounds(55, 425, 57, 51);
		getContentPane().add(lb_hp_int);
		
		JLabel lb_attack = new JLabel("\uACF5\uACA9\uB825");
		lb_attack.setForeground(Color.DARK_GRAY);
		lb_attack.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lb_attack.setHorizontalAlignment(SwingConstants.CENTER);
		lb_attack.setBounds(140, 393, 57, 31);
		getContentPane().add(lb_attack);
		
		JLabel lb_attack_int = new JLabel(Integer.toString(vo2.getAttack()));
		lb_attack_int.setBorder(new LineBorder(Color.WHITE, 2));
		lb_attack_int.setForeground(new Color(220, 20, 60));
		lb_attack_int.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lb_attack_int.setHorizontalAlignment(SwingConstants.CENTER);
		lb_attack_int.setBounds(140, 425, 57, 51);
		getContentPane().add(lb_attack_int);
		
		JLabel lb_defense = new JLabel("\uBC29\uC5B4\uB825");
		lb_defense.setForeground(Color.DARK_GRAY);
		lb_defense.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lb_defense.setHorizontalAlignment(SwingConstants.CENTER);
		lb_defense.setBounds(223, 393, 57, 31);
		getContentPane().add(lb_defense);		
		
		JLabel lb_defense_int = new JLabel(Integer.toString(vo2.getDefense()));
		lb_defense_int.setBorder(new LineBorder(Color.WHITE, 2));
		lb_defense_int.setForeground(new Color(0, 0, 139));
		lb_defense_int.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lb_defense_int.setHorizontalAlignment(SwingConstants.CENTER);
		lb_defense_int.setBounds(223, 425, 57, 51);
		getContentPane().add(lb_defense_int);
		
		JLabel lb_MonName = new JLabel(vo2.getName());
		lb_MonName.setForeground(Color.WHITE);
		lb_MonName.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		lb_MonName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_MonName.setBounds(59, 25, 225, 51);
		getContentPane().add(lb_MonName);
		
		
		JLabel lb_MonImage = new JLabel("");
		lb_MonImage.setHorizontalAlignment(SwingConstants.CENTER);
		lb_MonImage.setBounds(12, 93, 310, 280);
		
		switch (num) {
		
		case 1:
			lb_MonImage.setIcon(new ImageIcon("resource/apeach.png"));
			break;
			
		case 2:
			lb_MonImage.setIcon(new ImageIcon("resource/neo.png"));
			break;
			
		case 3:
			lb_MonImage.setIcon(new ImageIcon("resource/jayg.png"));
			break;
			
		case 4:
			lb_MonImage.setIcon(new ImageIcon("resource/muzi.png"));
			break;

		default:
			break;
		}
			
		getContentPane().add(lb_MonImage);	
		
		JButton btn_Back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BookPage(member);
				dispose();
			}
		});
		btn_Back.setForeground(new Color(220, 20, 60));
		btn_Back.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_Back.setBounds(170, 500, 110, 40);
		getContentPane().add(btn_Back);
		
		JButton btn_Edit = new JButton("\uD3B8\uC9D1\uD558\uAE30");
		btn_Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EditPage(num,member);
				dispose();
			}
		});
		btn_Edit.setForeground(new Color(0, 0, 139));
		btn_Edit.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_Edit.setBounds(55, 500, 110, 40);
		getContentPane().add(btn_Edit);
		
		setVisible(true);
	}

}
