package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean4 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean4.class);

	private String id;
	private String pw;

	public TestBean4() {
		logger.info("TestBean4()....");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
