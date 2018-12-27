package test.com;

public class Test01ScoreVO {

	String name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	String grade;
	
	public Test01ScoreVO() {
	}
	
	public Test01ScoreVO(String name,int kor,int eng,int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
		avg = total/3.0;
		if(avg>=90) {
			grade = "A";
		}else if(avg>=80) {
			grade = "B";
		}else if(avg>=70) {
			grade = "C";
		}else {
			grade = "°ú¶ô";
		}
	}
	
}
