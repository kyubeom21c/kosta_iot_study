package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_ConfirmFormDelete2 extends JFrame {
public Popup_ConfirmFormDelete2(int num) {
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel(num +"�� ������ ���� �����Ͻðڽ��ϱ�?");
	lblNewLabel.setBounds(133, 10, 277, 15);
	getContentPane().add(lblNewLabel);
	
	JButton btnNewButton = new JButton("Ȯ ��");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new QuestionFormDAO().delete(num);
		}
	});
	btnNewButton.setBounds(116, 35, 94, 23);
	getContentPane().add(btnNewButton);
	
	JButton button = new JButton("���");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new QuestionFormDAO().selectAll();
		}
	});
	button.setBounds(247, 35, 82, 23);
	getContentPane().add(button);
	
	setTitle("���� �����Ͻðڽ��ϱ�?");
	setBounds(300, 400, 482, 115);
	setVisible(true);
}
}
