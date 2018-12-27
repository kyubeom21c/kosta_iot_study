package kostaco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

import kostaco.model.KostacoDAO;
import kostaco.model.KostacoDAOimpl;
import kostaco.model.KostacoVO;

public class HomePage extends JFrame {

	public HomePage() {
      
      Container con = getContentPane();
      
      JPanel jp_top = new JPanel();
       jp_top.setFont(new Font("굴림", Font.PLAIN, 50));
       con.add(jp_top, BorderLayout.NORTH);
       
       JLabel title = new JLabel("KOSTACO");
       jp_top.add(title);
       
       
       //////////////////////////////////////////////////
       
       JPanel jp_center = new JPanel();
       con.add(jp_center, BorderLayout.CENTER);
       jp_center.setLayout(new GridLayout(2, 3, 5, 5));
       
       /////////////식사류/////////////////
       
       JPanel rice = new JPanel();
       rice.setLayout(new BorderLayout());
       
       ImageIcon rice_1 = new ImageIcon("./img/bibimbab.jpg");
       JButton rice_menu = new JButton(rice_1);
       rice_menu.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new RiceMenuPage();
            dispose();
         }
      });
       rice.add(rice_menu, "Center");
   
       JButton rice_menu2 = new JButton("식사류");
       rice_menu2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new RiceMenuPage();
            dispose();
         }
      });

       rice.add(rice_menu2, "South");
//       rice.add(rice);
       
       jp_center.add(rice);
       
       /////////////////////스낵//////////////////////////
       
       JPanel snack = new JPanel();
       snack.setLayout(new BorderLayout());
       
       ImageIcon snack_1 = new ImageIcon("./img/cookie.jpg");
       JButton snack_menu = new JButton(snack_1);
       snack_menu.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new SnackMenuPage();
            dispose();
         }
      });
       snack.add(snack_menu, "Center");
        
       JButton snack_menu2 = new JButton("스낵류");
       snack_menu2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new SnackMenuPage();
            dispose();
         }
      });
       
       
       snack.add(snack_menu2, "South");
       
       jp_center.add(snack);
       
       
       
       //////////////////////////음료/////////////////////////////////////////
       
       JPanel beverage = new JPanel();
       beverage.setLayout(new BorderLayout());
       
       ImageIcon beverage_1 = new ImageIcon("./img/coke.jpg");
       JButton beverage_menu = new JButton(beverage_1);
       beverage_menu.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new BeverageMenuPage();

            dispose();
         }
      });
       beverage.add(beverage_menu, "Center");
       
       JButton beverage_menu2 = new JButton("음료류");
       beverage_menu2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new BeverageMenuPage();

            dispose();
         }
      });
       
       beverage.add(beverage_menu2, "South");
       
       jp_center.add(beverage);
       
//////////////////////////////////////////////////////////////////////////
       
       
       
       JPanel rice3 = new JPanel();
       rice3.setLayout(new BorderLayout());
       
       JLabel rice_jl3 = new JLabel("price");
       JLabel rice_jl4 = new JLabel("식사 추천메뉴");
       
       JPanel rice4 = new JPanel();
       rice4.setLayout(new BorderLayout());
       
       JLabel rice_jl = new JLabel("img");
       JLabel rice_jl2 = new JLabel("name");
       
       KostacoDAO kdao3 = new KostacoDAOimpl();
       
       
       Random r3 = new Random();
       
       List<KostacoVO> vos3 = kdao3.selectCode1();
       
       System.out.println(vos3.size());
       
       int su3 = r3.nextInt(vos3.size());
       
       ImageIcon rice_jl_bg = new ImageIcon("./rice_image/"+vos3.get(su3).getImg());
       rice_jl.setIcon(rice_jl_bg);
       rice_jl2.setText(vos3.get(su3).getName());
       rice_jl3.setText(vos3.get(su3).getPrice()+"");
       
       
       rice4.add(rice_jl, "Center");
       rice4.add(rice_jl2, "South");
       
       rice3.add(rice4);
       rice3.add(rice_jl3, "South");
       rice3.add(rice_jl4, "North");
       
       
       
       jp_center.add(rice3);
       

       ///////////////////스낵류////////////////////////
       
//       JPanel snack = new JPanel();
//       snack.setLayout(new BorderLayout());
//       
//       ImageIcon snack_1 = new ImageIcon("./img/cookie.jpg");
//       JButton snack_menu = new JButton(snack_1);
//       snack_menu.addActionListener(new ActionListener() {
//         
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            new SnackMenuPage();
//         }
//      });
//       snack.add(snack_menu, "Center");
//        
//       JButton snack_menu2 = new JButton("스낵류");
//       snack_menu2.addActionListener(new ActionListener() {
//         
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            new SnackMenuPage();
//         }
//      });
//       
//       snack.add(snack_menu2, "South");
//       
//       jp_center.add(snack);
//       
//       
//       
//       ///////////////////////////////////////////////////////////////////
       
       JPanel snack3 = new JPanel();
       snack3.setLayout(new BorderLayout());
       
       JLabel sna_jl3 = new JLabel("price");
       JLabel sna_jl4 = new JLabel("스낵 추천메뉴");
       
       JPanel snack4 = new JPanel();
       snack4.setLayout(new BorderLayout());
       
       JLabel sna_jl = new JLabel("img");
       JLabel sna_jl2 = new JLabel("name");
       
       
       KostacoDAO kdao2 = new KostacoDAOimpl();
       
       
       Random r2 = new Random();
       
       List<KostacoVO> vos2 = kdao2.selectCode2();
       
       System.out.println(vos2.size());
       
       int su2 = r2.nextInt(vos2.size());
       
       
       ImageIcon sna_jl_bg = new ImageIcon("./snack_image/"+vos2.get(su2).getImg());
       sna_jl.setIcon(sna_jl_bg);
       sna_jl2.setText(vos2.get(su2).getName());
       sna_jl3.setText(vos2.get(su2).getPrice()+"");

       
       
       snack4.add(sna_jl, "Center");
       snack4.add(sna_jl2, "South");
       
       snack3.add(snack4);
       snack3.add(sna_jl3, "South");
       snack3.add(sna_jl4, "North");

       
       
       jp_center.add(snack3);
       
       

       ///////////////////음료류////////////////////////
      
//       JPanel beverage = new JPanel();
//       beverage.setLayout(new BorderLayout());
//       
//       ImageIcon beverage_1 = new ImageIcon("./img/coke.jpg");
//       JButton beverage_menu = new JButton(beverage_1);
//       beverage_menu.addActionListener(new ActionListener() {
//         
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            new BeverageMenuPage();
//            
//         }
//      });
//       beverage.add(beverage_menu, "Center");
//       
//       JButton beverage_menu2 = new JButton("음료류");
//       beverage_menu2.addActionListener(new ActionListener() {
//         
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            new BeverageMenuPage();
//            
//         }
//      });
//       
//       beverage.add(beverage_menu2, "South");
//       
//       jp_center.add(beverage);
//       
////////////////////////////////////////////////////////////////////////////
       
       JPanel beverage3 = new JPanel();
       beverage3.setLayout(new BorderLayout());
       
       
       JLabel beg_jl3 = new JLabel("price");
       JLabel beg_jl4 = new JLabel("음료 추천메뉴");
       
       JPanel beverage4 = new JPanel();
       beverage4.setLayout(new BorderLayout());
       
       JLabel beg_jl = new JLabel("img");
       JLabel beg_jl2 = new JLabel("name");

       
       KostacoDAO kdao = new KostacoDAOimpl();
       
       
       Random r = new Random();
       
       List<KostacoVO> vos = kdao.selectCode3();
       
       System.out.println(vos.size());
       
       int su = r.nextInt(vos.size());
       
       
       ImageIcon beg_jl_bg = new ImageIcon("./img/"+vos.get(su).getImg());
       beg_jl.setIcon(beg_jl_bg);
       beg_jl2.setText(vos.get(su).getName());
       beg_jl3.setText(vos.get(su).getPrice()+"");

       
       
       beverage4.add(beg_jl, "Center");
       beverage4.add(beg_jl2, "South");
       
       beverage3.add(beverage4);
       beverage3.add(beg_jl3, "South");
       beverage3.add(beg_jl4, "North");
       
       jp_center.add(beverage3);
       
///////////////////////////////////////////////////////////////       
      
       JPanel jp_bottom = new JPanel();
       jp_bottom.setFont(new Font("굴림", Font.PLAIN, 50));
       con.add(jp_bottom, BorderLayout.SOUTH);
       JButton list = new JButton("장바구니");
       list.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new ListPage();
            dispose();
         }
      });
       jp_bottom.add(list);
       
       JButton btn_main = new JButton("메인화면으로");
		btn_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn_main");
				new MainPage();
				dispose();
				
			}
		});
		jp_bottom.add(btn_main);
      
      setTitle("KOSTACO HOME");
      setBounds(200, 0, 500, 700);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
}