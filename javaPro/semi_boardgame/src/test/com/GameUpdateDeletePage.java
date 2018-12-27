package test.com;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.GameDirDAO;
import test.com.model.GameDirDAOimpl;
import test.com.model.GameVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameUpdateDeletePage extends JFrame {
	private JTextField tx_name;
	private JTextField tx_gameLevel;
	private JTextField tx_peopleCount;
	public GameUpdateDeletePage(String num) {
		getContentPane().setLayout(new GridLayout(5, 2, 0, 0));
		
		GameDirDAO dao = new GameDirDAOimpl();
		GameVO vo = new GameVO();
		vo.setNum(Integer.parseInt(num));
		GameVO vo2 = dao.selectOne(vo);
		
		JLabel Lnum = new JLabel("게임번호");
		getContentPane().add(Lnum);
		
		JLabel Lnum1 = new JLabel(num);
		getContentPane().add(Lnum1);
		
		
		JLabel name = new JLabel("바꿀 게임이름");
		getContentPane().add(name);
		tx_name = new JTextField(vo2.getName());
		getContentPane().add(tx_name);
		tx_name.setColumns(10);
		
		
		JLabel gameLevel = new JLabel("바꿀 게임 난이도");
		getContentPane().add(gameLevel);
		tx_gameLevel = new JTextField(Integer.toString(vo2.getGameLevel()));
		getContentPane().add(tx_gameLevel);
		tx_gameLevel.setColumns(10);
		
		
		JLabel peopleCount = new JLabel("바꿀 게임 인원 수");
		getContentPane().add(peopleCount);
		tx_peopleCount = new JTextField(Integer.toString(vo2.getPeopleCount()));
		getContentPane().add(tx_peopleCount);
		tx_peopleCount.setColumns(10);
		
		
		JButton btn_gameUpdate = new JButton("게임 수정");
		btn_gameUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameVO vo = new GameVO();
				vo.setNum(Integer.parseInt(num));
				vo.setName(tx_name.getText());
				vo.setGameLevel(Integer.parseInt(tx_gameLevel.getText()));
				vo.setPeopleCount(Integer.parseInt(tx_peopleCount.getText()));
				int result = dao.update(vo);
				if(result>=1) {
					dispose();
					new GameSelectAllPage(2018);
				}
			}
		});
		getContentPane().add(btn_gameUpdate);
		
		JButton btn_gameDelete = new JButton("게임 삭제");
		btn_gameDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameVO vo = new GameVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				if(result > 0) {
					dispose();
					new GameSelectAllPage(2018);
				}
			}
		});
		getContentPane().add(btn_gameDelete);

		setVisible(true);
		setBounds(new Rectangle(500, 0, 250, 300));
		setTitle("GameUpdatePage");
		
		
		
	}

}
