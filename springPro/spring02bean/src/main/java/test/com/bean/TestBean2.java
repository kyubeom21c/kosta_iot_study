package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean2 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean2.class);

	public int kor;
	public int eng;
	public int math;
	public TestBean tb;
	
	
	public TestBean2() {
		logger.info("TestBean2()....");
	}

	public TestBean2(TestBean tb) {
		logger.info("TestBean2(TestBean tb)....");
		this.tb = tb;
	}
	
	public TestBean2(int kor,int eng, int math) {
		logger.info("TestBean2(int kor,int eng, int math)....");
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}



}
