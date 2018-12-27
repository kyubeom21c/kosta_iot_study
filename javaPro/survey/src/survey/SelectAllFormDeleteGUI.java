package survey;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectAllFormDeleteGUI extends JFrame {
	public SelectAllFormDeleteGUI(List<QuestionVO> vos) {
		

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
				
				new Popup_ConfirmFormDelete2(Integer.parseInt(num));

			}
		});
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 484, 203);
		con.add(scrollPane);
		
		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QuestionFormDAO().selectAll();
				
			}
		});
		btnNewButton.setBounds(190, 213, 97, 39);
		getContentPane().add(btnNewButton);
		
		setTitle("몇번 설문지를 삭제하시겠습니까?");
		setBounds(300, 300, 500, 300);
		setVisible(true);
		
	}
}
