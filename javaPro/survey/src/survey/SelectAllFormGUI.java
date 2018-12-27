package survey;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class SelectAllFormGUI extends JFrame {
	private JTable table;

	public SelectAllFormGUI(List<QuestionVO> vos) {

		Container con = getContentPane();

		String[] coulunms = { "번호", "제목", "요약", "질문갯수" };

		String[][] datas = new String[vos.size()][coulunms.length];

		int count = 0;
		for (QuestionVO vo : vos) {
			datas[count] = new String[] { vo.getNum() + "", vo.getTitle(), vo.getSummary(), vo.questionNum + "" };
			count++;
		}

		DefaultTableModel dm = new DefaultTableModel(datas, coulunms);
		JTable table = new JTable(dm);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String num = datas[table.getSelectedRow()][0];
				setVisible(false);
				new QuestionFormDAO().selectOne(Integer.parseInt(num));

			}
		});
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 484, 131);
		con.add(scrollPane);

		JButton btnNewButton = new JButton("메인 화면");
		btnNewButton.setBounds(12, 141, 222, 111);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("양식 삭제");
		btnNewButton_1.setBounds(246, 141, 226, 111);
		getContentPane().add(btnNewButton_1);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new testMain().main(new String[1]);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			//지우기 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SelectAllFormDeleteGUI(vos);
				new Popup_SelectNum();
			}
		});

		setTitle("설문지를 선택하세요...!");
		setBounds(300, 300, 500, 300);
		setVisible(true);

	}
}
