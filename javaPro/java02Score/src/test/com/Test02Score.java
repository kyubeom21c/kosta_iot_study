package test.com;

public class Test02Score {
	public static void main(String[] args) {
		System.out.println("성적처리프로그램");
		System.out.println("이름을 입력하세요");
		String name = "kim";
		System.out.println(name);
		System.out.println("국어점수를 입력하세요");
		int kor = 100;
		System.out.println(kor);
		System.out.println("영어점수를 입력하세요");
		int eng = 100;
		System.out.println(eng);
		System.out.println("수학점수를 입력하세요");
		int math = 100;
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
		grade = avg>=90?"A":
				avg>=80?"B":
				avg>=70?"C":"과락";
		System.out.println("등급:["+grade+"]");
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
		
	}
}
