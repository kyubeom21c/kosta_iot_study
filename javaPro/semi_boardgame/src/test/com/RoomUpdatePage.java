package test.com;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.RoomDirDAO;
import test.com.model.RoomDirDAOimpl;
import test.com.model.RoomUserDAO;
import test.com.model.RoomUserDAOimpl;
import test.com.model.RoomVO;

public class RoomUpdatePage extends JFrame {

	public RoomUpdatePage() {
		// TODO Auto-generated constructor stub
	} // end RoomUpdatePage()
	
	public RoomUpdatePage(String num) {
		
		getContentPane().setLayout(new GridLayout(3, 2, 0, 0));

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
		
		JTextField time2 = new JTextField(vo2.getTime());
		getContentPane().add(time2);

		JLabel blank = new JLabel("이용시간 입력 후");
		getContentPane().add(blank);

		JButton btn_timeSet = new JButton("게임선택하기"); 
		// 이용시간을 넣은 시간으로 수정
		btn_timeSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RoomUserDAO dao = new RoomUserDAOimpl();
				RoomVO vo = new RoomVO();
				vo.setNum(Integer.parseInt(num));
				vo.setTime(Integer.parseInt(time2.getText()));

				String remain_txt = "";
				if (vo.getTime() >= 1) { // 이용시간이 1시간 이상이면
					vo.setRemain(1); // 이용중:1으로 세팅
					remain_txt = "이용중";
					
				} else if (vo.getTime() == 0) { // 이용시간이 0시간일때
					vo.setRemain(0); // 이용안함:0으로 세팅
					remain_txt = "이용안함";
				}
				
				int result = dao.update(vo);
				
				if (result >= 1) { // update가 성공적일 때
					System.out.println("방의 이용시간을 수정했습니다.");
				} else {
					System.out.println("수정 실패");
				}
				
//				new MsgPageRoom(vo.getNum(),vo.getTime(),remain_txt);
				new GameSelectAllPage(vo);
				
				dispose();
				
			}
		});
		getContentPane().add(btn_timeSet);
		

//		JButton btn_gotoGameSelect = new JButton("게임선택하기");
//		//게임 선택하러가기 버튼
//		btn_gotoGameSelect.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new GameSelectAllPage(vo);
//			}
//		});
//		getContentPane().add(btn_gotoGameSelect);


		setBounds(new Rectangle(500, 0, 300, 300));
		setTitle("RoomUpdatePage");
		setVisible(true);
		
	} // end RoomUpdatePage(String num)
	
}
