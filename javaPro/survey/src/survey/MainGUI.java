package survey;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {
	public MainGUI(QuestionVO vo) {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("설문양식 만들기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreateFormGUI cf = new CreateFormGUI(vo);
			
			}
		});
		btnNewButton.setBounds(58, 91, 157, 122);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("설문조사 실시");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QuestionFormDAO().selectAll();
				new Popup_FormSelect();
				//까먹지 말고 설문 양식을 선택해주세요 팝업창 추가
			}
		});
		btnNewButton_1.setBounds(248, 91, 165, 122);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("설문 결과 보러가기(관리자 전용)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Popup_PwCheck();
			}
		});
		btnNewButton_2.setBounds(160, 312, 312, 23);
		getContentPane().add(btnNewButton_2);
	
	
	setTitle("설문조사 프로그램");
	setBounds(300, 300, 500, 400);
	setVisible(true);
	}
}
