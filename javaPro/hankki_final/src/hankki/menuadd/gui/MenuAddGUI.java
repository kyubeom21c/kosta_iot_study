package hankki.menuadd.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hankki.menuadd.model.MenuAddDAO;
import hankki.menuadd.model.MenuAddDAOimpl;
import hankki.menuadd.model.MenuAddVO;

public class MenuAddGUI extends JFrame implements ActionListener{
	
	public MenuAddGUI() {
		System.out.println("MenuAddGUI()...");
		
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 2));
		
		JPanel jpn = new JPanel();
		jpn.setLayout(new GridLayout(1, 4));
		
		// 3. 필요한 컴포넌트 오브젝트 생성
		JLabel num = new JLabel(" ");
		JLabel kind = new JLabel("종류");
		JLabel name = new JLabel("이름");
		JLabel cooktm = new JLabel("조리시간");
		JLabel price = new JLabel("가격");
		
		//JTextField tf_kind = new JTextField("밥");
		
		JRadioButton bt1 = new JRadioButton("밥");
		JRadioButton bt2 = new JRadioButton("국");
		JRadioButton bt3 = new JRadioButton("반찬");
		JRadioButton bt4 = new JRadioButton("후식");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(bt1);
		bg.add(bt2);
		bg.add(bt3);
		bg.add(bt4);
		
		JTextField tf_name = new JTextField("백미");
		JTextField tf_cooktm = new JTextField("10");
		JTextField tf_price = new JTextField("1000");
		
		JButton btn_insertOK = new JButton("추가");
		JButton btn_selectAll = new JButton("전체보기");
		
		// 4. 이벤트 처리
		btn_insertOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_insertOK");
//				System.out.println(tf_kind.getText());
				System.out.println(tf_name.getText());
				System.out.println(tf_cooktm.getText());
				System.out.println(tf_price.getText());
				String kind =null;
				if (bt1.isSelected()) kind=bt1.getText();
				if (bt2.isSelected()) kind=bt2.getText();
				if (bt3.isSelected()) kind=bt3.getText();
				if (bt4.isSelected()) kind=bt4.getText();
				
				MenuAddDAO dao = new MenuAddDAOimpl();
				MenuAddVO vo = new MenuAddVO();
				vo.setKind(kind);
				vo.setName(tf_name.getText());
				vo.setCooktm(Integer.parseInt(tf_cooktm.getText()));
				vo.setPrice(Integer.parseInt(tf_price.getText()));
				int result = dao.insert(vo);
				System.out.println("insert result:"+result);
				if(result==1) new MenuAddSelectGUI();
			}
		});
		
		btn_selectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btn_selectAll");
				new MenuAddSelectGUI();
			}
		});
		
		// 5. 컴포넌트를 컨테이너에 추가.
		jpn.add(bt1);
		jpn.add(bt2);
		jpn.add(bt3);
		jpn.add(bt4);
		
		con.add(kind);
		con.add(jpn);
		
		con.add(name);
		con.add(tf_name);
		
		con.add(cooktm);
		con.add(tf_cooktm);
		
		con.add(price);
		con.add(tf_price);
		
		
		con.add(btn_insertOK);
		con.add(btn_selectAll);
		
		
		// 1.
		setTitle("HOME");
		setBounds(0,0,500,300);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		System.out.println(s);

	}

}
