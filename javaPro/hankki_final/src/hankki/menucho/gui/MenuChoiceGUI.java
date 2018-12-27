package hankki.menucho.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hankki.login.gui.LoginGUI;
import hankki.login.gui.LoginOKGUI;
import hankki.menucho.model.MenuChoiceDAO;
import hankki.menucho.model.MenuChoiceDAOimpl;
import hankki.menucho.model.MenuChoiceVO;
import hankki.order.gui.OrderGUI;
import hankki.order.model.OrderVO;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MenuChoiceGUI extends JFrame {

	String[][] datas;
	DefaultTableModel dm;
	JTable table;
	JScrollPane jscp;
	MenuListGUI mlGUI;
	Container con;

	public MenuChoiceGUI() {
		// pan 2개해서 컨테이너에 붙이기

		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel jpn = new JPanel();
		jpn.setLayout(new GridLayout(1, 7));
		
		
		JPanel jpn_btn = new JPanel();
		jpn_btn.setLayout(new GridLayout(1, 2));

		// 3.컴포넌트 추가

		MenuChoiceDAO dao = new MenuChoiceDAOimpl();
		List<MenuChoiceVO> vos;
		vos = dao.selectAll();
		datas = dao.listConvertArray(vos, 5);

		// 스크롤
		// String[][] datas = new String[][] {{"aa","bb","cc","dd","ee"}};
		String[] columns = new String[] { "시퀀스", "종류", "메뉴이름", "조리시간", "가격" };

		dm = new DefaultTableModel(datas, columns);
		table = new JTable(dm);
		jscp = new JScrollPane(table);

		JButton btn_all = new JButton("전체");
		JButton btn_rice = new JButton("밥");
		JButton btn_soup = new JButton("국");
		JButton btn_sideDish = new JButton("반찬");
		JButton btn_dessert = new JButton("후식");
		JButton btn_search = new JButton("조회");
		JButton btn_back = new JButton("뒤로가기");
		JButton btn_orderOK = new JButton("주문하기");
		JTextField jt_search = new JTextField("시금치");


		// 4.이벤트 추가
		btn_orderOK.addActionListener(new ActionListener() {
			//String[] columns = new String[] { "시퀀스", "종류", "메뉴이름", "조리시간", "가격" };
			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] dataList = mlGUI.getTable();
				List<OrderVO> vos = new ArrayList<>();
				//order num
				String orderNum=new Date().getTime()+LoginGUI.tel;
				for (String[] x : dataList) {
					vos.add(new OrderVO(x[1], x[2], Integer.parseInt(x[3]) , Integer.parseInt(x[4]), orderNum));
				}
				new OrderGUI(vos);
				mlGUI.setVisibleGUI(false);
				setVisible(false);
			}
		});
		
		btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginOKGUI();
				mlGUI.setVisibleGUI(false);
				setVisible(false);
			}
		});

		btn_rice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<MenuChoiceVO> vos;
				vos = dao.selectKind("밥");
				datas = dao.listConvertArray(vos, 5);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<MenuChoiceVO> vos;
				vos = dao.selectLike(jt_search.getText());
				datas = dao.listConvertArray(vos, 5);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		btn_all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<MenuChoiceVO> vos;
				vos = dao.selectAll();
				datas = dao.listConvertArray(vos, 5);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		btn_dessert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<MenuChoiceVO> vos;
				vos = dao.selectKind("후식");
				datas = dao.listConvertArray(vos, 5);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		btn_sideDish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<MenuChoiceVO> vos;
				vos = dao.selectKind("반찬");
				datas = dao.listConvertArray(vos, 5);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		btn_soup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<MenuChoiceVO> vos;
				vos = dao.selectKind("국");
				datas = dao.listConvertArray(vos, 5);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		// 테이블 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked...");
				int rowIndex = table.getSelectedRow();
				System.out.println(rowIndex);
				MenuChoiceVO vo = new MenuChoiceVO();
				vo.setKind(datas[rowIndex][1]);
				vo.setName(datas[rowIndex][2]);
				vo.setCookTm(Integer.parseInt(datas[rowIndex][3]));
				vo.setPrice(Integer.parseInt(datas[rowIndex][4]));
				mlGUI.jtableAdd(vo);
			}
		});

		// 5.컨테이너에 추가
		jpn.add(btn_all);
		jpn.add(btn_rice);
		jpn.add(btn_soup);
		jpn.add(btn_sideDish);
		jpn.add(btn_dessert);
		jpn.add(jt_search);
		jpn.add(btn_search);

		
		jpn_btn.add(btn_orderOK);
		jpn_btn.add(btn_back);
		
		con.add(jpn, "North");
		con.add(jscp, "Center");
		con.add(jpn_btn, "South");

		// 1.
		setTitle("메뉴선택");
		// setSize(300, 200);
		setBounds(0, 0, 500, 500);
		setVisible(true);
		mlGUI = new MenuListGUI();

	}// end Menu

}
