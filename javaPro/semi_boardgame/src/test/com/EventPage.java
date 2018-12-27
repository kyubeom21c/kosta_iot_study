package test.com;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventPage extends JFrame {
	public EventPage() {
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));

		Random r = new Random();
		Set<Integer> s = new HashSet<>();
		Set<Integer> s1 = new HashSet<>();
		while (s.size() < 3) {
			int su1 = r.nextInt(5) + 1;
			s.add(su1);
		}
		while (s1.size() < 3) {
			int su2 = r.nextInt(5) + 1;
			s1.add(su2);
		}

		int[] sus1 = new int[s.size()];
		int[] sus2 = new int[s1.size()];

		int count1 = 0;
		for (Integer x : s) {
			sus1[count1] = x;
			count1++;
			System.out.print(x + " ");
		}
		System.out.println();

		int count2 = 0;
		for (Integer x : s1) {
			sus2[count2] = x;
			count2++;
			System.out.print(x + " ");// 손님 sus2
		}
		System.out.println();

		Arrays.sort(sus1);
		Arrays.sort(sus2);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 5, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("로또번호 : ");
		panel.add(lblNewLabel_1);

		JLabel sus11 = new JLabel(sus1[0] + "");
		panel.add(sus11);

		JLabel sus12 = new JLabel(sus1[1] + "");
		panel.add(sus12);

		JLabel sus13 = new JLabel(sus1[2] + "");
		panel.add(sus13);

		JLabel blank = new JLabel("");
		panel.add(blank);

		JLabel lblNewLabel_5 = new JLabel("손님번호 : ");
		panel.add(lblNewLabel_5);

		JLabel sus21 = new JLabel("");

		JLabel sus22 = new JLabel("");

		JLabel sus23 = new JLabel("");

		JButton btnNewButton_1 = new JButton("추첨 ");
		JButton btnNewButton = new JButton("결과확인");

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sus21.setText(sus2[0] + "");

				sus22.setText(sus2[1] + "");

				sus23.setText(sus2[2] + "");

				
				// 추첨버튼을 누른 후에 결과확인 버튼을 누를 수 있도록 함
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						int count = 0;
						for (int j = 0; j < sus2.length; j++) {
							for (int i = 0; i < sus1.length; i++) {
								if (sus1[i] == sus2[j]) {
									count++;
								}
							}
						}

						String str = "";
						if (count == 1) {
							str = "1개 일치!";
							System.out.println(str);
							JOptionPane.showMessageDialog(null, str, "이벤트 당첨 결과", JOptionPane.PLAIN_MESSAGE);
						} else if (count == 2) {
							str = "2개 일치!";
							System.out.println(str);
							JOptionPane.showMessageDialog(null, str, "이벤트 당첨 결과", JOptionPane.PLAIN_MESSAGE);
						} else if (count == 3) {
							str = "3개 일치!";
							System.out.println(str);
							JOptionPane.showMessageDialog(null, str, "이벤트 당첨 결과", JOptionPane.PLAIN_MESSAGE);
							
						} else if (count == 0) {
							str = "꽝! ㅠㅠ 일치하는 것이 없습니다";
							System.out.println("");
							JOptionPane.showMessageDialog(null, str, "이벤트 당첨 결과", JOptionPane.ERROR_MESSAGE);
						}
						
						new EventResultPage(count);
						dispose();
					}
				});
			}
		});

		panel.add(sus21);
		panel.add(sus22);
		panel.add(sus23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("<1개 일치 - 사탕    /   2개 일치 - 음료수    /   3개 일치 - 보드게임(랜덤) 증정>");
		getContentPane().add(lblNewLabel);

		getContentPane().add(btnNewButton);

		setVisible(true);
		setBounds(new Rectangle(500, 0, 450, 300));
		setTitle("EventPage");
	}

}
