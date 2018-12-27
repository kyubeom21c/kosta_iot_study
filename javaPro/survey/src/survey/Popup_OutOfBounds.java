package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_OutOfBounds extends JFrame {
	public Popup_OutOfBounds(QuestionVO vo) {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("20문항 이하로 설정해주세요..!");
		lblNewLabel.setBounds(131, 10, 195, 15);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("돌아가기.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CreateFormGUI(vo);
			}
		});
		btnNewButton.setBounds(120, 38, 149, 23);
		getContentPane().add(btnNewButton);

		setTitle("메인 화면으로 돌아갑니다.");
		setBounds(300, 400, 400, 109);
		setVisible(true);
	}
}
