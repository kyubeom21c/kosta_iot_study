package kostaco;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

import kostaco.model.KostacoDAO;
import kostaco.model.KostacoDAOimpl;
import kostaco.model.KostacoVO;

import java.awt.Point;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

public class RiceMenuPage extends JFrame {

	public RiceMenuPage() {

		Container con = getContentPane();

		JPanel title = new JPanel();
		title.setFont(new Font("굴림", Font.PLAIN, 50));
		con.add(title, BorderLayout.NORTH);

		JLabel jl_rice = new JLabel("RICE");
		title.add(jl_rice);

		JPanel menu = new JPanel();
		con.add(menu, BorderLayout.CENTER);
		menu.setLayout(new GridLayout(2, 3, 0, 0));

		// 메뉴1번//////////////////////////////////////////////////////
		JPanel menu1 = new JPanel();
		menu.add(menu1);

		ImageIcon img1 = new ImageIcon("./rice_image/1.png");
		menu1.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel jp_img1 = new JPanel();
		menu1.add(jp_img1);
		JLabel jl_img1 = new JLabel(img1);
		jp_img1.add(jl_img1);

		JPanel jp_infor1 = new JPanel();
		menu1.add(jp_infor1);
		jp_infor1.setLayout(new GridLayout(4, 1, 0, 0));

		KostacoDAO dao = new KostacoDAOimpl();
		KostacoVO vo = new KostacoVO();
		vo.setName("시금치도시락");
		KostacoVO vo1 = dao.selectOne(vo);

		JLabel jl_name1 = new JLabel(vo1.getName());
		jp_infor1.add(jl_name1);
		JLabel jl_price1 = new JLabel(vo1.getPrice());
		jp_infor1.add(jl_price1);
		JLabel jl_amount1 = new JLabel("재고 : " + vo1.getAmount());
		jp_infor1.add(jl_amount1);
		JTextField tf_amount1 = new JTextField();
		jp_infor1.add(tf_amount1);

		JCheckBox cb_menu1 = new JCheckBox("");
		jp_infor1.add(cb_menu1);
		// 메뉴2번//////////////////////////////////////////////////////
		JPanel menu2 = new JPanel();
		menu.add(menu2);

		ImageIcon img2 = new ImageIcon("./rice_image/2.png");
		menu2.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel jp_img2 = new JPanel();
		menu2.add(jp_img2);
		JLabel jl_img2 = new JLabel(img2);
		jp_img2.add(jl_img2);

		JPanel jp_infor2 = new JPanel();
		menu2.add(jp_infor2);
		jp_infor2.setLayout(new GridLayout(4, 1, 0, 0));

		vo.setName("치킨도시락");
		KostacoVO vo2 = dao.selectOne(vo);

		JLabel jl_name2 = new JLabel(vo2.getName());
		jp_infor2.add(jl_name2);
		JLabel jl_price2 = new JLabel(vo2.getPrice());
		jp_infor2.add(jl_price2);
		JLabel jl_amount2 = new JLabel("재고 : " + vo2.getAmount());
		jp_infor2.add(jl_amount2);
		JTextField tf_amount2 = new JTextField();
		jp_infor2.add(tf_amount2);

		JCheckBox cb_menu2 = new JCheckBox("");
		jp_infor2.add(cb_menu2);
		// 메뉴3번//////////////////////////////////////////////////////
		JPanel menu3 = new JPanel();
		menu.add(menu3);

		ImageIcon img3 = new ImageIcon("./rice_image/3.png");
		menu3.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel jp_img3 = new JPanel();
		menu3.add(jp_img3);
		JLabel jl_img3 = new JLabel(img3);
		jp_img3.add(jl_img3);

		JPanel jp_infor3 = new JPanel();
		menu3.add(jp_infor3);
		jp_infor3.setLayout(new GridLayout(4, 1, 0, 0));

		vo.setName("청양도시락");
		KostacoVO vo3 = dao.selectOne(vo);

		JLabel jl_name3 = new JLabel(vo3.getName());
		jp_infor3.add(jl_name3);
		JLabel jl_price3 = new JLabel(vo3.getPrice());
		jp_infor3.add(jl_price3);
		JLabel jl_amount3 = new JLabel("재고 : " + vo3.getAmount());
		jp_infor3.add(jl_amount3);
		JTextField tf_amount3 = new JTextField();
		jp_infor3.add(tf_amount3);

		JCheckBox cb_menu3 = new JCheckBox("");
		jp_infor3.add(cb_menu3);
		// 메뉴4번//////////////////////////////////////////////////////
		JPanel menu4 = new JPanel();
		menu.add(menu4);

		ImageIcon img4 = new ImageIcon("./rice_image/4.png");
		menu4.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel jp_img4 = new JPanel();
		menu4.add(jp_img4);
		JLabel jl_img4 = new JLabel(img4);
		jp_img4.add(jl_img4);

		JPanel jp_infor4 = new JPanel();
		menu4.add(jp_infor4);
		jp_infor4.setLayout(new GridLayout(4, 1, 0, 0));

		vo.setName("8곡도시락");
		KostacoVO vo4 = dao.selectOne(vo);

		JLabel jl_name4 = new JLabel(vo4.getName());
		jp_infor4.add(jl_name4);
		JLabel jl_price4 = new JLabel(vo4.getPrice());
		jp_infor4.add(jl_price4);
		JLabel jl_amount4 = new JLabel("재고 : " + vo4.getAmount());
		jp_infor4.add(jl_amount4);
		JTextField tf_amount4 = new JTextField();
		jp_infor4.add(tf_amount4);

		JCheckBox cb_menu4 = new JCheckBox("");
		jp_infor4.add(cb_menu4);
		// 메뉴5번//////////////////////////////////////////////////////
		JPanel menu5 = new JPanel();
		menu.add(menu5);

		ImageIcon img5 = new ImageIcon("./rice_image/5.png");
		menu5.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel jp_img5 = new JPanel();
		menu5.add(jp_img5);
		JLabel jl_img5 = new JLabel(img5);
		jp_img5.add(jl_img5);

		JPanel jp_infor5 = new JPanel();
		menu5.add(jp_infor5);
		jp_infor5.setLayout(new GridLayout(4, 1, 0, 0));

		vo.setName("오믈렛도시락");
		KostacoVO vo5 = dao.selectOne(vo);

		JLabel jl_name5 = new JLabel(vo5.getName());
		jp_infor5.add(jl_name5);
		JLabel jl_price5 = new JLabel(vo5.getPrice());
		jp_infor5.add(jl_price5);
		JLabel jl_amount5 = new JLabel("재고 : " + vo5.getAmount());
		jp_infor5.add(jl_amount5);
		JTextField tf_amount5 = new JTextField();
		jp_infor5.add(tf_amount5);

		JCheckBox cb_menu5 = new JCheckBox("");
		jp_infor5.add(cb_menu5);
		// 메뉴6번//////////////////////////////////////////////////////
		JPanel menu6 = new JPanel();
		menu.add(menu6);

		ImageIcon img6 = new ImageIcon("./rice_image/6.png");
		menu6.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel jp_img6 = new JPanel();
		menu6.add(jp_img6);
		JLabel jl_img6 = new JLabel(img6);
		jp_img6.add(jl_img6);

		JPanel jp_infor6 = new JPanel();
		menu6.add(jp_infor6);
		jp_infor6.setLayout(new GridLayout(4, 1, 0, 0));

		vo.setName("두부도시락");
		KostacoVO vo6 = dao.selectOne(vo);

		JLabel jl_name6 = new JLabel(vo6.getName());
		jp_infor6.add(jl_name6);
		JLabel jl_price6 = new JLabel(vo6.getPrice());
		jp_infor6.add(jl_price6);
		JLabel jl_amount6 = new JLabel("재고 : " + vo6.getAmount());
		jp_infor6.add(jl_amount6);
		JTextField tf_amount6 = new JTextField();
		jp_infor6.add(tf_amount6);

		JCheckBox cb_menu6 = new JCheckBox("");
		jp_infor6.add(cb_menu6);
		////////////////////////////////////////////////////////
		JPanel btn = new JPanel();
		con.add(btn, BorderLayout.SOUTH);

		
		JButton btn_list = new JButton("장바구니 담기");
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_list");
				if(cb_menu1.isSelected()) {
					vo1.setAmount(Integer.parseInt(tf_amount1.getText()));
					dao.insert(vo1);
				}
				if(cb_menu2.isSelected()) {
					vo2.setAmount(Integer.parseInt(tf_amount2.getText()));
					dao.insert(vo2);
				}
				if(cb_menu3.isSelected()) {
					vo3.setAmount(Integer.parseInt(tf_amount3.getText()));
					dao.insert(vo3);
				}
				if(cb_menu4.isSelected()) {
					vo4.setAmount(Integer.parseInt(tf_amount4.getText()));
					dao.insert(vo4);
				}
				if(cb_menu5.isSelected()) {
					vo5.setAmount(Integer.parseInt(tf_amount5.getText()));
					dao.insert(vo5);
				}
				if(cb_menu6.isSelected()) {
					vo6.setAmount(Integer.parseInt(tf_amount6.getText()));
					dao.insert(vo6);
				}
				new ListPage();
				dispose();
			}
		});
		btn.add(btn_list);

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

		setTitle("RiceMenuPage");
		setBounds(200, 0, 500, 700);
		setVisible(true);
	}

}
