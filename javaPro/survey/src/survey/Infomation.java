package survey;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Infomation extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Infomation(QuestionVO vo) {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(254, 63, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 94, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(254, 125, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("성별");
		lblNewLabel.setBounds(112, 128, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("나이");
		lblNewLabel_1.setBounds(112, 97, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(112, 66, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("설문작성 시작하기..!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//설문 시작하기 버튼 누르면!
				vo.setName(textField_2.getText());	
				vo.setAge(textField_1.getText());
				vo.setGender(textField.getText());
				setVisible(false);
				new QuestionPage(vo);
			}
		});
		btnNewButton.setBounds(156, 229, 197, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("초기화면");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testMain.main(new String[1]);
			}
		});
		btnNewButton_1.setBounds(12, 229, 105, 23);
		getContentPane().add(btnNewButton_1);
		
		setTitle("개인정보를 입력해주세요 (공란 가능)");
		setBounds(300, 300, 500, 300);
		setVisible(true);
	}
}
