package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean3 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean3.class);
	public int kor;
	public int eng;
	public int math;
	public TestBean3() {
		logger.info("TestBean3()....");
	}

	public TestBean3(int kor, int eng, int math) {
		logger.info("TestBean3(int kor, int eng, int math)....");
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

}
