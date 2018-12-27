package test.com.board.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.com.board.model.TestBoardDAO;
import test.com.board.model.TestBoardDAOimpl;
import test.com.board.model.TestBoardVO;

public class TestBoardModelMain extends JFrame {

	private String[] column = new String[] { "번호", "제목", "내용", "작성자", "작성일자" };
	private JTable table = new JTable();
	private CardLayout mCardLayout = new CardLayout(0, 0);
	private JPanel panel_CENTER;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private TestBoardDAO dao;

	private JLabel numJLabel = new JLabel("번호:");
	private JLabel titleJLabel = new JLabel("제목:");
	private JLabel contentJLabel = new JLabel("내용:");
	private JLabel nameJLabel = new JLabel("작성자:");
	private JLabel regDateJLabel = new JLabel("작성일자:");

	public TestBoardModelMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout(0, 0));
		panel_CENTER = new JPanel();
		panel_CENTER.setLayout(mCardLayout);

		dao = new TestBoardDAOimpl();
		selectUI();

		getContentPane().add(panel_CENTER, BorderLayout.CENTER);

		JPanel panel_NORTH = new JPanel();
		JButton gotoInsertBtn = new JButton("입력하러가기");
		gotoInsertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertUI();
				mCardLayout.show(panel_CENTER, "insertView");
			}
		});
		panel_NORTH.add(gotoInsertBtn);

		JButton gotoSelectBtn = new JButton("목록보러가기");
		gotoSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mCardLayout.show(panel_CENTER, "selectView");
			}
		});
		panel_NORTH.add(gotoSelectBtn);
		getContentPane().add(panel_NORTH, BorderLayout.NORTH);

		setTitle("게시판 프로그램");
		setBounds(400, 0, 400, 300);
		setVisible(true);

	}

	private void searchUI(TestBoardVO vo) {
		JLabel numJLabel2 = new JLabel();
		JLabel titleJLabel2 = new JLabel();
		JLabel contentJLabel2 = new JLabel();
		JLabel nameJLabel2 = new JLabel();
		JLabel regDateJLabel2 = new JLabel();
		JButton gotoUpdateBtn = new JButton("수정하러가기");
		JButton gotoDeleteBtn = new JButton("삭제하러가기");

		final TestBoardVO vo2 = dao.search(vo);
		int num = vo2.getNum();
		String title = vo2.getTitle();
		String content = vo2.getContent();
		String name = vo2.getName();
		Date regDate = vo2.getRegDate();

		numJLabel2.setText(String.valueOf(num));
		titleJLabel2.setText(title);
		contentJLabel2.setText(content);
		nameJLabel2.setText(name);
		regDateJLabel2.setText(regDate.toString());

		JPanel search = new JPanel();
		search.setLayout(new GridLayout(6, 2));
		search.add(numJLabel);
		search.add(numJLabel2);
		search.add(titleJLabel);
		search.add(titleJLabel2);
		search.add(contentJLabel);
		search.add(contentJLabel2);
		search.add(nameJLabel);
		search.add(nameJLabel2);
		search.add(regDateJLabel);
		search.add(regDateJLabel2);
		search.add(gotoUpdateBtn);
		search.add(gotoDeleteBtn);

		panel_CENTER.add(search, "searchView");

		gotoUpdateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateUI(vo2);
				mCardLayout.show(panel_CENTER, "updateView");

			}
		});

		gotoDeleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteUI(vo2);
				mCardLayout.show(panel_CENTER, "deleteView");
			}
		});

	}

	protected void deleteUI(final TestBoardVO vo2) {
		JLabel numLabel = new JLabel();
		JLabel textLabel = new JLabel("번을 정말삭제?");

		JButton OkBtn = new JButton("삭제완료");
		JButton cancelBtn = new JButton("취소");

		JPanel delete = new JPanel();
		delete.setLayout(new GridLayout(2, 2));

		numLabel.setText(String.valueOf(vo2.getNum()));

		delete.add(numLabel);
		delete.add(textLabel);
		delete.add(OkBtn);
		delete.add(cancelBtn);

		panel_CENTER.add(delete, "deleteView");

		// 3.이벤트 처리
		OkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int result = dao.delete(vo2);
				System.out.println("result:" + result);

				selectUI();
				mCardLayout.show(panel_CENTER, "selectView");
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mCardLayout.show(panel_CENTER, "selectView");
			}
		});
	}

	protected void updateUI(TestBoardVO vo) {

		final JLabel numField = new JLabel("1");
		final JTextField titleField = new JTextField("title");
		final JTextField contentField = new JTextField("content");
		final JTextField nameField = new JTextField("홍길동");

		JButton OkBtn = new JButton("수정완료");
		JButton cancelBtn = new JButton("취소");

		JPanel update = new JPanel();
		update.setLayout(new GridLayout(5, 2));

		numField.setText(String.valueOf(vo.getNum()));
		titleField.setText(vo.getTitle());
		contentField.setText(vo.getContent());
		nameField.setText(vo.getName());

		update.add(numJLabel);
		update.add(numField);
		update.add(titleJLabel);
		update.add(titleField);
		update.add(contentJLabel);
		update.add(contentField);
		update.add(nameJLabel);
		update.add(nameField);
		update.add(OkBtn);
		update.add(cancelBtn);

		panel_CENTER.add(update, "updateView");

		OkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestBoardVO vo = new TestBoardVO();
				vo.setNum(Integer.parseInt(numField.getText()));
				vo.setTitle(titleField.getText());
				vo.setContent(contentField.getText());
				vo.setName(nameField.getText());

				int result = dao.update(vo);
				System.out.println("result:" + result);

				selectUI();
				mCardLayout.show(panel_CENTER, "selectView");
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				titleField.setText("");
				contentField.setText("");
				nameField.setText("");
			}
		});
	}

	private void insertUI() {
		JPanel insert = new JPanel();
		insert.setLayout(new GridLayout(4, 2));

		final JTextField titleField = new JTextField("title");
		final JTextField contentField = new JTextField("content");
		final JTextField nameField = new JTextField("홍길동");

		JButton OkBtn = new JButton("완료");
		JButton cancelBtn = new JButton("취소");
		insert.add(titleJLabel);
		insert.add(titleField);
		insert.add(contentJLabel);
		insert.add(contentField);
		insert.add(nameJLabel);
		insert.add(nameField);
		insert.add(OkBtn);
		insert.add(cancelBtn);

		OkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestBoardVO vo = new TestBoardVO();
				vo.setTitle(titleField.getText());
				vo.setContent(contentField.getText());
				vo.setName(nameField.getText());

				int result = dao.insert(vo);
				System.out.println("result:" + result);
				selectUI();
				mCardLayout.show(panel_CENTER, "selectView");
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				titleField.setText("");
				contentField.setText("");
				nameField.setText("");
			}
		});

		panel_CENTER.add(insert, "insertView");

	}

	private void selectUI() {
		List<TestBoardVO> vos = dao.select();

		String[][] rows = new String[vos.size()][column.length];

		for (int i = 0; i < vos.size(); i++) {
			String[] row = new String[] { String.valueOf(vos.get(i).getNum()),
					vos.get(i).getTitle(), vos.get(i).getContent(),
					vos.get(i).getName(), vos.get(i).getRegDate().toString() };
			rows[i] = row;
		}
		model = new DefaultTableModel(rows, column);
		table.setModel(model);

		scroll = new JScrollPane(table);
		panel_CENTER.add(scroll, "selectView");

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String num = model.getValueAt(table.getSelectedRow(), 0)
						.toString();
				String title = model.getValueAt(table.getSelectedRow(), 1)
						.toString();
				String content = model.getValueAt(table.getSelectedRow(), 2)
						.toString();
				String name = model.getValueAt(table.getSelectedRow(), 3)
						.toString();
				String regDate = model.getValueAt(table.getSelectedRow(), 4)
						.toString();


				TestBoardVO vo = new TestBoardVO();
				vo.setNum(Integer.parseInt(num));
				vo.setTitle(title);
				vo.setContent(content);
				vo.setName(name);

				Date d2 = null;
				try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(regDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				vo.setRegDate(d2);

				searchUI(vo);
				mCardLayout.show(panel_CENTER, "searchView");
			}
		});
	}
	

	public static void main(String[] args) {
		System.out.println("게시판 프로그램 메인 시작...");
		new TestBoardModelMain();

		System.out.println("게시판 프로그램 메인 종료...");
	}

}
