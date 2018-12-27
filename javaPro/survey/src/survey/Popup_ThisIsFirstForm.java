package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_ThisIsFirstForm extends JFrame {
	public Popup_ThisIsFirstForm() {

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("첫번째 페이지입니다.");
		lblNewLabel.setBounds(131, 10, 195, 15);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("확 인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(120, 38, 149, 23);
		getContentPane().add(btnNewButton);

		setTitle("첫번째 페이지 입니다.");
		setBounds(300, 400, 400, 109);
		setVisible(true);

	}
}
