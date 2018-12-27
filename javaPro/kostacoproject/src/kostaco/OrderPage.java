package kostaco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customer.model.CustomerDAO;
import customer.model.CustomerDAOimpl;
import customer.model.CustomerVO;
import kostaco.model.KostacoDAO;
import kostaco.model.KostacoDAOimpl;
import kostaco.model.KostacoVO;
import member.model.MemberDAO;
import member.model.MemberDAOimpl;
import member.model.MemberVO;

public class OrderPage extends JFrame {

	public OrderPage(int payTotal) {

		System.out.println("Orderpage...");

		Container con = getContentPane();

		CustomerDAO dao = new CustomerDAOimpl();
		KostacoDAO dao2 = new KostacoDAOimpl();
		MemberDAO dao3 = new MemberDAOimpl();

		CustomerVO vo = new CustomerVO();
		KostacoVO vo2 = new KostacoVO();
		MemberVO vo3 = new MemberVO();

		JPanel title = new JPanel();
		title.setFont(new Font("굴림", Font.PLAIN, 50));
		con.add(title, BorderLayout.NORTH);

		JLabel jl_order = new JLabel("ORDER");
		title.add(jl_order);

		JPanel information = new JPanel();
		con.add(information, BorderLayout.CENTER);
		information.setLayout(new GridLayout(3, 1, 0, 0));

		/////////////

		vo.setName("이름");
		CustomerVO vo1 = dao.selectOne(vo);
		MemberVO voo = dao3.selectOne(vo3);

		JPanel jp_infor = new JPanel();
		information.add(jp_infor);
		jp_infor.setLayout(new GridLayout(4, 2, 0, 0));

		if (LoginPage.vo2.getId().equals("none")) {

			JLabel jl_name = new JLabel("이름");
			JTextField tf_name = new JTextField(" ");
			jp_infor.add(jl_name);
			jp_infor.add(tf_name);

			JLabel jl_adress = new JLabel("주소");
			JTextField tf_adress = new JTextField(" ");
			jp_infor.add(jl_adress);
			jp_infor.add(tf_adress);

			JLabel jl_tel = new JLabel("번호");
			JTextField tf_tel = new JTextField(" ");
			jp_infor.add(jl_tel);
			jp_infor.add(tf_tel);

			JLabel jl_sumprice = new JLabel("총가격");
			JLabel jl_sumprice2 = new JLabel(payTotal + " 원");
			jp_infor.add(jl_sumprice);
			jp_infor.add(jl_sumprice2);

		} else {

			JLabel jl_name = new JLabel("이름");
			JLabel jl_name2 = new JLabel(LoginPage.vo2.getName());
			jp_infor.add(jl_name);
			jp_infor.add(jl_name2);

			JLabel jl_adress = new JLabel("주소");
			JLabel jl_adress2 = new JLabel(LoginPage.vo2.getAddress());
			jp_infor.add(jl_adress);
			jp_infor.add(jl_adress2);

			JLabel jl_tel = new JLabel("번호");
			JLabel jl_tel2 = new JLabel(LoginPage.vo2.getTel());
			jp_infor.add(jl_tel);
			jp_infor.add(jl_tel2);

			JLabel jl_sumprice = new JLabel("총가격");
			JLabel jl_sumprice2 = new JLabel(payTotal + " 원");
			jp_infor.add(jl_sumprice);
			jp_infor.add(jl_sumprice2);

		}

		///////////////////////////////////////

		JFrame jf = new JFrame();
		JPanel jp = new JPanel();

		JCheckBox cb_cash = new JCheckBox("현금");
		JCheckBox cb_card = new JCheckBox("카드");

		jp.add(cb_cash);
		jp.add(cb_card);

		con.add(jp);

		con.add(information, BorderLayout.CENTER);

		JButton btn_orderOK = new JButton("orderOK");

		btn_orderOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("btn_orderOk");

				// vo.setName(tf_name.getText());
				// vo.setAdress(tf_adress.getText());
				// vo.setTel(tf_tel.getText());
				// vo.setSumprice(jl_sumprice2 + "");

				int result = dao2.update(vo2);

				int result2 = dao2.delete();

				System.out.println("update result : " + result);

				new FinishPage();
				dispose();
			}
		});

		con.add(btn_orderOK, BorderLayout.SOUTH);

		setTitle("Orderpage");
		setBounds(300, 0, 500, 300);
		setVisible(true);

//		jf.setVisible(true);
	}// end orderpage

}// end class