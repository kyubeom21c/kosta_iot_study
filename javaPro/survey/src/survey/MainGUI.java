package survey;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {
	public MainGUI(QuestionVO vo) {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("������� �����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreateFormGUI cf = new CreateFormGUI(vo);
			
			}
		});
		btnNewButton.setBounds(58, 91, 157, 122);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�������� �ǽ�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QuestionFormDAO().selectAll();
				new Popup_FormSelect();
				//����� ���� ���� ����� �������ּ��� �˾�â �߰�
			}
		});
		btnNewButton_1.setBounds(248, 91, 165, 122);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("���� ��� ��������(������ ����)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Popup_PwCheck();
			}
		});
		btnNewButton_2.setBounds(160, 312, 312, 23);
		getContentPane().add(btnNewButton_2);
	
	
	setTitle("�������� ���α׷�");
	setBounds(300, 300, 500, 400);
	setVisible(true);
	}
}
