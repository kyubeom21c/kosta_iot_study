package kostaco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manage.model.ManageVO;
import member.model.MemberDAO;
import member.model.MemberDAOimpl;
import member.model.MemberVO;

public class ManageMemberPage extends JFrame {

	public ManageMemberPage() {

		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		MemberDAO dao = new MemberDAOimpl();
		List<MemberVO> vos = dao.selectAll();

		String[] columns = new String[] { "NAME", "ID", "ADDRESS", "TEL"};

		String[][] datas = new String[vos.size()][columns.length];
		
		int count = 0;
		for (MemberVO vo : vos) {
			datas[count] = new String[] {
					vo.getName(),
					vo.getId(),
					vo.getAddress(),
					vo.getTel()
			};
			count++;
		}
		
		DefaultTableModel dm = new DefaultTableModel(datas, columns);
		con.setLayout(new BorderLayout(0,0));
		
		JPanel table = new JPanel();
		con.add(table, BorderLayout.CENTER);
		JTable member_table = new JTable(dm);
		
		JScrollPane scrollPane = new JScrollPane(member_table);
		table.add(scrollPane);

		JPanel btn = new JPanel();
		con.add(btn, BorderLayout.SOUTH);
		
		JButton btn_ok = new JButton("»Æ¿Œ");
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_ok");
				new ManagePage();
				dispose();
			}
		});
		btn.add(btn_ok);		
		
		setTitle("ManageMemberPage");
		setBounds(200, 0, 500, 500);
		setVisible(true);

	}

}
