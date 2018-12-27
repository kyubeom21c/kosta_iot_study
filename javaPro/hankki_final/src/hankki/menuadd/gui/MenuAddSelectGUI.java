package hankki.menuadd.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hankki.menuadd.model.MenuAddDAO;
import hankki.menuadd.model.MenuAddDAOimpl;
import hankki.menuadd.model.MenuAddVO;

public class MenuAddSelectGUI extends JFrame {

   JTable table;

   public MenuAddSelectGUI() {
      // 2. 컨테이너에 레이아웃 추가
      Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel jpn = new JPanel();
		jpn.setLayout(new GridLayout(1, 7));

      // 3. 버튼이벤트 처리.
      JButton btn_rice = new JButton("밥 종류");
      JButton btn_soup = new JButton("국 종류");
      JButton btn_sidedish = new JButton("반찬 종류");
      JButton btn_dessert = new JButton("후식 종류");
      JTextField tf_name = new JTextField("");
      JButton btn_like = new JButton("검색");
      JButton btn_insert = new JButton("메뉴추가");
      JButton btn_all = new JButton("전체보기");

      btn_rice.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("btn_rice");

            MenuAddDAO dao = new MenuAddDAOimpl();
            List<MenuAddVO> vos = dao.selectKind("밥");
            System.out.println("vos size:" + vos.size());

            String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
            String[][] datas = new String[vos.size()][column.length];
            int count = 0;
            for (MenuAddVO x : vos) {
               datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "",
                     x.getPrice() + "" };
               count++;

            }
            // datas = dao.listConvertArray(vos, 5);
            DefaultTableModel dm = new DefaultTableModel(datas, column);
            table.setModel(dm);

         }
      });
      
      //이벤트 처리
      btn_soup.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("btn_soup");
            MenuAddDAO dao = new MenuAddDAOimpl();
            List<MenuAddVO> vos = dao.selectKind("국");
            System.out.println("vos size:" + vos.size());

            String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
            String[][] datas = new String[vos.size()][column.length];
            int count = 0;
            for (MenuAddVO x : vos) {
               datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "",
                     x.getPrice() + "" };
               count++;

            }
            // datas = dao.listConvertArray(vos, 5);
            DefaultTableModel dm = new DefaultTableModel(datas, column);
            table.setModel(dm);
         }
      });
      btn_sidedish.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("btn_sidedish");
            MenuAddDAO dao = new MenuAddDAOimpl();
            List<MenuAddVO> vos = dao.selectKind("반찬");
            System.out.println("vos size:" + vos.size());

            String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
            String[][] datas = new String[vos.size()][column.length];
            int count = 0;
            for (MenuAddVO x : vos) {
               datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "",
                     x.getPrice() + "" };
               count++;

            }
            // datas = dao.listConvertArray(vos, 5);
            DefaultTableModel dm = new DefaultTableModel(datas, column);
            table.setModel(dm);

         }
      });
      btn_dessert.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("btn_dessert");
            MenuAddDAO dao = new MenuAddDAOimpl();
            List<MenuAddVO> vos = dao.selectKind("후식");
            System.out.println("vos size:" + vos.size());

            String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
            String[][] datas = new String[vos.size()][column.length];
            int count = 0;

            for (MenuAddVO x : vos) {// vos의 타입의 데이터를 하나씩 꺼내서 x에 담아서 사용할수 있다.
               datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "", x.getPrice() + "" };
               count++;

            }
            // datas = dao.listConvertArray(vos, 5);

            DefaultTableModel dm = new DefaultTableModel(datas, column);// table 데이터 업데이트 (새로만들기)

            table.setModel(dm); // 새로만든 table 갱신 하기
         }
      });

      btn_like.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {

            System.out.println("btn_like");
            System.out.println(tf_name.getText());

            MenuAddDAO dao = new MenuAddDAOimpl();
            MenuAddVO vo = new MenuAddVO();
            vo.setName(tf_name.getText());
            List<MenuAddVO> vos = dao.like(tf_name.getText());
            // dao.like();
//            System.out.println("insert result:");

            String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
            String[][] datas = new String[vos.size()][column.length];
            int count = 0;

            for (MenuAddVO x : vos) {// vos의 타입의 데이터를 하나씩 꺼내서 x에 담아서 사용할수 있다.
               datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "", x.getPrice() + "" };
               count++;

            }
            // datas = dao.listConvertArray(vos, 5);

            DefaultTableModel dm = new DefaultTableModel(datas, column);// table 데이터 업데이트 (새로만들기)

            table.setModel(dm); // 새로만든 table 갱신 하기
         }
      });

      btn_insert.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("btn_insert");
            new MenuAddGUI();
         }
      });
      
      btn_all.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("btn_insert");
            MenuAddDAO dao = new MenuAddDAOimpl();
            List<MenuAddVO> vos = dao.selectAll();
            System.out.println("vos size:" + vos.size());

            String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
            String[][] datas = new String[vos.size()][column.length];
            int count = 0;

            for (MenuAddVO x : vos) {// vos의 타입의 데이터를 하나씩 꺼내서 x에 담아서 사용할수 있다.
               datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "", x.getPrice() + "" };
               count++;

            }
            // datas = dao.listConvertArray(vos, 5);

            DefaultTableModel dm = new DefaultTableModel(datas, column);// table 데이터 업데이트 (새로만들기)

            table.setModel(dm); // 새로만든 table 갱신 하기
         }
      });


      String[] column = new String[] { "번호", "종류", "이름", "조리시간", "가격" };
      MenuAddDAO dao = new MenuAddDAOimpl();
      List<MenuAddVO> vos = dao.selectAll();
      System.out.println("vos size:" + vos.size());
      
      String[][] datas = new String[vos.size()][column.length];
      int count = 0;
      for (MenuAddVO x : vos) {
         datas[count] = new String[] { x.getNum() + "", x.getKind(), x.getName(), x.getCooktm() + "",
               x.getPrice() + "" };
         count++;
         
      }
      
      DefaultTableModel dm = new DefaultTableModel(datas, column);
      table = new JTable(dm);
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println("mouseClicked...");
//            System.out.println(table.getSelectedRow());
            String num = datas[table.getSelectedRow()][0];
            System.out.println(num);
            new MenuAddUpdateGUI(num);
         }
      });
      // 5.
      jpn.add(btn_rice);
      jpn.add(btn_soup);
      jpn.add(btn_sidedish);
      jpn.add(btn_dessert);
      jpn.add(tf_name);
      jpn.add(btn_like);
      jpn.add(btn_all);

      con.add(jpn,"North");
      con.add(new JScrollPane(table),"Center");
      con.add(btn_insert,"South");
      
      // 1.
      setTitle("전체보기");
      setBounds(500, 0, 500, 300);
      setVisible(true);

   }
}