package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.NoteBookDAO;
import test.com.model.NoteBookDAOimpl;
import test.com.model.NoteBookVO;

public class InsertPage extends JFrame {

	public InsertPage() {
		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 2));
		
		
		//3.필요한 컴포넌트 오브젝트들 생성
		JLabel produceNo = new JLabel("productNo");
		JLabel produceName = new JLabel("produceName");
		JLabel modelName = new JLabel("modelName");
		JLabel price = new JLabel("price");
		
		JTextField tf_produceNo = new JTextField("aaa");
		JTextField tf_produceName = new JTextField("bbb");
		JTextField tf_modelName = new JTextField("ccc");
		JTextField tf_price = new JTextField("200000");
		
		JButton btn_insertOK = new JButton("insertOK");
		JButton btn_selectAll = new JButton("goto selectAll");
		
		//4.이벤트처리
		btn_insertOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_insertOK");
				System.out.println(tf_produceNo.getText());
				System.out.println(tf_produceName.getText());
				System.out.println(tf_modelName.getText());
				System.out.println(tf_price.getText());
				
				NoteBookDAO dao = new NoteBookDAOimpl();
				NoteBookVO vo = new NoteBookVO();
				vo.setProductNO(tf_produceNo.getText());
				vo.setProductName(tf_produceName.getText());
				vo.setModelName(tf_modelName.getText());
				vo.setPrice(Integer.parseInt(tf_price.getText()));
				int result = dao.insert(vo);
				System.out.println("insert result:"+result);
				if(result==1) new SelectAllPage();
			}
		});
		
		btn_selectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_selectAll");
				new SelectAllPage();
			}
		});
		
		//5.컨테이너에 컴포넌트 추가
		con.add(produceNo);
		con.add(tf_produceNo);
		con.add(produceName);
		con.add(tf_produceName);
		con.add(modelName);
		con.add(tf_modelName);
		con.add(price);
		con.add(tf_price);
		con.add(btn_insertOK);
		con.add(btn_selectAll);
		
		// 1.
		setTitle("InsertPage");
		setBounds(250, 0, 250, 300);
		setVisible(true);
	}
}
