package kostaco;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ManagePage extends JFrame{

	public ManagePage() {
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btn_main = new JButton("메인으로");
		btn_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_main");
				new MainPage();

				dispose();
			}
		});
		con.add(btn_main);
		
		JButton btn_product = new JButton("상품 관리");
		btn_product.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_product");
				new ManageProductPage();
				dispose();
			}
		});
		con.add(btn_product);
		
		JButton btn_member = new JButton("회원 관리");
		btn_member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_member");
				new ManageMemberPage();
				dispose();
			}
		});
		con.add(btn_member);
		
		setTitle("ManagePage");
		setBounds(200, 0, 500, 500);
		setVisible(true);
	}
	
}
