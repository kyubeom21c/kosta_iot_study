package kostaco;

import java.awt.Container;
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

import manage.model.ManageDAO;
import manage.model.ManageDAOimpl;
import manage.model.ManageVO;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ManageProductPage extends JFrame {

	public ManageProductPage() {
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		ManageDAO dao = new ManageDAOimpl();
		List<ManageVO> vos = dao.selectAll();
		
		String[] columns = new String[] {"NAME", "PRICE", "AMOUNT"};
		
		String[][] datas = new String[vos.size()][columns.length];
		
		int count = 0;
		for (ManageVO vo : vos) {
			datas[count] = new String[] {
				vo.getName(),
				vo.getPrice(),
				vo.getAmount()+""
			};
			count++;
		}
		
		DefaultTableModel dm = new DefaultTableModel(datas, columns);
		con.setLayout(new BorderLayout(0, 0));
		
		JPanel table = new JPanel();
		con.add(table, BorderLayout.CENTER);
		JTable kostaco_table = new JTable(dm);
		
		kostaco_table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouse clicked");
				String name = datas[kostaco_table.getSelectedRow()][0];
				
				System.out.println(name);
				new UpdatePage(name);
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(kostaco_table);
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
		
		setTitle("ManageProductPage");
		setBounds(200, 0, 500, 500);
		setVisible(true);
	}

}
