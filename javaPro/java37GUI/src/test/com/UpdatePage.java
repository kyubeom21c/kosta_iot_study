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

public class UpdatePage extends JFrame {

	public UpdatePage() {
	}

	public UpdatePage(String num) {

		// 2.컨테이너 + 레이아웃
		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 2));

		// 3.필요한 컴포넌트 오브젝트들 생성
		JLabel jl_num = new JLabel("num");
		JLabel jl_num2 = new JLabel(num);
		JLabel produceNo = new JLabel("productNo");
		JLabel produceName = new JLabel("produceName");
		JLabel modelName = new JLabel("modelName");
		JLabel price = new JLabel("price");
		
		NoteBookDAO dao = new NoteBookDAOimpl();
		NoteBookVO vo = new NoteBookVO();
		vo.setNum(Integer.parseInt(num));
		NoteBookVO vo2 = dao.selectOne(vo);
//		System.out.println(vo2.getNum());
//		System.out.println(vo2.getProductNO());
//		System.out.println(vo2.getProductName());
//		System.out.println(vo2.getModelName());
//		System.out.println(vo2.getPrice());
		
		JTextField tf_produceNo = new JTextField(vo2.getProductNO());
		JTextField tf_produceName = new JTextField(vo2.getProductNO());
		JTextField tf_modelName = new JTextField(vo2.getModelName());
		JTextField tf_price = new JTextField(vo2.getPrice()+"");

		JButton btn_updateOK = new JButton("updateOK");
		JButton btn_deleteOK = new JButton("deleteOK");

		// 4.이벤트처리
		btn_updateOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_updateOK");
				System.out.println(jl_num2.getText());
				System.out.println(tf_produceNo.getText());
				System.out.println(tf_produceName.getText());
				System.out.println(tf_modelName.getText());
				System.out.println(tf_price.getText());
				
				NoteBookVO vo = new NoteBookVO();
				vo.setNum(Integer.parseInt(num));
				vo.setProductNO(tf_produceNo.getText());
				vo.setProductName(tf_produceName.getText());
				vo.setModelName(tf_modelName.getText());
				vo.setPrice(Integer.parseInt(tf_price.getText()));
				int result = dao.update(vo);
				System.out.println("update result:"+result);
				if(result >= 1) new SelectAllPage();
			}
		});

		btn_deleteOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_deleteOK");
				System.out.println(jl_num2.getText());
				
				NoteBookVO vo = new NoteBookVO();
				vo.setNum(Integer.parseInt(num));
				int result = dao.delete(vo);
				System.out.println("delete result:"+result);
				if(result > 0) new SelectAllPage();
			}
		});

		// 5.컨테이너에 컴포넌트 추가
		con.add(jl_num);
		con.add(jl_num2);
		con.add(produceNo);
		con.add(tf_produceNo);
		con.add(produceName);
		con.add(tf_produceName);
		con.add(modelName);
		con.add(tf_modelName);
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
