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
		
		JButton btnNewButton = new JButton("확 인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//이벤트
				setVisible(false);
				
			
			}
		});
		btnNewButton.setBounds(148, 75, 157, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("실시하고자 하는 설문양식을 선택해주세요.");
		lblNewLabel.setBounds(97, 31, 267, 26);
		getContentPane().add(lblNewLabel);
	
	
		setBounds(300, 400, 500, 150);
		setVisible(true);
	}
}
