package hankki.info.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hankki.info.model.InfoDAO;
import hankki.info.model.InfoDAOImpl;
import hankki.info.model.InfoVO;


public class InfoUpdateGUI extends JFrame {

	InfoVO vo;
	InfoDAO dao=new InfoDAOImpl();
	
	public InfoUpdateGUI(String orderNum) {
		
		vo = dao.selectOne(orderNum);
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 2));
		
		
		JLabel jl_orderNum = new JLabel("�ֹ���ȣ:");
		JLabel address = new JLabel("�ּ�:");
		JLabel tel = new JLabel("��ȭ��ȣ:");
		JLabel stat = new JLabel("����:");
		JLabel tf_orderNum = new JLabel(vo.getOrderNum());
		JLabel tf_address = new JLabel(vo.getAddress());
		JLabel tf_tel = new JLabel(vo.getTel());
		
		JTextField tf_stat = new JTextField(vo.getStat());
		
		JButton btn_update = new JButton("�������� ����");
		JButton btn_delete = new JButton("����");
		
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoDAO dao = new InfoDAOImpl();
				InfoVO vo = new InfoVO();
				
				vo.setStat(tf_stat.getText());
				vo.setOrderNum(orderNum);
				dao.update_stat(vo);
				dispose();
			}
		});
		
	btn_delete.addActionListener(new ActionListener() {
		 
			@Override
			public void actionPerformed(ActionEvent e) {
				vo.setOrderNum(orderNum);
				dao.delete(vo);
				dispose();
			}
		});
		
		
		con.add(jl_orderNum);
		con.add(tf_orderNum);
		con.add(address);
		con.add(tf_address);
		con.add(tel);
		con.add(tf_tel);
		con.add(stat);
		con.add(tf_stat);
		con.add(btn_update);
		con.add(btn_delete);
		
		
		setTitle("����");
		setBounds(400, 200, 400, 400);
		setVisible(true);
		
	}
}
