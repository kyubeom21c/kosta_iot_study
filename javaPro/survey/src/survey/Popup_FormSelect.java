package survey;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class Popup_FormSelect extends JFrame {
	public Popup_FormSelect() {
		setBounds(new Rectangle(350, 350, 200, 200));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Ȯ ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//�̺�Ʈ
				setVisible(false);
				
			
			}
		});
		btnNewButton.setBounds(148, 75, 157, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("�ǽ��ϰ��� �ϴ� ��������� �������ּ���.");
		lblNewLabel.setBounds(97, 31, 267, 26);
		getContentPane().add(lblNewLabel);
	
	
		setBounds(300, 400, 500, 150);
		setVisible(true);
	}
}
