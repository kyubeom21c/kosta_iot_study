package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MsgPageLoginAlert extends JFrame {
	
	JLabel blank = new JLabel();
	
	public  MsgPageLoginAlert() {
		// TODO Auto-generated constructor

	//2. 컨테이너 + 레이아웃
	Container con = getContentPane();  //가장 밖은 container
	con.setLayout(new GridLayout(3, 1)); //2행 1열
	//component (JButton, JTextField, JLabel, JTable)
	
	
	//4. 이벤트 처리 
	JLabel btn_user = new JLabel("3초 뒤에 실행됩니다...");
	con.add(btn_user);
	
	
	//4. 이벤트 처리 
	JButton btn_user2 = new JButton("확인");
	btn_user2.addActionListener(new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("btn_user2");
			
			new Thread() {
				public void run() {
					setTime();
				};
			}.start();
			
		}
	}); 

	
	
	//3. 컴포넌트 추가
 
  		con.add(btn_user2);
  		con.add(blank);
  		
  	
  		
	//1.
	setTitle("alert");
	setBounds(500, 0, 250, 200); //위치와 크기 한번에
	setVisible(true); //창 띄우기...
	
	}

	
	// 메소드로 구현해서 생성자 안에 넣기
	public void setTime() {
		try {
			
			for (int i = 3; i > 0; i--) {
	            System.out.println(i);
	            blank.setText((i)+"");
				blank.getText();
				Thread.sleep(1000);
			}
			
			this.setVisible(false);
			new LoginPage();
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
