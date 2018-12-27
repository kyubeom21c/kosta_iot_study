package survey;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popup_PwCheck extends JFrame {
	private JTextField textField;
	public Popup_PwCheck() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("관리자 비밀번호를 입력해주세요");
		label.setBounds(132, 10, 322, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(12, 35, 460, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("비밀번호 입력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if(textField.getText().equals("hi123456"))
					new AnswerDAO().selectAll();
				else
					new Popup_wrongpw();
			}
		});
		btnNewButton.setBounds(116, 66, 217, 23);
		getContentPane().add(btnNewButton);
	
		setTitle("관리자 번호를 입력해주세요");
		setBounds(300, 400, 500, 150);
		setVisible(true);
	}
}
