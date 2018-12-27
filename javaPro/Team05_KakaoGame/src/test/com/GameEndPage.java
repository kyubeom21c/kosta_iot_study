package test.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import test.com.model.HeroDAO;
import test.com.model.HeroDAOimpl;
import test.com.model.MonsterDAO;
import test.com.model.MonsterDAOimpl;
import test.com.model.ScoreDAO;
import test.com.model.ScoreDAOimpl;
import test.com.model.ScoreVO;

public class GameEndPage extends JFrame {
	private JTable tbl_Score;
	public GameEndPage(String member) {
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		
		JScrollPane scl_Score = new JScrollPane();
		scl_Score.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		scl_Score.setBounds(12, 259, 310, 150);
		getContentPane().add(scl_Score);
		
		String[] columns = new String[] { 
				"NUM", "NAME", "SCORE" 
			};
		
		ScoreDAO daoScore = new ScoreDAOimpl();
		List<ScoreVO> vosScore = daoScore.selectAll();
		
		String[][] datas =
				new String[vosScore.size()][columns.length];
		
		int count = 0;
		
		for (ScoreVO vo : vosScore) {
			datas[count] = new String[] {
					vo.getNum()+"",
					vo.getName(),
					vo.getScore()+""
			};
			count++;
		}

		DefaultTableModel dm = new DefaultTableModel(datas, columns);
		
		tbl_Score = new JTable(dm);
		tbl_Score.setGridColor(Color.ORANGE);
		tbl_Score.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		scl_Score.setViewportView(tbl_Score);
		
		JButton btn_Home = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btn_Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HeroDAO daoHero = new HeroDAOimpl();
				daoHero.delete();
				MonsterDAO daoMon = new MonsterDAOimpl();
				daoMon.deleteAll();
				new GameStartPage();
				dispose();
			}
		});
		btn_Home.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_Home.setForeground(Color.DARK_GRAY);
		btn_Home.setBounds(178, 424, 132, 64);
		getContentPane().add(btn_Home);
		
		JLabel lb_End = new JLabel("< Game End >");
		lb_End.setForeground(Color.WHITE);
		lb_End.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lb_End.setHorizontalAlignment(SwingConstants.CENTER);
		lb_End.setBounds(50, 10, 232, 64);
		getContentPane().add(lb_End);
		
		JButton btn_Restart = new JButton("\uC7AC\uB3C4\uC804");
		btn_Restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HeroDAO daoHero = new HeroDAOimpl();
				daoHero.delete();
				daoHero.insert();
				new HeroSelectPage(member);
				dispose();
			}
		});
		btn_Restart.setForeground(new Color(0, 0, 139));
		btn_Restart.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_Restart.setBounds(22, 424, 132, 64);
		getContentPane().add(btn_Restart);
		
		JLabel lb_EndImage = new JLabel("");
		lb_EndImage.setIcon(new ImageIcon("resource/endgame.jpg"));
		lb_EndImage.setBounds(0, 100, 334, 150);
		getContentPane().add(lb_EndImage);
		
		JButton btn_End = new JButton("\uB05D\uB0B4\uAE30");
		btn_End.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HeroDAO daoHero = new HeroDAOimpl();
				daoHero.delete();
				MonsterDAO daoMon = new MonsterDAOimpl();
				daoMon.deleteAll();
				System.exit(0);
			}
		});
		btn_End.setForeground(new Color(178, 34, 34));
		btn_End.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_End.setBounds(100, 505, 132, 43);
		getContentPane().add(btn_End);
		
		setBounds(new Rectangle(500, 80, 350, 600));
		setTitle("GameEnd");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
