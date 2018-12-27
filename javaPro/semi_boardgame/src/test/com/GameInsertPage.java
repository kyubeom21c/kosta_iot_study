package test.com;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.GameDirDAO;
import test.com.model.GameDirDAOimpl;
import test.com.model.GameVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.awt.event.ActionEvent;

public class GameInsertPage extends JFrame {
	private JTextField tx_name;
	private JTextField tx_gameLevel;
	private JTextField tx_peopleCount;

	public GameInsertPage() {
		getContentPane().setLayout(new GridLayout(4, 2, 0, 0));

		JLabel name = new JLabel("게임 이름");
		getContentPane().add(name);

		tx_name = new JTextField();
		getContentPane().add(tx_name);
		tx_name.setColumns(10);

		JLabel gameLevel = new JLabel("난이도");
		getContentPane().add(gameLevel);

		tx_gameLevel = new JTextField();
		getContentPane().add(tx_gameLevel);
		tx_gameLevel.setColumns(10);

		JLabel peopleCount = new JLabel("게임 인원 수");
		getContentPane().add(peopleCount);
		
		tx_peopleCount = new JTextField();
		getContentPane().add(tx_peopleCount);
		tx_peopleCount.setColumns(10);

		JButton btn_insertOK = new JButton("게임 추가");
		btn_insertOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameDirDAO dao = new GameDirDAOimpl();
				GameVO vo = new GameVO();
				vo.setName(tx_name.getText());
				vo.setGameLevel(Integer.parseInt(tx_gameLevel.getText()));
				vo.setPeopleCount(Integer.parseInt(tx_peopleCount.getText()));
				int result = dao.insert(vo);
				new GameSelectAllPage(2018);
				dispose();
			}
		});
		getContentPane().add(btn_insertOK);

		JButton btn_selectAll = new JButton("게임 조회하기");
		btn_selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameSelectAllPage(2018);
			}
		});
		getContentPane().add(btn_selectAll);

		setTitle("GameInsertPage");
		setBounds(new Rectangle(500, 0, 250, 300));
		setVisible(true);
	}

}