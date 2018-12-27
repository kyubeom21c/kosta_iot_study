package survey;

import java.util.ArrayList;
import java.util.List;

public class QuestionVO {

	private String title;  // 설문조사 제목
	private String Summary;  //설문 기관 및 설문 설명
	public List<String[]> qnaL = new ArrayList<>();  //각 질문갯수 = 리스트 갯수.
	public String[] qna = new String[6]; //qna[0] = 질문 , qna[1] = 첫번째 답변 보기
								//qna[2] = 두번째 답변 보기 ...
								//qna[5] = 사용자가 선택한 보기의 번호
	public int questionNum;
	public int count = 0;     
	public List<String> answers = new ArrayList<>(); // 마지막 selecAll에서 사용될 임시저장소.
	
	private String gender;		//사용자에게 받은 성별정보를 넣을 변수
	private String name;		//사용자에게 받은 이름 정보를 넣을 변수
	private String age;			//사용자에게 받은 나이정보를 넣을 변수
	private int num;			//DB에서 불러온 NUM을 저장할 변수
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
