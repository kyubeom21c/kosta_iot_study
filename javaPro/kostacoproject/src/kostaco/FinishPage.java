package kostaco;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinishPage extends JFrame {
	
	public FinishPage() {
		Container con = getContentPane();
		con.setLayout(new GridLayout(2, 1));
		
		JPanel f = new JPanel();
		JLabel fin = new JLabel("결제가 완료되었습니다.");
		f.add(fin);
		
		
		
		JPanel f2 = new JPanel();
		JButton fin2 = new JButton("계속 쇼핑하기");
		fin2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomePage();
				dispose();
				
			}
		});
		f2.add(fin2);

		if(LoginPage.vo2.getId().equals("none")) {
			JButton btn_logout = new JButton("메인 화면으로");
			btn_logout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_logout");
					new MainPage();
					dispose();
				}
			});
			f2.add(btn_logout);
		} else {
			JButton btn_logout = new JButton("로그아웃");
			btn_logout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_logout");
					new MainPage();
					dispose();
				}
			});
			f2.add(btn_logout);
		}
		
		con.add(f);
		con.add(f2);
		
		
		setTitle("결제완료");
		setBounds(400, 350, 240, 200);
		setVisible(true);
	}

}
