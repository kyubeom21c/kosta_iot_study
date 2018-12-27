package survey;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LastSelectAllGUI extends JFrame{
	public LastSelectAllGUI(List<QuestionVO> vos) {
		
		Container con = getContentPane();

		String[] coulunms = { "번호", "이름", "나이",
							  "성별","설문 주제", "문항1", "2", "3",
							  "4", "5", "6", "7",
							  "8", "9", "10", "11",
							  "12", "13", "14", "15",
								"16", "17", "18", "19",
								"20"};

		String[][] datas = new String[vos.size()][coulunms.length];

		int count = 0;
		for (QuestionVO vo : vos) {
			datas[count] = new String[] { vo.getNum() + "", vo.getName() ,vo.getAge(),vo.getGender(),vo.getTitle(),"","","","","","","","","","","","","","","","","","","","" };
			for(int i = 0 ; i < vo.answers.size() ; i++) {
				datas[count][i+5] = vo.answers.get(i);
			}
			count++;
		}

		DefaultTableModel dm = new DefaultTableModel(datas, coulunms);
		JTable table = new JTable(dm);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//테이블 로우 반환 표클릭
				String num = datas[table.getSelectedRow()][0];
				setVisible(false);
				new Popup_ConfirmDelete(Integer.parseInt(num));

			}
		});
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 984, 185);
		con.add(scrollPane);
		
		JButton btnNewButton = new JButton("메인으로 돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testMain.main(new String[1]);
			}
		});
		btnNewButton.setBounds(414, 195, 144, 55);
		getContentPane().add(btnNewButton);

		setTitle("작성된 설문지 답변목록");
		setBounds(300, 300, 1000, 300);
		setVisible(true);
		new Popup_SelectToDelete();
	
	}
}
