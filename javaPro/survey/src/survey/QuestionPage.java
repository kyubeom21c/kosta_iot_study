package survey;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionPage extends JFrame {
	public QuestionPage(QuestionVO vo) {
		int i = vo.count;
		getContentPane().setLayout(null);

		TextArea textArea = new TextArea(vo.qnaL.get(i)[0]);
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 567, 128);
		getContentPane().add(textArea);

		JRadioButton rdbtnNewRadioButton = new JRadioButton(vo.qnaL.get(i)[1]);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vo.qnaL.get(i)[5] = "1";
				vo.count++;
				setVisible(false);
				
				if (vo.count == vo.questionNum)
					new AnswerDAO().insert(vo);
				else
					new QuestionPage(vo);

			}
		});
		rdbtnNewRadioButton.setBounds(10, 134, 544, 23);
		getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(vo.qnaL.get(i)[2]);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				vo.qnaL.get(i)[5] = "2";
				vo.count++;
				setVisible(false);
				
				if (vo.count == vo.questionNum)
					new AnswerDAO().insert(vo);
				else
				new QuestionPage(vo);

			}
		});
		rdbtnNewRadioButton_1.setBounds(10, 159, 544, 23);
		getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(vo.qnaL.get(i)[3]);

		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 세번째 버튼 이벤트
				vo.qnaL.get(i)[5] = "3";
				vo.count++;
				setVisible(false);
				
				if (vo.count == vo.questionNum)
					new AnswerDAO().insert(vo);
				else
				new QuestionPage(vo);

			}
		});
		rdbtnNewRadioButton_2.setBounds(10, 184, 544, 23);
		getContentPane().add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(vo.qnaL.get(i)[4]);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 네번째 이벤트
				vo.qnaL.get(i)[5] = "4";
				vo.count++;
				setVisible(false);
				
				if (vo.count == vo.questionNum)
					new AnswerDAO().insert(vo);
				else
				new QuestionPage(vo);
			}
		});
		rdbtnNewRadioButton_3.setBounds(10, 209, 544, 23);
		getContentPane().add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("이전 문항으로 돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vo.count != 0) {
					vo.count--;
					setVisible(false);
					new QuestionPage(vo);
				}else {
					new Popup_ThisIsFirstPage();
				}
			}
		});
		btnNewButton.setBounds(355, 237, 210, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("초기화면으로");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testMain.main(new String[1]);
			}
		});
		btnNewButton_1.setBounds(10, 237, 130, 23);
		getContentPane().add(btnNewButton_1);

		setTitle((vo.count+1) +" 번째 문항");
		setBounds(400, 100, 593, 308);
		setVisible(true);
	} // while문 루프 끝 vo.qnaL.get(i)[5] 까지 세팅 완료...!

}
