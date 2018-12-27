package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test01Home extends JFrame {
	
	public Test01Home() {
		
		//2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(2, 1));
		
		
		//4.이벤트 처리
		JButton btn_insert = new JButton("goto insert");
		btn_insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_insert");
				new InsertPage();
			}
		});
		
		JButton btn_selectAll = new JButton("goto selectAll");
		btn_selectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_selectAll");
				new SelectAllPage();
			}
		});
		
		//3.컴포넌트 추가
		con.add(btn_insert);
		con.add(btn_selectAll);
		
		//1.
		setTitle("HOME");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}//end Test01Home()

}
