package test.com.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import test.com.model.RoomDirDAO;
import test.com.model.RoomDirDAOimpl;
import test.com.model.RoomUserDAO;
import test.com.model.RoomUserDAOimpl;
import test.com.model.RoomVO;


public class Test_RoomMain {
	

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String exit = "";
		do {
			
			System.out.println("x키를 누르면 종료");
		} while (!exit.equals("x"));
		
		System.out.println("유저는 1번, 관리자는 9번 입력");
		String menu = br.readLine();
		System.out.println("현재메뉴:" + menu);

		if (menu.equals("1")) { // 유저 화면
			System.out.println("사용자 화면입니다.");
			// + 입실/퇴실
			RoomUserDAO dao = new RoomUserDAOimpl();
			RoomVO vo = new RoomVO();
			
			System.out.println("보드게임을 하실 방을 선택해주세요.");
			// +추가 : selectAll()로 출력해서 현재 방 상황 보여주기
			
			System.out.println("<방번호/이용시간/이용여부>");
			new RoomDirDAOimpl().selectAllList(); 
			System.out.println();
			
			System.out.println("이용하실 방 번호를 입력해주세요");
			vo.setNum(Integer.parseInt(br.readLine()));
			System.out.println("이용 시간을 입력해주세요");
			vo.setTime(Integer.parseInt(br.readLine()));

			if (vo.getTime() >= 1) { // 이용시간이 1시간 이상이면
				vo.setRemain(1); // 이용중:1으로 세팅
			} else if (vo.getTime() == 0) { // 이용시간이 0시간일때
				vo.setRemain(0); // 이용안함:0으로 세팅
			}

			int result = dao.update(vo);

			if (result >= 1) { // update가 성공적일 때
				if (vo.getRemain() == 1) {
					System.out.println("정상적으로 방 선택이 완료되었습니다");
					System.out.println("==============");
					System.out.println("이용하실 방 번호 : " + vo.getNum() + "번 방");
					System.out.println("이용 시간 : " + vo.getTime() + "시간");
					System.out.println("이용여부 : 이용중");
					System.out.println("==============");
					System.out.println("이용해주셔서 감사합니다 ^-^");
				}

				else if (vo.getRemain() == 0) {
					System.out.println("이용여부 : 이용안함");
				}
			}
			
			System.out.println("사용자 화면 끝");
			System.out.println();
			
		} // 유저화면 끝
		
		
		
		if (menu.equals("9")) { // 관리자 화면
			System.out.println("관리자 화면입니다.");
			RoomDirDAO dao = new RoomDirDAOimpl();
			RoomVO vo = new RoomVO();
			
			System.out.println("====menu:");
			System.out.println("1.방추가 2.방삭제 3.모든방조회 4.하나방조회");
			
			String menu_dir = br.readLine();
			
			if (menu_dir.equals("1")) { // 방추가
				System.out.println("방 추가 화면");
				
				System.out.println("새로 추가하실 방 번호를 입력해주세요");
				vo.setNum(4);
				
				int result = dao.insert(vo);
				
				if (result == 1) { // insert가 성공적일 때
						System.out.println("방 추가에 성공했습니다");
				}
				else if (result == 0) {
					System.out.println("방 추가에 실패했습니다");
				}
						
			} // 방추가 끝
			
			else if (menu_dir.equals("2")) { // 방삭제
				System.out.println("방 삭제 화면");
				
				System.out.println("삭제하실 방 번호를 입력해주세요");
				vo.setNum(4);
				
				int result = dao.delete(vo);
				
				if (result >= 1) { // delete가 성공적일 때
						System.out.println("방 삭제에 성공했습니다.");
				}
				else if (result == 0) {
					System.out.println("방 삭제에 실패했습니다. 없는 방일 수 있습니다.");
				}
						
			} // 방삭제 끝
			
			else if (menu_dir.equals("3")) { // 모든 방 조회
				System.out.println("모든 방 조회 화면");
				
				new RoomDirDAOimpl().selectAllList(); 

						
			} // 모든 방 조회 끝
			
			else if (menu_dir.equals("4")) { // 하나의 방 조회
				System.out.println("하나의 방 조회 화면");
				
				System.out.println("조회할 방 번호 입력");
				vo.setNum(1);
				
				RoomVO vo2 = dao.selectOne(vo);
				System.out.println("방번호/이용시간/이용여부");
				System.out.print(vo2.getNum()+ " / ");
				System.out.print(vo2.getTime()+ " / ");
				if (vo2.getRemain() == 1) {
					System.out.println("이용중");
				}
				else if (vo2.getRemain() == 0) {
					System.out.println("이용안함");
				}
				
			} // 하나의 방 조회 끝
			
			
			
		} // 관리자 화면 끝


	} // end main()

}
