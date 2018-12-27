package hankki.order.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hankki.login.gui.LoginGUI;
import hankki.login.gui.LoginOKGUI;
import hankki.member.model.MemberVO;
import hankki.order.model.OrderDAO;
import hankki.order.model.OrderDAOimpl;
import hankki.order.model.OrderVO;

public class OrderGUI extends JFrame {

	String[][] datas;
	DefaultTableModel dm;
	JTable table;
	JScrollPane jscp;
	OrderListGUI mlGUI;
	Container con;

	public OrderGUI(List<OrderVO> vos) {
		// pan 2���ؼ� �����̳ʿ� ���̱�

		// 2.�����̳� + ���̾ƿ�
		Container con = getContentPane();
		con.setLayout(new GridLayout(1,2));

		JPanel jpn = new JPanel();
		jpn.setLayout(new GridLayout(3, 2));

		// 3.������Ʈ �߰�
		OrderDAO dao = new OrderDAOimpl();
		
		MemberVO mvo= dao.userLogin(LoginGUI.tel, LoginGUI.email);
		//�׽�Ʈ��
//		MemberVO mvo= dao.userLogin("01027270602", "ksm@gmail.com");
		JLabel jl_tel = new JLabel("��ȭ��ȣ");
		JLabel jl_address = new JLabel("�ּ�");
		
		JTextField jt_tel = new JTextField(mvo.getTel());
		JTextField jt_address = new JTextField(mvo.getAddress());
		
		JButton btn_orderOK = new JButton("�ֹ��Ϸ�");
		JButton btn_cancel = new JButton("���");
		
		


		// ��ũ��
		// String[][] datas = new String[][] {{"aa","bb","cc","dd","ee"}};
		String[] columns = new String[] { "������", "����", "�޴��̸�", "�����ð�", "����" };
		
		
		datas=dao.listConvertArray(vos, columns.length);
				
		dm = new DefaultTableModel(datas, columns);
		table = new JTable(dm);
		jscp = new JScrollPane(table);



		btn_orderOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String orderNum = new Date().getTime()+jt_tel.getText();
				dao.insertBatch(vos,orderNum);
				
				OrderVO voSet =new OrderVO();
				
				voSet.setOrdernum(orderNum);
				voSet.setTel(jt_tel.getText());
				voSet.setAddress(jt_address.getText());
				dao.insert(voSet);
				
				setVisible(false);
				new LoginOKGUI();
			}
		});

		btn_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});


		// ���̺� �̺�Ʈ
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked...");
				int rowIndex = table.getSelectedRow();
				
				
			}
		});

		// 5.�����̳ʿ� �߰�
		
		
		con.add(jscp);
		
		jpn.add(jl_tel);
		jpn.add(jt_tel);
		jpn.add(jl_address);
		jpn.add(jt_address);
		jpn.add(btn_orderOK);
		jpn.add(btn_cancel);
		
		con.add(jpn);


		// 1.
		setTitle("�ֹ�");
		// setSize(300, 200);
		setBounds(0, 0, 500, 500);
		setVisible(true);

	}// end Menu

}
