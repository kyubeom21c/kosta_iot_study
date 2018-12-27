package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test03Score {
	public static void main(String[] args) throws IOException {
		System.out.println("성적처리프로그램 start");
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		//while문을 사용하여 반복하는 프로그램을완성.
		//각변수의 데이터는 input을통해 받으시오.
		//종료시x를 입력받아서 처리하도록 하시오.
		
		
//		System.out.println("1.성적처리 2.게시판");
//		String menu = br.readLine();
//		if(menu.equals("1")) {
//			
//		}else {
//			
//		}
		
		String x = "";
		while(!x.equals("x")) {
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println(name);
			System.out.println("국어점수를 입력하세요");
			int kor = Integer.parseInt(br.readLine());
			System.out.println(kor);
			System.out.println("영어점수를 입력하세요");
			int eng = Integer.parseInt(br.readLine());
			System.out.println(eng);
			System.out.println("수학점수를 입력하세요");
			int math = Integer.parseInt(br.readLine());
			System.out.println(math);
			
			int total = kor+eng+math;
			System.out.println("총점:"+total);
			//평균용 변수선언할것.avg(double)
			double avg = total/3.0;
			System.out.println("평균:"+avg);
			//평균점수를 기준으로
			//90점이상 A,
			//80점이상 B,
			//70점이상 C,
			//70점미만 "과락"
			//처리하는 프로그램을 추가하세요
			//등급용 변수선언할것.grade(String)
			String grade = null;//null(주소값이없다)
			//switch case break
			int key = (int)avg/10;
			System.out.println(">>>>"+key);
			switch (key) {
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;

			default:
				grade = "과락";
				break;
			}
			
			System.out.println("등급:["+grade+"]");
			
			
			
			System.out.println("종료시...x");
			x = br.readLine();
		}
		
		
		//이름을 입력하세요
		//홍길동
		//국어점수를 입력하세요
		//99
		//영어점수를 입력하세요
		//98
		//수학점수를 입력하세요
		//97
		//총점:99+98+97=294
		//평균:총점/3=98
		//등급:A
		System.out.println("성적처리프로그램 end");
	}//end main()
}//end class
