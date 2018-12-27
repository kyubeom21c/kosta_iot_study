package survey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup_SelectToDelete extends JFrame {
public Popup_SelectToDelete() {
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("지우고자 하는 설문결과를 선택하세요.");
	lblNewLabel.setBounds(84, 10, 257, 15);
	getContentPane().add(lblNewLabel);
	
	JButton btnNewButton = new JButton("확 인");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	btnNewButton.setBounds(120, 38, 149, 23);
	getContentPane().add(btnNewButton);
	
	setTitle("안 내");
	setBounds(300, 400,400,109);
	setVisible(true);
	
}
}
