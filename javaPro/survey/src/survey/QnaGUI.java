package survey;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import javax.swing.JScrollPane;

public class QnaGUI extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public QnaGUI(QuestionVO vo) {

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel((vo.count+1)+" 번째 질문 내용을 입력하세요 :");
		lblNewLabel.setBounds(12, 20, 189, 57);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("1번 보기를 입력하시오");
		lblNewLabel_1.setBounds(22, 166, 135, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("2번 보기를 입력하시오");
		lblNewLabel_2.setBounds(22, 191, 135, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("3번 보기를 입력하시오");
		lblNewLabel_3.setBounds(22, 216, 135, 15);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("4번 보기를 입력하시오");
		lblNewLabel_4.setBounds(22, 241, 135, 15);
		getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 10, 423, 137);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		textField_1 = new JTextField();
		textField_1.setBounds(213, 160, 423, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(213, 188, 423, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(213, 210, 423, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(213, 238, 423, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("작성완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vo.qnaL.get(vo.count)[0] = textArea.getText();
				vo.qnaL.get(vo.count)[1] = textField_1.getText();
				vo.qnaL.get(vo.count)[2] = textField_2.getText();
				vo.qnaL.get(vo.count)[3] = textField_3.getText();
				vo.qnaL.get(vo.count)[4] = textField_4.getText();

				vo.count++;
				setVisible(false);
				if (vo.count == vo.questionNum) {
					vo.count = 0; // QuestionPage 에서 재활용하기 위해서 0으로 다시 초기화
					new QuestionFormDAO().insert(vo);
					new QuestionFormDAO().selectAll();
					new Popup_FormSelect();
				} else {
					new QnaGUI(vo);
				}
			}

		});
		btnNewButton.setBounds(567, 266, 91, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("이전문제 다시 작성하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vo.count != 0) {
				vo.count--;
				setVisible(false);
				new QnaGUI(vo);
				}else {
					new Popup_ThisIsFirstForm();
				}
				
			}
		});
		btnNewButton_1.setBounds(12, 266, 246, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("메인으로");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
				
			}
		});
		btnNewButton_2.setBounds(334, 269, 97, 23);
		getContentPane().add(btnNewButton_2);

		setTitle("QNA 작성");
		setBounds(300, 300, 686, 334);
		setVisible(true);

	}
}
