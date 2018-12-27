package test.com;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import test.com.model.GameDirDAO;
import test.com.model.GameDirDAOimpl;
import test.com.model.GameVO;

public class EventResultPage extends JFrame {

	public EventResultPage() {

	}

	public EventResultPage(int count) {
		getContentPane().setLayout(new GridLayout(3, 1));

		JLabel resultMsg = new JLabel("");
		JLabel resultMsg2 = new JLabel("");

		GameVO vo = new GameVO();
		GameDirDAO dao = new GameDirDAOimpl();
		List<GameVO> vos = dao.selectAll();

		Random r = new Random();
		int su = r.nextInt(vos.size()) + 1;
		vo.setNum(su);
		GameVO vo2 = dao.selectOne(vo);

		if (count == 1) {
			resultMsg.setText("축하합니다! 사탕 당첨!");
		} else if (count == 2) {
			resultMsg.setText("축하합니다! 음료수 당첨!");
		} else if (count == 3) {
			resultMsg.setText("축하합니다! 보드게임 당첨!");
			resultMsg2.setText(vo2.getName() + "게임 당첨!");
		} else if (count == 0) {
			resultMsg.setText("꽝입니다!");
		}

		getContentPane().add(resultMsg);
		getContentPane().add(resultMsg2);
		
		JButton btn_exit = new JButton("첫화면으로 돌아가기");
		btn_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Home();
				dispose();
				
			}
		});
		getContentPane().add(btn_exit);

		setBounds(500, 0, 300, 100);
		setTitle("이벤트 결과 화면");
		setVisible(true);
	} // end EventResultPage(int count)

}
