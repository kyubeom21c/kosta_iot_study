package test.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import test.com.model.MonsterDAO;
import test.com.model.MonsterDAOimpl;
import test.com.model.MonsterVO;

public class EditPage extends JFrame {
	private JTextField ed_hp;
	private JTextField ed_attack;
	private JTextField ed_defense;
	
	public EditPage(int num,String member) {
		setTitle("EnemyEdit");
		getContentPane().setBackground(Color.ORANGE);
		setVisible(true);
		setBounds(new Rectangle(500, 80, 350, 600));
		getContentPane().setLayout(null);
		
		
		JLabel lb_hp = new JLabel("\uCCB4\uB825");
		lb_hp.setForeground(new Color(0, 128, 0));
		lb_hp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lb_hp.setBorder(new LineBorder(Color.WHITE));
		lb_hp.setHorizontalAlignment(SwingConstants.CENTER);
		lb_hp.setBounds(63, 165, 74, 42);
		getContentPane().add(lb_hp);
		
		JLabel lb_attack = new JLabel("\uACF5\uACA9\uB825");
		lb_attack.setForeground(new Color(220, 20, 60));
		lb_attack.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lb_attack.setBorder(new LineBorder(Color.WHITE));
		lb_attack.setHorizontalAlignment(SwingConstants.CENTER);
		lb_attack.setBounds(63, 268, 74, 42);
		getContentPane().add(lb_attack);
		
		JLabel lb_defense = new JLabel("\uBC29\uC5B4\uB825");
		lb_defense.setForeground(new Color(0, 0, 139));
		lb_defense.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lb_defense.setBorder(new LineBorder(Color.WHITE));
		lb_defense.setHorizontalAlignment(SwingConstants.CENTER);
		lb_defense.setBounds(63, 366, 74, 42);
		getContentPane().add(lb_defense);
		
		ed_hp = new JTextField();
		ed_hp.setHorizontalAlignment(SwingConstants.CENTER);
		ed_hp.setBounds(148, 165, 125, 42);
		getContentPane().add(ed_hp);
		ed_hp.setColumns(10);
		
		ed_attack = new JTextField();
		ed_attack.setHorizontalAlignment(SwingConstants.CENTER);
		ed_attack.setColumns(10);
		ed_attack.setBounds(148, 268, 125, 42);
		getContentPane().add(ed_attack);
		
		ed_defense = new JTextField();
		ed_defense.setHorizontalAlignment(SwingConstants.CENTER);
		ed_defense.setColumns(10);
		ed_defense.setBounds(148, 366, 125, 42);
		getContentPane().add(ed_defense);

		JButton Edit_Button = new JButton("\uD3B8\uC9D1 \uC644\uB8CC");
		Edit_Button.setForeground(new Color(0, 0, 139));
		Edit_Button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		Edit_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MonsterDAO edao = new  MonsterDAOimpl();
				MonsterVO evo = new MonsterVO();
				evo.setHp(Integer.parseInt(ed_hp.getText()));
				evo.setAttack(Integer.parseInt(ed_attack.getText()));
				evo.setDefense(Integer.parseInt(ed_defense.getText()));
				evo.setNum(num);
				
				edao.update(evo);
				
				new MonsterBookPage(num,member);
				dispose();
			}
		});
		Edit_Button.setBounds(63, 490, 210, 42);
		getContentPane().add(Edit_Button);
		
		JLabel lb_Want = new JLabel("\uC6D0\uD558\uB294 \uB2A5\uB825\uCE58\uB97C \uC124\uC815\uD574\uC8FC\uC138\uC694");
		lb_Want.setForeground(Color.WHITE);
		lb_Want.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lb_Want.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Want.setBounds(40, 54, 259, 62);
		getContentPane().add(lb_Want);
	}
}
