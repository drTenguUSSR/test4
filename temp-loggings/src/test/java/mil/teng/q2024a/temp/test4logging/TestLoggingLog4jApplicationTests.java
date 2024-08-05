package mil.teng.q2024a.temp.test4logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestLoggingLog4jApplicationTests {
	private static final Logger logger=LoggerFactory.getLogger(TestLoggingLog4jApplicationTests.class);

	@Test
	void contextLoads() {
		logger.debug("contextLoads test running");
	}

}
