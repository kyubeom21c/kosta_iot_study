package kostaco;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import kostaco.model.KostacoDAO;
import kostaco.model.KostacoDAOimpl;
import kostaco.model.KostacoVO;

import java.awt.FlowLayout;

public class ListPage extends JFrame {
	int payTotal = 0;
	public ListPage() {
		
		Container con = getContentPane();
		
		JPanel title = new JPanel();
		con.add(title, BorderLayout.NORTH);
		
		JLabel jl_list = new JLabel("Shopping List");
		title.add(jl_list);
		
		/////////////////////////////////////////////////
		JPanel jp_list = new JPanel();
		con.add(jp_list, BorderLayout.CENTER);
		jp_list.setLayout(new BorderLayout(0, 0));
		////////////
		KostacoDAO dao = new KostacoDAOimpl();
		List<KostacoVO> vos = dao.selectAll();
		////////////
		JPanel list = new JPanel();
		jp_list.add(list);
		list.setLayout(new GridLayout(vos.size(), 3));
		
		
		
		for (int i = 0; i < vos.size(); i++) {
			KostacoVO vo = new KostacoVO();
			vo.setName(vos.get(i).getName());
			vo.setPrice(vos.get(i).getPrice());
			vo.setAmount(vos.get(i).getAmount());
			
			JLabel jl_name = new JLabel(vo.getName());
			JLabel jl_price = new JLabel(vo.getPrice());
			JLabel jl_amount = new JLabel(vo.getAmount()+"");
			
			list.add(jl_name);
			list.add(jl_price);
			list.add(jl_amount);
			payTotal += Integer.parseInt(vos.get(i).getPrice()) * vos.get(i).getAmount();
		}
		////////////
		JPanel total = new JPanel();
		jp_list.add(total, BorderLayout.SOUTH);
		total.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel jl_total = new JLabel("total : "+payTotal);
		total.add(jl_total);
		////////////////////////////////////////////////
		JPanel btn = new JPanel();
		getContentPane().add(btn, BorderLayout.SOUTH);
		
		JButton btn_pay = new JButton("결제");
		btn_pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_pay");
				new OrderPage(payTotal);

				dispose();
			}
		});
		btn.add(btn_pay);
		
		JButton btn_cancel = new JButton("전체 취소");
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_cancel");
				int result = dao.delete();
				new HomePage();
				dispose();
			}
		});
		btn.add(btn_cancel);
		
		JButton btn_back = new JButton("이전");
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_back");
				new HomePage();
				dispose();
			}
		});
		btn.add(btn_back);
		
		setTitle("ListPage");
		setBounds(200, 0, 500, 700);
		setVisible(true);
	}
	
}
