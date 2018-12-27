package test.com;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Test02SelectAllPage extends JFrame {
	private JTable table;

	
	public Test02SelectAllPage() {
		
		setVisible(true);
		setTitle("SelectAllPage");
		setBounds(new Rectangle(500, 0, 500, 300));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblTop = new JLabel("North");
		getContentPane().add(lblTop, BorderLayout.NORTH);
		
		JButton btnSouth = new JButton("South");
		getContentPane().add(btnSouth, BorderLayout.SOUTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
}
