package hankki.menuadd.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hankki.menuadd.model.MenuAddDAO;
import hankki.menuadd.model.MenuAddDAOimpl;
import hankki.menuadd.model.MenuAddVO;

public class MenuAddUpdateGUI extends JFrame {

	public MenuAddUpdateGUI() {
		// TODO Auto-generated constructor stub
	}

	public MenuAddUpdateGUI(String num) {
		System.out.println("successed...");

		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 2));

		JLabel jl_num = new JLabel("num");
		JLabel jl_num2 = new JLabel(num);
		JLabel kind = new JLabel("종류");
		JLabel name = new JLabel("이름");
		JLabel cooktm = new JLabel("조리시간");
		JLabel price = new JLabel("가격");

		MenuAddDAO dao = new MenuAddDAOimpl();
		MenuAddVO vo = new MenuAddVO();
		vo.setNum(Integer.parseInt(num));
		MenuAddVO vo2 = dao.selectOne(vo);

		JTextField tf_kind = new JTextField(vo2.getKind());
		JTextField tf_name = new JTextField(vo2.getName());
		JTextField tf_cooktm = new JTextField(vo2.getCooktm()+ "");
		JTextField tf_price = new JTextField(vo2.getPrice() + "");

		JButton btn_updateOK = new JButton("수정완료");
		JButton btn_deleteOK = new JButton("삭제");

		// 4. 이벤트처리
		btn_updateOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_updateOK");
				System.out.println(jl_num2.getText());
				System.out.println(kind.getText());
				System.out.println(name.getText());
				System.out.println(cooktm.getText());
				System.out.println(price.getText());

				MenuAddVO vo = new MenuAddVO();
				vo.setNum(Integer.parseInt(num));
				vo.setKind(tf_kind.getText());
				vo.setName(tf_name.getText());
				vo.setCooktm(Integer.parseInt(tf_cooktm.getText()));
				vo.setPrice(Integer.parseInt(tf_price.getText()));
				int result = dao.update(vo);
				System.out.println("update result" + result);
				if (result >= 1)
					new MenuAddSelectGUI();

			}
		});

		btn_deleteOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_deleteOK");
				System.out.println(jl_num2.getText());

				MenuAddVO vo = new MenuAddVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				System.out.println("delete result" + result);
				if (result > 0)
					new MenuAddSelectGUI();
			}

		});

		// 5. 컨테이너에 컴포턴트 추가
		con.add(jl_num);
		con.add(jl_num2);

		con.add(kind);
		con.add(tf_kind);

		con.add(name);
		con.add(tf_name);

		con.add(cooktm);
		con.add(tf_cooktm);

		con.add(price);
		con.add(tf_price);

		con.add(btn_updateOK);
		con.add(btn_deleteOK);

		// 1.
		setTitle("UpdatePage");
		setBounds(0, 300, 250, 300);
		setVisible(true);

	}

}
