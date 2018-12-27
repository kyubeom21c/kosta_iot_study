package hankki.login.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hankki.login.model.LoginDAO;
import hankki.login.model.LoginDAOimpl;
import hankki.member.gui.Home;

public class LoginGUI extends JFrame {

	public static String email;
	public static String tel;

	public LoginGUI() {

		
		
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(4, 2));

		// 3.필요한 컴포넌트 오브젝트들 생성
		JLabel jl_email = new JLabel("E-Mail");
		JLabel jl_tel = new JLabel("TEL");
		JLabel jl_title = new JLabel("한끼식사");
		JLabel jl_title2 = new JLabel("로그인 해주세요");

		File f = new File("config\\config.cof");
		String jtv_email="";
		String jtv_tel="";
		if(f.exists()) {
			String[] emailTel = getLoginAutto();
			jtv_email=emailTel[0];
			jtv_tel=emailTel[1];
			
		}
		
		JTextField jt_email = new JTextField(jtv_email);
		JTextField jt_tel = new JTextField(jtv_tel);

		JButton btn_login = new JButton("로그인");
		JButton btn_member = new JButton("회원가입");

		// 4.이벤트처리
		btn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_login click");

				LoginDAO dao = new LoginDAOimpl();
				boolean userCheck = dao.userLogin(jt_email.getText(), jt_tel.getText());
				System.out.println("userLogin result:" + userCheck);
				if (userCheck) {
					System.out.println("로그인 성공");
					LoginGUI.email = jt_email.getText();
					LoginGUI.tel = jt_tel.getText();
					setLoginAutto();
					new LoginOKGUI();
					setVisible(false);
				} else {
					jl_title2.setText("로그인 실패 ");
				}
			}
		});
		btn_member.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home();
			}
		});

		// Home
		// 5.컨테이너에 컴포넌트 추가
		con.add(jl_title);
		con.add(jl_title2);
		con.add(jl_email);
		con.add(jt_email);
		con.add(jl_tel);
		con.add(jt_tel);
		con.add(btn_login);
		con.add(btn_member);

		// 1.
		setTitle("Login");
		setBounds(0, 0, 400, 300);
		setVisible(true);
	}

	public void setLoginAutto() {
		File f = new File("config\\config.cof");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		if (f.exists()) {
			// 3. File output
			FileWriter fw = null;

			try {
				// fos = new FileOutputStream(f);
				// 지우고 쌩으로 넣기 덮어 쓰기
				fw = new FileWriter(f);
				// 기존 파일에 이어 쓰기
				String str = email + "#" + tel;
				fw.write(str);
				fw.flush();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	public String[] getLoginAutto() {
		File f = new File("config\\config.cof");
		String[] strIdPw = null;
		if (f.exists() && f.canRead()) {
			// 2. File input2
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);

				String str = null;

				if ((str = br.readLine()) != null) {
					strIdPw = str.split("#");
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fr != null) {
					try {
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} // end finally
		}

		return strIdPw;
	}

}
