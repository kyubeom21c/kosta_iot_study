package survey;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popup_sugo extends JFrame {
	public Popup_sugo() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("������ �������ϴ�..!");
		lblNewLabel.setBounds(131, 10, 195, 15);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("���� ȭ������");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
			}
		});
		btnNewButton.setBounds(120, 38, 149, 23);
		getContentPane().add(btnNewButton);
		
		setTitle("���� ȭ������ ���ư��ϴ�.");
		setBounds(300, 400,400,109);
		setVisible(true);
	}
	
}
