package survey;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popup_wrongpw extends JFrame {
	public Popup_wrongpw() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�߸��� �н������Դϴ�.");
		lblNewLabel.setBounds(161, 10, 277, 15);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ȯ ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
			}
		});
		btnNewButton.setBounds(182, 35, 97, 23);
		getContentPane().add(btnNewButton);
		
		setTitle("Wrong Password..!");
		setBounds(300, 400, 500, 101);
		setVisible(true);
	}

}
