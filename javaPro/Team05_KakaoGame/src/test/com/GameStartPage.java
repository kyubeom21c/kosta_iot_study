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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import test.com.model.HeroDAO;
import test.com.model.HeroDAOimpl;
import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;
import test.com.model.MonsterDAO;
import test.com.model.MonsterDAOimpl;

public class GameStartPage extends JFrame {
	private JTextField txt_Name;

	public GameStartPage() {
		setTitle("GameStart");
		getContentPane().setBackground(Color.ORANGE);
		setBounds(new Rectangle(500, 80, 350, 600));
		getContentPane().setLayout(null);
		
		txt_Name = new JTextField();
		txt_Name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		txt_Name.setBounds(85, 376, 167, 38);
		getContentPane().add(txt_Name);

		JButton btn_Start = new JButton("\uAC8C\uC784\uC2DC\uC791");
		btn_Start.setForeground(Color.DARK_GRAY);
		btn_Start.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_Start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MemberDAO daoMem = new MemberDAOimpl();
				MemberVO vo = new MemberVO();
				vo.setName(txt_Name.getText());
				daoMem.insert(vo);
				
				HeroDAO daoHero = new HeroDAOimpl();
				daoHero.insert();
				
				MonsterDAO daoMon = new MonsterDAOimpl();
				daoMon.setStat();
				
				new HeroSelectPage(txt_Name.getText());
				dispose();
			}
		});
		btn_Start.setBounds(85, 453, 167, 59);
		getContentPane().add(btn_Start);

		JLabel lb_StartImage = new JLabel("");
		lb_StartImage.setIcon(new ImageIcon("resource/start.jpg"));
		lb_StartImage.setBounds(0, 94, 360, 204);
		getContentPane().add(lb_StartImage);

		JLabel lb_StartName = new JLabel("\uC744 \uC785\uB825\uD558\uC138\uC694");
		lb_StartName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lb_StartName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_StartName.setBounds(157, 328, 95, 38);
		getContentPane().add(lb_StartName);
		
		JLabel lb_GameName = new JLabel("~ \uD504\uB80C\uC988 \uD30C\uC774\uD130 ~");
		lb_GameName.setForeground(Color.WHITE);
		lb_GameName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_GameName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lb_GameName.setBounds(53, 33, 224, 38);
		getContentPane().add(lb_GameName);
		
		JLabel lb_Color = new JLabel("\uC0AC\uC6A9\uC790 \uC774\uB984");
		lb_Color.setBorder(new LineBorder(Color.WHITE));
		lb_Color.setForeground(new Color(0, 0, 128));
		lb_Color.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		lb_Color.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Color.setBounds(82, 340, 81, 15);
		getContentPane().add(lb_Color);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
