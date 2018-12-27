package survey;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateFormGUI extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public CreateFormGUI(QuestionVO vo) {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("������ ����� ������ �Է��Ͻÿ�");
		lblNewLabel.setBounds(12, 10, 225, 49);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�Ұ����� �Է��Ͻÿ�");
		lblNewLabel_1.setBounds(12, 58, 225, 63);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("������ � ������Դϱ�?");
		lblNewLabel_2.setBounds(12, 143, 162, 58);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(242, 15, 226, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(242, 64, 226, 52);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(242, 148, 226, 49);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnFghj = new JButton("�ۼ��Ϸ�");
		btnFghj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vo.setTitle(textField.getText());
				vo.setSummary(textField_1.getText());
				
				try {
					if((Integer.parseInt(textField_2.getText()) > 20)){
						setVisible(false);
						new Popup_OutOfBounds(vo);
						return;
					}else {
						vo.questionNum = Integer.parseInt(textField_2.getText());
					}
					
					
				} catch (Exception e) {
					setVisible(false);
					new Popup_NumberFormatEx();
					return;
				}
				
				for(int i = 0 ; i < vo.questionNum ; i++) {
					vo.qnaL.add(new String[6]);
				}
				setVisible(false);
				new QnaGUI(vo); 
			
			}
		});
		btnFghj.setBounds(377, 230, 91, 23);
		getContentPane().add(btnFghj);
		
		JButton btnNewButton = new JButton("�ڷΰ���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
			}
		});
		btnNewButton.setBounds(12, 230, 97, 23);
		getContentPane().add(btnNewButton);
		
		setTitle("������ �ۼ�");
		setBounds(300, 300, 496, 300);
		setVisible(true);
		
	}
}
