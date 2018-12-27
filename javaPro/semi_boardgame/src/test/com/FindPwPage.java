package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import test.com.model.MemberUserDAO;
import test.com.model.MemberUserDAOimpl;
import test.com.model.MemberVO;

public class FindPwPage extends JFrame {
	
	public FindPwPage() {
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(4, 2));
		
		
		//3.필요한 컴포넌트 오브젝트들 생성
		JLabel name = new JLabel("이름");
		JLabel tel = new JLabel("연락처");
		JLabel id = new JLabel("ID");
		
		
		JTextField tf_name = new JTextField("");
		JTextField tf_tel = new JTextField("");
		JTextField tf_id = new JTextField("");
	
		
		
		JButton btn_OK = new JButton("확인");
		
		//4.이벤트처리
		btn_OK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_OK");
				System.out.println(tf_name.getText());
				System.out.println(tf_tel.getText());
				System.out.println(tf_id.getText());
				
				MemberUserDAO dao = new MemberUserDAOimpl();
				MemberVO vo = new MemberVO();
				vo.setName(tf_name.getText());
				vo.setTel(tf_tel.getText());
				vo.setId(tf_id.getText());
				
				MemberVO vo2 = dao.findPw(vo);
				MemberVO m1 = dao.pwCheck(vo);
				
				if(m1 != null) {
					new MsgPageFindPw(vo2.getPw());
					dispose();
				} else {
					System.out.println("일치하는 password가 없습니다.");
					JOptionPane.showMessageDialog(null, "일치하는 password가 없습니다.", "알림", JOptionPane.WARNING_MESSAGE);
				}
			

				
			}
		});
		
		JLabel blank = new JLabel("");
		
		//5.컨테이너에 컴포넌트 추가
		con.add(name);
		con.add(tf_name);
		con.add(tel);
		con.add(tf_tel);
		con.add(id);
		con.add(tf_id);
		con.add(blank);
		con.add(btn_OK);
	
		
		// 1.
		setTitle("비밀번호찾기");
		setBounds(500, 300, 250, 300);
		setVisible(true);
	}
	

}
