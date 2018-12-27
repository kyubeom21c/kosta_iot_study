package test.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import test.com.model.RoomDirDAO;
import test.com.model.RoomDirDAOimpl;
import test.com.model.RoomVO;

public class RoomSelectAllPage extends JFrame {
	
//	public final int dirPassword= 2018;
	
	// 손님용 SelectAll페이지 
	public RoomSelectAllPage() { 
		setBounds(500, 0, 400, 300);
		setTitle("방 선택하기");
		
		String[] columns = new String[] { "방번호", "이용시간", "이용여부", "선택게임"};
		RoomDirDAO dao = new RoomDirDAOimpl();
		List<RoomVO> vos = dao.selectAll();
		
		String[][] datas = new String[vos.size()][columns.length];
		int count =0;
		for (RoomVO vo : vos) {
			String useRemain="";
			if (vo.getRemain()==1) {
				useRemain="이용중";
			} else if (vo.getRemain()==0) {
				useRemain="비어있음";
			}
			datas[count]=new String[] {
					vo.getNum()+"",
					vo.getTime()+"",
					useRemain,
					vo.getRoomGame()
			};
			count ++;
		}
		
		DefaultTableModel dm = new DefaultTableModel(datas, columns);
		JTable table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {// 마우스 클릭 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				String num = datas[table.getSelectedRow()][0];
					
				if(vos.get(table.getSelectedRow()).getRemain() == 1) { 
					// 이용중(remain이 1)인 방을 눌렀을 때 메세지로 보여줌
					JOptionPane.showMessageDialog(null, "이미 이용중인 방입니다.", "이용중", JOptionPane.PLAIN_MESSAGE);
				}
				
				else if(vos.get(table.getSelectedRow()).getRemain() == 0) {
					new RoomUpdatePage(num);
					dispose();
				}
				
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
	} // end RoomSelectAllPage()
	
	
	
	// 관리자용 SelectAll 페이지 new RoomSelectAllPage(2018); 로 접근
	public RoomSelectAllPage(int num) { 
		setBounds(500, 0, 400, 300);
		setTitle("모든 방 조회하기");
		
		if(num==2018) { // 관리자 페이지
			getContentPane().setLayout(new BorderLayout(0, 0));
			JLabel lblNewLabel = new JLabel("수정하거나 삭제시킬 방을 클릭해주세요.");
			lblNewLabel.setPreferredSize(new Dimension(30, 15));
			lblNewLabel.setMinimumSize(new Dimension(30, 15));
			lblNewLabel.setMaximumSize(new Dimension(30, 15));
			getContentPane().add(lblNewLabel, BorderLayout.NORTH);
			
			
			JButton btnNewButton = new JButton("방 새로 추가하기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					RoomDirDAO dao = new RoomDirDAOimpl();
					RoomVO vo = new RoomVO();
					
					int result = dao.insert(vo);
					
					if (result == 1) { // insert가 성공적일 때
						System.out.println("방 추가에 성공했습니다");
					} else if (result == 0) {
						System.out.println("방 추가에 실패했습니다");
					}

					new RoomSelectAllPage(2018);
					dispose();
				}
			});
			btnNewButton.setPreferredSize(new Dimension(65, 23));
			btnNewButton.setMinimumSize(new Dimension(65, 23));
			btnNewButton.setMaximumSize(new Dimension(65, 23));
			getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		}
		

		String[] columns = new String[] { "방번호", "이용시간", "이용여부", "선택게임"};
		RoomDirDAO dao = new RoomDirDAOimpl();
		List<RoomVO> vos = dao.selectAll();
		
		String[][] datas = new String[vos.size()][columns.length];
		int count =0;
		for (RoomVO vo : vos) {
			String useRemain="";
			if (vo.getRemain()==1) {
				useRemain="이용중";
			} else if (vo.getRemain()==0) {
				useRemain="비어있음";
			}
			datas[count]=new String[] {
					vo.getNum()+"",
					vo.getTime()+"",
					useRemain,
					vo.getRoomGame()
			};
			count ++;
		}
		
		DefaultTableModel dm = new DefaultTableModel(datas, columns);
		JTable table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {// 마우스 클릭 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				String num = datas[table.getSelectedRow()][0];
				new RoomUpdateDeletePage(num);
				dispose();
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		setVisible(true);
	} // end RoomSelectAllPage(int num)

}
