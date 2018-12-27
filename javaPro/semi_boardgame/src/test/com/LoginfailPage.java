package test.com;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginfailPage extends JFrame {
	
	public LoginfailPage() {
		// TODO Auto-generated constructor

	//2. 컨테이너 + 레이아웃
	Container con = getContentPane();  //가장 밖은 container
	con.setLayout(new GridLayout(1, 1)); //2행 1열
	//component (JButton, JTextField, JLabel, JTable)
	
	
	//4. 이벤트 처리 
	JLabel btn_user = new JLabel("id와 pw와 일치하지 않습니다");

}
	
}
