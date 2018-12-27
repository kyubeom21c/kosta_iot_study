package kostaco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import member.model.MemberDAO;
import member.model.MemberDAOimpl;
import member.model.MemberVO;

public class NewMemberPage extends JFrame {

	public NewMemberPage() {

		Container con = getContentPane();

		JPanel jp_title = new JPanel();
		jp_title.setFont(new Font("����", Font.PLAIN, 50));
		con.add(jp_title, BorderLayout.NORTH);

		JLabel title = new JLabel("ȸ������");
		jp_title.add(title);

		///////////////////////////////

		JPanel jp_center = new JPanel();
		con.add(jp_center, BorderLayout.CENTER);
		jp_center.setLayout(new GridLayout(5, 2, 0, 0));

		// ����â

		JLabel name = new JLabel("�̸�");
		JTextField tf_name = new JTextField();
		jp_center.add(name);
		jp_center.add(tf_name);

		JLabel id = new JLabel("���̵�");
		JTextField tf_id = new JTextField();
		jp_center.add(id);
		jp_center.add(tf_id);

		JLabel pw = new JLabel("��й�ȣ");
		JTextField tf_pw = new JTextField();
		jp_center.add(pw);
		jp_center.add(tf_pw);

		JLabel adress = new JLabel("�ּ�");
		JTextField tf_adress = new JTextField();
		jp_center.add(adress);
		jp_center.add(tf_adress);

		JLabel tel = new JLabel("��ȣ");
		JTextField tf_tel = new JTextField();
		jp_center.add(tel);
		jp_center.add(tf_tel);

		// Ȯ�ι�ư

		JPanel jp_OK = new JPanel();
		con.add(jp_OK, BorderLayout.SOUTH);
		jp_OK.setLayout(new GridLayout(1, 1, 0, 0));

		JButton btn_OK = new JButton("�Ϸ�");
		jp_OK.add(btn_OK);

		btn_OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MemberVO vo = new MemberVO();
				MemberDAO dao = new MemberDAOimpl();

				vo.setName(tf_name.getText());
				vo.setId(tf_id.getText());
				vo.setPw(tf_pw.getText());
				vo.setAddress(tf_adress.getText());
				vo.setTel(tf_tel.getText());

				int result = dao.insert(vo);
				System.out.println("insert result : " + result);

				new LoginPage();
				dispose();
			}
		});

////////////////////////////

		setTitle("NewMemberPage");
		setBounds(700, 0, 500, 300);
		setVisible(true);

	}

}
