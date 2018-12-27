package test.com;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import test.com.model.RoomVO;

public class ResultPage extends JFrame {

	public ResultPage() {
	} // end Resultpage()

	public ResultPage(RoomVO vo) {
		setTitle("확인창");
		setBounds(500, 0, 400, 300);
		getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel num = new JLabel("선택한 방 번호");
		getContentPane().add(num);
		
		JLabel userNum = new JLabel(vo.getNum()+"");
		getContentPane().add(userNum);
		
		JLabel time = new JLabel("이용시간");
		getContentPane().add(time);
		
		Calendar cal = Calendar.getInstance();
		
		int exitTime = (cal.get(Calendar.HOUR_OF_DAY)+vo.getTime());
		String str="";
		if(exitTime > 24) {
			exitTime = 24;
			str = cal.get(Calendar.HOUR_OF_DAY)+"시"
					+ cal.get(Calendar.MINUTE)+"분~"
					+ exitTime+"시 00분까지";
		} else {
			str = cal.get(Calendar.HOUR_OF_DAY)+"시"
					+ cal.get(Calendar.MINUTE)+"분~"
					+ exitTime+"시"
					+ cal.get(Calendar.MINUTE)+"분까지";
		}
		
		JLabel userTime = new JLabel(str);
		getContentPane().add(userTime);
		
		
		
		JLabel game = new JLabel("선택게임");
		getContentPane().add(game);
		
		JLabel userGame = new JLabel(vo.getRoomGame());
		getContentPane().add(userGame);
		
		JButton btn_exit = new JButton("첫화면으로");
		btn_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home();
				dispose();
				
			}
		});
		getContentPane().add(btn_exit);
		
		JButton btn_event = new JButton("로또이벤트하기");
		btn_event.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EventPage();
				dispose();
				
			}
		});
		getContentPane().add(btn_event);
		
		setVisible(true);
		
	} // end ResultPage(RoomVO vo)
}
