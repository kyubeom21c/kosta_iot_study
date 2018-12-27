package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MsgPageFindPw extends JFrame {

	
	public MsgPageFindPw(String text) {
		// TODO Auto-generated constructor

	//2. 컨테이너 + 레이아웃
	Container con = getContentPane();  //가장 밖은 container
	con.setLayout(new GridLayout(2, 2)); //2행 1열
	//component (JButton, JTextField, JLabel, JTable)
	
	
	//4. 이벤트 처리 
	JLabel btn_user = new JLabel("비밀번호:");
	JLabel btn_user2 = new JLabel(text);
	
	
	//4. 이벤트 처리 
	JButton btn_user3 = new JButton("로그인하기");
	btn_user3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("btn_user3");
			new LoginPage();
			dispose();
		}
	}); 
		

	JLabel blank = new JLabel("");
	
	//3. 컴포넌트 추가
 
  		con.add(btn_user);
  		con.add(btn_user2);
  		con.add(blank);
  		con.add(btn_user3);
  		
	                                     
	//1.
	setTitle("FindPW");
	setBounds(500, 300, 250, 200); //위치와 크기 한번에
	setVisible(true); //창 띄우기...
	
	}
	
}
