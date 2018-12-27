package survey;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popup_sugo extends JFrame {
	public Popup_sugo() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("설문이 끝났습니다..!");
		lblNewLabel.setBounds(131, 10, 195, 15);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("메인 화면으로");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
			}
		});
		btnNewButton.setBounds(120, 38, 149, 23);
		getContentPane().add(btnNewButton);
		
		setTitle("메인 화면으로 돌아갑니다.");
		setBounds(300, 400,400,109);
		setVisible(true);
	}
	
}
