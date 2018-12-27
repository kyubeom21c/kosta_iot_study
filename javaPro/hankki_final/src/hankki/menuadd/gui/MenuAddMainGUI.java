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
		// 2. 컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(3,1));
		// 3. 컴포넌트
		JButton btn_insert = new JButton("메뉴 추가");
		
		// 4. 이벤트추가
		btn_insert.addActionListener(new ActionListener() {//이벤트가 발생할때 감지기능.
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_insert");
				new MenuAddGUI();
				
			}
		});
		
		JButton btn_selectAll = new JButton("전체보기/수정,삭제");
		btn_selectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_selectAll");
				new MenuAddSelectGUI();
			}
		});
		
		JButton btn_order = new JButton("주문관리");
		btn_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_order");
				new InfoHomeGUI();
			}
		});
		
		// 5. 컴포넌트를 컨테이너에 추가.
		con.add(btn_insert);
		con.add(btn_selectAll);
		con.add(btn_order);
		
		
		
		// 1.
		setTitle("HOME");
		setBounds(0,0,250,300);
		setVisible(true);
		
	}

}
