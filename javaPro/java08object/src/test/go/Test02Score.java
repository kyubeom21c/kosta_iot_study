package test.go;

public class Test02Score {
	
	//1.속성: 전역변수,field
	String name = "kim";
	int kor = 100;
	int eng = 100;
	int math = 100;
	int total = kor+eng+math;
	double avg = total/3.0;
	String grade = "A";
	
	//2.생성자:목적 >>field 초기화
	public Test02Score() {
		System.out.println("Test02Score()");
		name = "yang";
		kor = 99;
		eng = 99;
		math = 99;
		total = kor+eng+math;
		avg = total/3.0;
		if(avg>=90) {
			grade = "A";
		}else if(avg>=80) {
			grade = "B";
		}else if(avg>=70) {
			grade = "C";
		}else {
			grade = "과락";
		}
	}

	

}//end class
