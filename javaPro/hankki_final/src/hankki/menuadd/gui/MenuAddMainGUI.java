package hankki.menuadd.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import hankki.info.gui.InfoHomeGUI;

public class MenuAddMainGUI extends JFrame {
	public MenuAddMainGUI() {
		// 2. �����̳� + ���̾ƿ�
		Container con = getContentPane();
		con.setLayout(new GridLayout(3,1));
		// 3. ������Ʈ
		JButton btn_insert = new JButton("�޴� �߰�");
		
		// 4. �̺�Ʈ�߰�
		btn_insert.addActionListener(new ActionListener() {//�̺�Ʈ�� �߻��Ҷ� �������.
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_insert");
				new MenuAddGUI();
				
			}
		});
		
		JButton btn_selectAll = new JButton("��ü����/����,����");
		btn_selectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_selectAll");
				new MenuAddSelectGUI();
			}
		});
		
		JButton btn_order = new JButton("�ֹ�����");
		btn_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_order");
				new InfoHomeGUI();
			}
		});
		
		// 5. ������Ʈ�� �����̳ʿ� �߰�.
		con.add(btn_insert);
		con.add(btn_selectAll);
		con.add(btn_order);
		
		
		
		// 1.
		setTitle("HOME");
		setBounds(0,0,250,300);
		setVisible(true);
		
	}

}
