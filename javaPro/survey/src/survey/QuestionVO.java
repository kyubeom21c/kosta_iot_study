package survey;

import java.util.ArrayList;
import java.util.List;

public class QuestionVO {

	private String title;  // �������� ����
	private String Summary;  //���� ��� �� ���� ����
	public List<String[]> qnaL = new ArrayList<>();  //�� �������� = ����Ʈ ����.
	public String[] qna = new String[6]; //qna[0] = ���� , qna[1] = ù��° �亯 ����
								//qna[2] = �ι�° �亯 ���� ...
								//qna[5] = ����ڰ� ������ ������ ��ȣ
	public int questionNum;
	public int count = 0;     
	public List<String> answers = new ArrayList<>(); // ������ selecAll���� ���� �ӽ������.
	
	private String gender;		//����ڿ��� ���� ���������� ���� ����
	private String name;		//����ڿ��� ���� �̸� ������ ���� ����
	private String age;			//����ڿ��� ���� ���������� ���� ����
	private int num;			//DB���� �ҷ��� NUM�� ������ ����
	
	
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
