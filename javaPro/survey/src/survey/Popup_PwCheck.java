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
		
		JLabel label = new JLabel("������ ��й�ȣ�� �Է����ּ���");
		label.setBounds(132, 10, 322, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(12, 35, 460, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("��й�ȣ �Է�");
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
	
		setTitle("������ ��ȣ�� �Է����ּ���");
		setBounds(300, 400, 500, 150);
		setVisible(true);
	}
}
