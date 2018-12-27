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

public class MemInsertPage extends JFrame {
	

	public MemInsertPage() {
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 2));
		
		
		//3.필요한 컴포넌트 오브젝트들 생성
		JLabel id = new JLabel("ID");
		JLabel pw = new JLabel("비밀번호");
		JLabel name = new JLabel("이름");
		JLabel tel = new JLabel("연락처");
		
		JTextField tf_id = new JTextField("");
		JTextField tf_pw = new JTextField("");
		JTextField tf_name = new JTextField("");
		JTextField tf_tel = new JTextField("");
		
		JButton btn_back = new JButton("이전화면");
		JButton btn_OK = new JButton("입력");
		
		//4.이벤트처리
		btn_OK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_OK");
				System.out.println(tf_id.getText());
				System.out.println(tf_pw.getText());
				System.out.println(tf_name.getText());
				System.out.println(tf_tel.getText());
				
				MemberUserDAO dao = new MemberUserDAOimpl();
				MemberVO vo = new MemberVO();
				vo.setId(tf_id.getText());
				vo.setPw(tf_pw.getText());
				vo.setName(tf_name.getText());
				vo.setTel(tf_tel.getText());
				
				int result = dao.insertMember(vo);
				System.out.println(result);
				if (result==1) {
					JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다!", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
					new LoginPage();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);

				}
				
			}
		});
		
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserPage();
				
			}
		});
		
		//5.컨테이너에 컴포넌트 추가
		con.add(id);
		con.add(tf_id);
		con.add(pw);
		con.add(tf_pw);
		con.add(name);
		con.add(tf_name);
		con.add(tel);
		con.add(tf_tel);
		con.add(btn_OK);
		con.add(btn_back);
		
		// 1.
		setTitle("회원가입");
		setBounds(500, 0, 250, 300);
		setVisible(true);
	}

}
