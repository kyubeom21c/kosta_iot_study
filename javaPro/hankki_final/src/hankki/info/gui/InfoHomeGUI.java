package hankki.info.gui;

import java.awt.BorderLayout;
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

import hankki.info.model.InfoDAO;
import hankki.info.model.InfoDAOImpl;
import hankki.info.model.InfoVO;
import hankki.menucho.gui.MenuChoiceGUI;
import hankki.info.gui.InfoUpdateGUI;

public class InfoHomeGUI extends JFrame {

	String[][] datas;
	JTable table;
	
	public InfoHomeGUI() {

		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		String[] columns = new String[] { "시퀀스", "주문번호", "주소", "전화번호", "상태" };
		InfoDAO dao = new InfoDAOImpl();
		List<InfoVO> vos = dao.selectAll();
		System.out.println("vos size:" + vos.size());

		datas = new String[vos.size()][columns.length];

		int count = 0;
		for (InfoVO vo : vos) {

			datas[count] = new String[] { vo.getNum() + "", vo.getOrderNum(), vo.getAddress(), vo.getTel(),
					vo.getStat() };
			count++;
		}

		DefaultTableModel dm = new DefaultTableModel(datas, columns);
		table = new JTable(dm);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked...");
				String orderNum = datas[table.getSelectedRow()][1];
				System.out.println(orderNum);
				new InfoUpdateGUI(orderNum);
				
			}
		});

		JButton jb_refresh = new JButton("새로고침");
		jb_refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<InfoVO> vos = dao.selectAll();
				datas = new String[vos.size()][columns.length];

				int count = 0;
				for (InfoVO vo : vos) {

					datas[count] = new String[] { vo.getNum() + "", vo.getOrderNum(), vo.getAddress(), vo.getTel(),
							vo.getStat() };
					count++;
				}

				DefaultTableModel dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});
		
		con.add(new JScrollPane(table),"Center");
		con.add(jb_refresh,"South");
		setTitle("Info");
		setBounds(100, 200, 400, 400);
		setVisible(true);

	}

}
