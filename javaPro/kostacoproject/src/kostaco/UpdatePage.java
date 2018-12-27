package kostaco;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manage.model.ManageDAO;
import manage.model.ManageDAOimpl;
import manage.model.ManageVO;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class UpdatePage extends JFrame {

	public UpdatePage(String name) {
		Container con = getContentPane();
		con.setLayout(new BorderLayout(0, 0));

		JPanel title = new JPanel();
		con.add(title, BorderLayout.NORTH);

		JLabel jl_title = new JLabel("재고 관리");
		title.add(jl_title);

		JPanel content = new JPanel();
		con.add(content, BorderLayout.CENTER);
		content.setLayout(new GridLayout(4, 2, 0, 0));
		ManageDAO dao = new ManageDAOimpl();
		ManageVO vo = new ManageVO();
		vo.setName(name);
		ManageVO vo2 = dao.selectOne(vo);

		JLabel jl_name = new JLabel("제품명 : ");
		JLabel jl_name2 = new JLabel(vo2.getName());
		JLabel jl_price = new JLabel("가격 : ");
		JLabel jl_price2 = new JLabel(vo2.getPrice());
		JLabel jl_amount = new JLabel("현재 재고 : ");
		JLabel jl_amount2 = new JLabel(vo2.getAmount() + "");
		JLabel jl_plus = new JLabel("추가 재고 : ");

		JTextField tf_plus = new JTextField();

		content.add(jl_name);
		content.add(jl_name2);
		content.add(jl_price);
		content.add(jl_price2);
		content.add(jl_amount);
		content.add(jl_amount2);
		content.add(jl_plus);
		content.add(tf_plus);

		JPanel btn = new JPanel();
		con.add(btn, BorderLayout.SOUTH);

		JButton btn_save = new JButton("저장");
		btn_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_save");
				ManageVO vo = new ManageVO();

				vo.setName(vo2.getName());
				vo.setPrice(vo2.getPrice());
				vo.setAmount(Integer.parseInt(tf_plus.getText()));

				int result = dao.update(vo);
				System.out.println("update result : " + result);
				new ManageProductPage();
				dispose();
			}
		});
		btn.add(btn_save);

		JButton btn_cancel = new JButton("취소");
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_cancel");
				dispose();
			}
		});
		btn.add(btn_cancel);

		setTitle("UpdatePage");
		setBounds(300, 0, 250, 300);
		setVisible(true);
	}

}
