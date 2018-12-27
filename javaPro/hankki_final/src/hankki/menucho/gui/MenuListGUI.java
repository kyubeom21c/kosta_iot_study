package hankki.menucho.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hankki.menucho.model.MenuChoiceVO;

public class MenuListGUI extends JFrame {

	String[][] datas;
	DefaultTableModel dm;
	JTable table;
	JScrollPane jscp;
	String[] columns = new String[] { "������", "����", "�޴��̸�", "�����ð�", "����" };

	public MenuListGUI() {
		// pan 2���ؼ� �����̳ʿ� ���̱�

		// 2.�����̳� + ���̾ƿ�
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		//JPanel jpn = new JPanel();
		//jpn.setLayout(new GridLayout(1, 1));

		// 3.������Ʈ �߰�
		dm = new DefaultTableModel(datas, columns);
		table = new JTable(dm);
		jscp = new JScrollPane(table);

		JButton btn_delete = new JButton("����");

		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
				jtableDelete();
			}
		});

		// 5.�����̳ʿ� �߰�
		//jpn.add(btn_delete);
		// con.add(jpn, "North");
		con.add(jscp, "Center");
		con.add(btn_delete, "South");

		// 1.
		setTitle("��ٱ���");
		setBounds(500, 0, 300, 300);
		// btn_delete.setEnabled(false);
		setVisible(true);
	}// end Menu

	public void jtableAdd(MenuChoiceVO vo) {

		int rowCnt = 0;
		String[][] temp;

		if (this.datas != null)
			rowCnt = this.datas.length;

		temp = this.datas;
		this.datas = new String[rowCnt + 1][columns.length];
		int count = 0;

		if (temp != null) {
			for (String[] x : temp) {

				datas[count] = new String[] { count + "", x[1], x[2], x[3], x[4] };
				count++;
			}
		}
		datas[count] = new String[] { count + "", vo.getKind(), vo.getName(), vo.getCookTm() + "", vo.getPrice() + "" };

		dm = new DefaultTableModel(datas, columns);
		table.setModel(dm);

	}

	public void jtableDelete() {

		String[][] temp;

		int index = table.getSelectedRow();
		if (index != -1) {
			temp = datas;
			datas = new String[temp.length - 1][columns.length];

			int count = 0;
			for (int i = 0; i < temp.length; i++) {
				if (i != index) {
					datas[count] = new String[] { count + "", temp[i][1], temp[i][2], temp[i][3], temp[i][4] };
					count++;
				}
			}
			dm = new DefaultTableModel(datas, columns);
			table.setModel(dm);
		}

	}

	public void setVisibleGUI(boolean flag) {
		setVisible(flag);
	}

	public String[][] getTable() {
		return this.datas;
	}

}
