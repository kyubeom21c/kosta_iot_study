package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import test.com.model.MemberDirDAO;
import test.com.model.MemberDirDAOimpl;
import test.com.model.MemberUserDAO;
import test.com.model.MemberUserDAOimpl;
import test.com.model.MemberVO;


public class LoginPage extends JFrame {
	

	protected Object f;

	public LoginPage() {
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 2));
		
		
		//3.필요한 컴포넌트 오브젝트들 생성
		JLabel id = new JLabel("ID");
		JLabel pw = new JLabel("비밀번호");
		
		
		JTextField tf_id = new JTextField("");
		JTextField tf_pw = new JTextField("");
	
		
		JButton btn_back = new JButton("id찾기");
		JButton btn_OK = new JButton("확인");
		
		//4.이벤트처리
		btn_OK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_OK");
				System.out.println(tf_id.getText());
				System.out.println(tf_pw.getText());
				
				MemberUserDAO dao = new MemberUserDAOimpl();
				
				MemberVO vo = new MemberVO();
				vo.setId(tf_id.getText());
				vo.setPw(tf_pw.getText());
				
				
				
				
				MemberVO mList = dao.loginCheck_2(vo);
		
				if(mList!=null) {
					System.out.println("로그인 성공");
					new MsgPageLogin(mList.getName());
					dispose();
				} else {
					System.out.println("로그인 실패");
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 실패", JOptionPane.WARNING_MESSAGE);
					if(MemberUserDAOimpl.failCount > 1) {
						System.out.println("3초뒤에..");
						new MsgPageLoginAlert();
						dispose();
					}
					
				}
//				
			}
		});
		
		
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIdPage();
				
			}
		});
		
		//5.컨테이너에 컴포넌트 추가
		con.add(id);
		con.add(tf_id);
		con.add(pw);
		con.add(tf_pw);
		con.add(btn_OK);
		con.add(btn_back);
		
		// 1.
		setTitle("LoginPage");
		setBounds(500, 0, 250, 300);
		setVisible(true);
	}

}
