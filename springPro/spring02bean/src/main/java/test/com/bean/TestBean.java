package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
	private static final Logger logger = LoggerFactory.getLogger(TestBean.class);

	public String name;

	public TestBean() {
		logger.info("TestBean()....");
		name = "kim";
	}

	public TestBean(String name) {
		logger.info("TestBean(String name)....");
		this.name = name;
	}

}
