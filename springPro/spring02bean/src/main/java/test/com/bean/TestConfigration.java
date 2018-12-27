package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfigration {
	private static final Logger logger = LoggerFactory.getLogger(TestConfigration.class);

	public TestConfigration() {
		logger.info("TestConfigration()...");
	}
	
	@Bean
	public TestBean3 getTestBean3() {
//		return new TestBean3();
		return new TestBean3(11,22,33);
	}
	@Bean
	public TestBean4 getTestBean4() {
		TestBean4 tb4 = new TestBean4();
		tb4.setId("tester");
		tb4.setPw("8094756079586e5");
		return tb4;
	}
}
