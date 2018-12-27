package kostaco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import member.model.MemberDAO;
import member.model.MemberDAOimpl;
import member.model.MemberVO;

public class MainPage extends JFrame {

   public MainPage() {

      Container con = getContentPane();

      JPanel jp_title = new JPanel();
      jp_title.setFont(new Font("굴림", Font.PLAIN, 50));
      con.add(jp_title, BorderLayout.NORTH);

      JLabel title = new JLabel("Member");
      jp_title.add(title);

      ///////////////////////////////////

      JPanel jp_center = new JPanel();
      con.add(jp_center, BorderLayout.CENTER);
      jp_center.setLayout(new GridLayout(1, 3, 50, 50));

      // 회원

      JButton btn_member = new JButton("회원");
      btn_member.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            new LoginSelectPage();
			dispose();
         }
      });

      jp_center.add(btn_member);

      // 비회원

      JButton btn_nonmember = new JButton("비회원");
      btn_nonmember.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            MemberVO vo = new MemberVO();
            MemberDAO dao = new MemberDAOimpl();

            vo.setId("none");
            vo.setPw("none");

            LoginPage.vo2 = dao.selectOne(vo);

            new HomePage();
			dispose();
         }
      });

      jp_center.add(btn_nonmember);

      // 관리자

      JButton btn_manager = new JButton("관리자");
      btn_manager.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            new ManageLoginPage();         
			dispose();   
         }
      });

      jp_center.add(btn_manager);

      ////////////////////////////

      setTitle("MainPage");
      setBounds(200, 0, 500, 200);
      setVisible(true);

   }// end mainpage

}
