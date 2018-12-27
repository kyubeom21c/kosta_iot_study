package test.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import test.com.model.HeroDAO;
import test.com.model.HeroDAOimpl;
import test.com.model.HeroVO;
import test.com.model.MonsterDAO;
import test.com.model.MonsterDAOimpl;
import test.com.model.MonsterVO;
import test.com.model.ScoreDAO;
import test.com.model.ScoreDAOimpl;
import test.com.model.ScoreVO;

public class BattlePage extends JFrame {

	public int selectNum;

	public String heroName;
	public String monsterName;

	public int heroAttack;
	public int monsterAttack;

	public int heroDefense;
	public int monsterDefense;

	public int heroHp;
	public int monsterHp;

	public int heroHpMax;
	public int monsterHpMax;
	
	public int heroAttackGap; 
	public int monAttackGap;

	public int heroScore;
	public int count;

	public BattlePage(int num,int hero,String member) {

		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);

		JLabel lb_Monster = new JLabel("");
		
		switch (num) {
		case 1:
			count = 1;
			heroScore = 0;
			lb_Monster.setIcon(new ImageIcon("resource/apeach.png"));
			break;
		case 2:
			count = 2;
			heroScore = 25;
			lb_Monster.setIcon(new ImageIcon("resource/neo.png"));
			break;
		case 3:
			count = 3;
			heroScore = 50;
			lb_Monster.setIcon(new ImageIcon("resource/jayg.png"));
			break;
		case 4:
			count = 4;
			heroScore = 75;
			lb_Monster.setIcon(new ImageIcon("resource/muzi.png"));
			break;
		default:
			break;
		}
		MonsterDAO daoMon = new MonsterDAOimpl();
		MonsterVO voMon = new MonsterVO();
		MonsterVO voMon2 = new MonsterVO();
		voMon.setNum(num);
		voMon2 = daoMon.selectOne(voMon);
		
		monsterName = voMon2.getName();
		monsterAttack = voMon2.getAttack();
		monsterDefense = voMon2.getDefense();
		monsterHp = voMon2.getHp();
		monsterHpMax = monsterHp;
		
		HeroDAO daoHero = new HeroDAOimpl();
		HeroVO voHero = new HeroVO();
		HeroVO voHero2 = new HeroVO();
		voHero.setNum(hero);
		voHero2 = daoHero.selectOne(voHero);

		heroName = voHero2.getName();
		heroHp = voHero2.getHp();
		heroAttack = voHero2.getAttack();
		heroDefense = voHero2.getDefense();
		heroHpMax = heroHp;
		
		lb_Monster.setBackground(Color.WHITE);
		lb_Monster.setBounds(12, 76, 310, 280);
		getContentPane().add(lb_Monster);

		JLabel lb_MonsterName = new JLabel(monsterName);
		lb_MonsterName.setForeground(new Color(105, 105, 105));
		lb_MonsterName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_MonsterName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_MonsterName.setBounds(124, 38, 95, 28);
		getContentPane().add(lb_MonsterName);

		JLabel lb_MonsterHp = new JLabel(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
		lb_MonsterHp.setForeground(new Color(34, 139, 34));
		lb_MonsterHp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_MonsterHp.setHorizontalAlignment(SwingConstants.CENTER);
		lb_MonsterHp.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_MonsterHp.setBackground(Color.WHITE);
		lb_MonsterHp.setBounds(222, 38, 100, 28);
		getContentPane().add(lb_MonsterHp);

		JLabel lb_Player = new JLabel(heroName);
		lb_Player.setForeground(new Color(105, 105, 105));
		lb_Player.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_Player.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Player.setBounds(12, 366, 95, 28);
		getContentPane().add(lb_Player);

		JLabel lb_PlayerHp = new JLabel(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
		lb_PlayerHp.setForeground(new Color(34, 139, 34));
		lb_PlayerHp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_PlayerHp.setHorizontalAlignment(SwingConstants.CENTER);
		lb_PlayerHp.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_PlayerHp.setBackground(Color.WHITE);
		lb_PlayerHp.setBounds(112, 366, 100, 28);
		getContentPane().add(lb_PlayerHp);

		JButton btn_Attack = new JButton("\uACF5\uACA9");
		btn_Attack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random random = new Random();
				int rNum = random.nextInt(3) + 1;
				selectNum = 1;
				switch (rNum) {
				case 1:
					heroAttackGap = monsterAttack - heroDefense;
					monAttackGap = heroAttack - monsterDefense;
					if(heroAttackGap<=0) {
						heroAttackGap = 0;
					}
					if(monAttackGap<=0) {
						monAttackGap = 0;
					}
					heroHp = heroHp - heroAttackGap;
					monsterHp = monsterHp - monAttackGap;
					JOptionPane.showMessageDialog(null, "플레이어의 공격!\n\n몬스터의 공격!\n\n서로 피해를 입었습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					if (heroHp <= 0) {
						heroHp = 0;
						lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
						JOptionPane.showMessageDialog(null, "플레이어의 체력소진!\n\n기절했습니다!", "결과",
								JOptionPane.WARNING_MESSAGE);
						setMemberScore(heroScore, member);
						new GameEndPage(member);
						dispose();
					} else if (monsterHp <= 0) {
						monsterHp = 0;
						lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
						JOptionPane.showMessageDialog(null, "몬스터의 체력소진!\n\n기절했습니다!\n\n플레이어 레벨업!", "결과", JOptionPane.WARNING_MESSAGE);
						heroHpMax += 20;
						heroAttack += 10;
						heroDefense += 5;
						heroScore += 25;
						count++;
						upgradeHeroStat(hero,heroHpMax,heroAttack,heroDefense);
						if (count == 5) {
							setMemberScore(heroScore, member);
							new GameEndPage(member);
						} else {
							new BattlePage(count,hero,member);
						}
						dispose();
					} else if ((heroHp <= 0) && (monsterHp <= 0)) {
						heroHp = 0;
						monsterHp = 0;
						lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
						lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
						JOptionPane.showMessageDialog(null, "동시에 체력소진!\n\n기절했습니다!", "결과", JOptionPane.WARNING_MESSAGE);
						setMemberScore(heroScore, member);
						new GameEndPage(member);
						dispose();
					}
					lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
					lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
					break;
				case 2:
					heroAttackGap = (int)(monsterAttack * 1.5) - heroDefense;
					if(heroAttackGap<=0) {
						heroAttackGap = 0;
					}
					heroHp = heroHp - heroAttackGap;
					JOptionPane.showMessageDialog(null, "플레이어의 공격!\n\n몬스터의 반격!\n\n플레이어가 1.5배 피해를 입었습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
					if (heroHp <= 0) {
						heroHp = 0;
						lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
						JOptionPane.showMessageDialog(null, "플레이어의 체력소진!\n\n기절했습니다!", "결과",
								JOptionPane.WARNING_MESSAGE);
						setMemberScore(heroScore, member);
						new GameEndPage(member);
						dispose();
					}
					break;
				case 3:
					monAttackGap = heroAttack - monsterDefense;
					if(monAttackGap<=0) {
						monAttackGap = 0;
					}
					monsterHp = monsterHp - monAttackGap;
					JOptionPane.showMessageDialog(null, "몬스터의 회복!\n\n플레이어의 공격!\n\n몬스터가 피해를 입었습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					if (monsterHp <= 0) {
						monsterHp = 0;
						lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
						JOptionPane.showMessageDialog(null, "몬스터의 체력소진!\n\n기절했습니다!\n\n플레이어 레벨업!", "결과", JOptionPane.WARNING_MESSAGE);
						heroHpMax += 20;
						heroAttack += 10;
						heroDefense += 5;
						heroScore += 25;
						count++;
						upgradeHeroStat(hero,heroHpMax,heroAttack,heroDefense);
						if (count == 5) {
							setMemberScore(heroScore, member);
							new GameEndPage(member);
						} else {
							new BattlePage(count,hero,member);
						}
						dispose();
					}
					lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
					break;

				default:
					break;
				}
			}	
		});
		btn_Attack.addActionListener(new BuzzActionListener(this));
		btn_Attack.setForeground(Color.RED);
		btn_Attack.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Attack.setBounds(12, 455, 88, 67);
		getContentPane().add(btn_Attack);

		JButton btn_Counter = new JButton("\uBC18\uACA9");
		btn_Counter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random random = new Random();
				int rNum = random.nextInt(3) + 1;
				selectNum = 2;
				switch (rNum) {
				case 1:
					monAttackGap = (int)(heroAttack * 1.5) - monsterDefense;
					if(monAttackGap<=0) {
						monAttackGap = 0;
					}
					monsterHp = monsterHp - monAttackGap;
					JOptionPane.showMessageDialog(null, "몬스터의 공격!\n\n플레이어의 반격!\n\n몬스터가 1.5배 피해를 입었습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					if (monsterHp <= 0) {
						monsterHp = 0;
						lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
						JOptionPane.showMessageDialog(null, "몬스터의 체력소진!\n\n기절했습니다!\n\n플레이어 레벨업!", "결과", JOptionPane.WARNING_MESSAGE);
						heroHpMax += 20;
						heroAttack += 10;
						heroDefense += 5;
						heroScore += 25;
						count++;
						upgradeHeroStat(hero,heroHpMax,heroAttack,heroDefense);
						if (count == 5) {
							setMemberScore(heroScore, member);
							new GameEndPage(member);
						} else {
							new BattlePage(count,hero,member);
						}
						dispose();
					}
					lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "플레이어의 반격!\n\n몬스터의 반격!\n\n서로 빚나갔습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					break;
				case 3:
					monsterHp += (int) (monsterHpMax * 0.1);
					if (monsterHp >= monsterHpMax) {
						monsterHp = monsterHpMax;
					}
					lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
					JOptionPane.showMessageDialog(null, "플레이어의 반격!\n\n몬스터의 회복!\n\n몬스터가 회복했습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					break;

				default:
					break;
				}
			}
		});
		btn_Counter.addActionListener(new BuzzActionListener(this));
		btn_Counter.setForeground(Color.BLUE);
		btn_Counter.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Counter.setBounds(124, 455, 88, 67);
		getContentPane().add(btn_Counter);

		JButton btn_Heal = new JButton("\uD68C\uBCF5");
		btn_Heal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random random = new Random();
				int rNum = random.nextInt(3) + 1;
				selectNum = 3;
				switch (rNum) {
				case 1:
					heroAttackGap = monsterAttack - heroDefense;
					if(heroAttackGap<=0) {
						heroAttackGap = 0;
					}
					heroHp = heroHp - heroAttackGap;
					JOptionPane.showMessageDialog(null, "플레이어의 회복!\n\n몬스터의 공격!\n\n플레이어가 피해를 입었습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					if (heroHp <= 0) {
						heroHp = 0;
						lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
						JOptionPane.showMessageDialog(null, "플레이어의 체력소진!\n\n기절했습니다!", "결과",
								JOptionPane.WARNING_MESSAGE);
						setMemberScore(heroScore, member);
						new GameEndPage(member);
						dispose();
					}
					lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
					break;
				case 2:
					heroHp += (int) (heroHpMax * 0.1);
					if (heroHp >= heroHpMax) {
						heroHp = heroHpMax;
					}
					lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
					JOptionPane.showMessageDialog(null, "플레이어의 회복!\n\n몬스터의 반격!\n\n플레이어가 회복했습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					break;
				case 3:
					heroHp += (int) (heroHpMax * 0.1);
					monsterHp += (int) (monsterHpMax * 0.1);
					if (heroHp >= heroHpMax) {
						heroHp = heroHpMax;
					}
					if (monsterHp >= monsterHpMax) {
						monsterHp = monsterHpMax;
					}
					lb_PlayerHp.setText(Integer.toString(heroHp) + " / " + Integer.toString(heroHpMax));
					lb_MonsterHp.setText(Integer.toString(monsterHp) + " / " + Integer.toString(monsterHpMax));
					JOptionPane.showMessageDialog(null, "플레이어의 회복!\n\n몬스터의 회복!\n\n서로 회복했습니다!", "결과",
							JOptionPane.WARNING_MESSAGE);
					break;

				default:
					break;
				}
			}
		});
		btn_Heal.addActionListener(new BuzzActionListener(this));
		btn_Heal.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Heal.setForeground(Color.GREEN);
		btn_Heal.setBounds(234, 455, 88, 67);
		getContentPane().add(btn_Heal);
		
		JLabel lb_Attack = new JLabel("\uACF5\uACA9\uB825");
		lb_Attack.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Attack.setForeground(Color.DARK_GRAY);
		lb_Attack.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_Attack.setBounds(12, 404, 61, 28);
		getContentPane().add(lb_Attack);
		
		JLabel lb_HeroAttack = new JLabel(Integer.toString(heroAttack));
		lb_HeroAttack.setHorizontalAlignment(SwingConstants.CENTER);
		lb_HeroAttack.setForeground(new Color(220, 20, 60));
		lb_HeroAttack.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_HeroAttack.setBounds(85, 404, 61, 28);
		getContentPane().add(lb_HeroAttack);
		
		JLabel lb_Defense = new JLabel("\uBC29\uC5B4\uB825");
		lb_Defense.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Defense.setForeground(Color.DARK_GRAY);
		lb_Defense.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_Defense.setBounds(158, 404, 61, 28);
		getContentPane().add(lb_Defense);
		
		JLabel lb_HeroDefense = new JLabel(Integer.toString(heroDefense));
		lb_HeroDefense.setHorizontalAlignment(SwingConstants.CENTER);
		lb_HeroDefense.setForeground(new Color(0, 0, 139));
		lb_HeroDefense.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_HeroDefense.setBounds(234, 404, 61, 28);
		getContentPane().add(lb_HeroDefense);

		setTitle("Battle");
		setBounds(new Rectangle(500, 80, 350, 600));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public void upgradeHeroStat(int num,int HpMax,int Attack,int Defense) {
		HeroDAO daoHero = new HeroDAOimpl();
		HeroVO voHero = new HeroVO();
		voHero.setNum(num);
		voHero.setHp(heroHpMax);
		voHero.setAttack(heroAttack);
		voHero.setDefense(heroDefense);
		daoHero.update(voHero);
	}
	
	public void setMemberScore(int sNum, String sName) {
		ScoreDAO daoScore = new ScoreDAOimpl();
		ScoreVO voScore = new ScoreVO();
		voScore.setName(sName);
		voScore.setScore(sNum);
		daoScore.insert(voScore);
	}
	
}

class BuzzActionListener implements ActionListener {
	  JFrame frame;
	  Point currLocation;
	  int iDisplaceXBy1 = 15;
	  int iDisplaceYBy1 = -20;
	  int iDisplaceXBy2 = -15;
	  int iDisplaceYBy2 = 20;

	  public BuzzActionListener(JFrame frame) {
	    this.frame = frame;
	  }

	  @Override
	  public void actionPerformed(ActionEvent evt) {
	    currLocation = frame.getLocationOnScreen();

	    Point position1 = new Point(currLocation.x + iDisplaceXBy1, currLocation.y
	        + iDisplaceYBy1);
	    Point position2 = new Point(currLocation.x - iDisplaceXBy1, currLocation.y
	        - iDisplaceYBy1);
	    Point position3 = new Point(currLocation.x - iDisplaceXBy2, currLocation.y
	    		+ iDisplaceYBy2);
	    Point position4 = new Point(currLocation.x + iDisplaceXBy2, currLocation.y
	    		- iDisplaceYBy2);
	    for (int i = 0; i < 20; i++) {
	      frame.setLocation(position1);
	      frame.setLocation(position2);
	      frame.setLocation(position3);
	      frame.setLocation(position4);
	    }
	    frame.setLocation(currLocation);
	  }
	}
