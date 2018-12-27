package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_NumberFormatEx extends JFrame {
	public Popup_NumberFormatEx() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("문제 갯수에 오류가있습니다.");
		lblNewLabel.setBounds(131, 10, 195, 15);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("메인 화면으로");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
			}
		});
		btnNewButton.setBounds(131, 35, 141, 23);
		getContentPane().add(btnNewButton);
		
		setTitle("메인 화면으로 돌아갑니다.");
		setBounds(300, 400,400,109);
		setVisible(true);
	}
}
