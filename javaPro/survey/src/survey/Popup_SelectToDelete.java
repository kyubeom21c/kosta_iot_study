package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_SelectToDelete extends JFrame {
public Popup_SelectToDelete() {
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("������� �ϴ� ��������� �����ϼ���.");
	lblNewLabel.setBounds(84, 10, 257, 15);
	getContentPane().add(lblNewLabel);
	
	JButton btnNewButton = new JButton("Ȯ ��");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	btnNewButton.setBounds(120, 38, 149, 23);
	getContentPane().add(btnNewButton);
	
	setTitle("�� ��");
	setBounds(300, 400,400,109);
	setVisible(true);
	
}
}
