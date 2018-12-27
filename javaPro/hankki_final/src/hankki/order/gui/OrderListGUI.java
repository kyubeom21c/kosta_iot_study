package hankki.order.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hankki.login.gui.LoginGUI;
import hankki.menucho.model.MenuChoiceVO;
import hankki.order.model.OrderDAO;
import hankki.order.model.OrderDAOimpl;
import hankki.order.model.OrderVO;

public class OrderListGUI extends JFrame {

	String[][] datas;
	DefaultTableModel dm;
	JTable table;
	JScrollPane jscp;
	String[] columns = new String[] { "시퀀스", "종류", "메뉴이름", "조리시간", "가격" };

	public OrderListGUI() {
		// pan 2개해서 컨테이너에 붙이기
		OrderDAO dao = new OrderDAOimpl();
		
		String[] columnsInfo = new String[] { "시퀀스","주문번호", "배달주소", "전화번호", "상태"};
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel jpn = new JPanel();
		jpn.setLayout(new GridLayout(1, 2));

		// 3.컴포넌트 추가
		List<OrderVO> vos = new ArrayList<>();
		dm = new DefaultTableModel(datas, columns);
		table = new JTable(dm);
		jscp = new JScrollPane(table);
		
		vos = dao.selectOrderinfo(LoginGUI.tel);
		//테스트용
//		vos = dao.selectOrderinfo("01027270602");
		String[][] datasInfo =listConvertArrayInfo(vos, columnsInfo.length);
		DefaultTableModel dmInfo = new DefaultTableModel(datasInfo, columnsInfo);
		JTable tableInfo = new JTable(dmInfo);
		JScrollPane jscpInfo = new JScrollPane(tableInfo);

		JButton btn_ok = new JButton("확인");

		btn_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		// 테이블 이벤트
		tableInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//OrderDAO dao = new OrderDAOimpl();
				
				System.out.println("mouseClicked...");
				int rowIndex = tableInfo.getSelectedRow();
				System.out.println(rowIndex);
				System.out.println(datasInfo[rowIndex][1]);
				List<OrderVO > vos = dao.selectOrderList(datasInfo[rowIndex][1]);
				datas=dao.listConvertArray(vos, columns.length);
				dm = new DefaultTableModel(datas, columns);
				table.setModel(dm);
			}
		});

		// 5.컨테이너에 추가
		jpn.add(jscp);
		jpn.add(jscpInfo);
		
		
		// con.add(jpn, "North");
		con.add(jpn, "Center");
		con.add(btn_ok,"South");

		// 1.
		setTitle("주문확인");
		setBounds(500, 0, 800, 500);
		setVisible(true);
		
	}// end Menu

	public void jtableAdd(MenuChoiceVO vo) {

		int rowCnt = 0;
		String[][] temp;

		if (this.datas != null)
			rowCnt = this.datas.length;

		temp = this.datas;
		this.datas = new String[rowCnt + 1][columns.length];
		int count = 0;

		if (temp != null) {
			for (String[] x : temp) {

				datas[count] = new String[] { count + "", x[1], x[2], x[3], x[4] };
				count++;
			}
		}
		datas[count] = new String[] { count + "", vo.getKind(), vo.getName(), vo.getCookTm() + "", vo.getPrice() + "" };

		dm = new DefaultTableModel(datas, columns);
		table.setModel(dm);

	}

	public String[][] listConvertArrayInfo(List<OrderVO> vos, int columnsCnt) {

		int count = 0;
		String[][] datas = new String[vos.size()][columnsCnt];

		for (OrderVO vo : vos) {
			datas[count] = new String[] { (count+1) + "", vo.getOrdernum(), vo.getAddress(), vo.getTel(),vo.getStat() };
			count++;
		}
		return datas;
	}



}
