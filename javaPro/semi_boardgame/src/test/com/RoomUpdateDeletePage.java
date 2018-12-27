package test.com;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.GameVO;
import test.com.model.RoomDirDAO;
import test.com.model.RoomDirDAOimpl;
import test.com.model.RoomUserDAO;
import test.com.model.RoomUserDAOimpl;
import test.com.model.RoomVO;

public class RoomUpdateDeletePage extends JFrame {
	private JTextField tx_name;
	private JTextField tx_gameLevel;
	private JTextField tx_peopleCount;

	public RoomUpdateDeletePage() {
		// TODO Auto-generated constructor stub
	}

	public RoomUpdateDeletePage(String num) {
		getContentPane().setLayout(new GridLayout(5, 2, 0, 0));

		RoomDirDAO dao = new RoomDirDAOimpl();
		RoomVO vo = new RoomVO();
		vo.setNum(Integer.parseInt(num));
		RoomVO vo2 = dao.selectOne(vo);

		JLabel jl_num = new JLabel("방 번호");
		getContentPane().add(jl_num);

		JLabel jl_num2 = new JLabel(num);
		getContentPane().add(jl_num2);

		JLabel time = new JLabel("이용시간");
		getContentPane().add(time);

		JLabel time2 = new JLabel(vo2.getTime() + "");
		getContentPane().add(time2);

		JLabel remain = new JLabel("이용여부");
		getContentPane().add(remain);

		JLabel remain2 = new JLabel(vo2.getRemain() + "");
		getContentPane().add(remain2);
		
		JLabel roomGame = new JLabel("선택게임");
		getContentPane().add(roomGame);

		JLabel roomGame1 = new JLabel(vo2.getRoomGame() + "");
		getContentPane().add(roomGame1);

		JButton btn_roomReset = new JButton("방 초기화");
		// 이용시간을 0, 이용여부를 0으로 수정
		btn_roomReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomUserDAO dao = new RoomUserDAOimpl();
				RoomVO vo = new RoomVO();
				vo.setNum(Integer.parseInt(num));
				vo.setTime(0);
				vo.setRemain(0);
				vo.setRoomGame(null);
				
				int result = dao.update(vo);
				
				if (result >= 1) { // update가 성공적일 때
					System.out.println("방의 이용시간을 초기화 했습니다.");
				} else {
					System.out.println("초기화 실패");
				}
				
				new RoomSelectAllPage(2018);
				dispose();
			}
		});
		getContentPane().add(btn_roomReset);

		JButton btn_roomDelete = new JButton("방 삭제");
		btn_roomDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomVO vo = new RoomVO();
				vo.setNum(Integer.parseInt(num));

				int result = dao.delete(vo);
				if (result >= 1) { // delete가 성공적일 때
					System.out.println("방 삭제에 성공했습니다.");
				} else if (result == 0) {
					System.out.println("방 삭제에 실패했습니다. 없는 방일 수 있습니다.");
				}
				
				new RoomSelectAllPage(2018);
				dispose();
			}
		});
		getContentPane().add(btn_roomDelete);

		setVisible(true);
		setBounds(new Rectangle(500, 0, 250, 300));
		setTitle("RoomUpdateDeletePage");
	}
}
