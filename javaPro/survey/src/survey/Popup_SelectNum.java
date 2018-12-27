package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_SelectNum extends JFrame {

	public Popup_SelectNum() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("삭제할 설문지를 선택해주세요..!");
		lblNewLabel.setBounds(131, 10, 195, 15);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(120, 38, 149, 23);
		getContentPane().add(btnNewButton);

		setTitle("설문지 선택");
		setBounds(300, 400, 400, 109);
		setVisible(true);

	}
}
