package test.com;

import javax.swing.JFrame;

import test.com.model.RoomDirDAOimpl;
import test.com.model.RoomUserDAO;
import test.com.model.RoomUserDAOimpl;
import test.com.model.RoomVO;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class MsgPageRoom extends JFrame {
	
	

	public MsgPageRoom(int num, int time, String remain) {
		RoomUserDAO dao = new RoomUserDAOimpl();
		RoomVO vo = new RoomVO();
		
		
		setTitle("확인창");
		setBounds(750, 300, 250, 200);
		getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel num1 = new JLabel("선택한 방 번호");
		getContentPane().add(num1);
		
		JLabel num2 = new JLabel(num+"");
		getContentPane().add(num2);
		
		JLabel time1 = new JLabel("이용시간");
		getContentPane().add(time1);
		
		JLabel time2 = new JLabel(time+"");
		getContentPane().add(time2);
		
		JLabel remain1 = new JLabel("이용여부");
		getContentPane().add(remain1);
		
		JLabel blank = new JLabel("");
		getContentPane().add(blank);
		
		
		
		
		
		JLabel remain2 = new JLabel(remain);
		getContentPane().add(remain2);
		setVisible(true);
	}
	
}
