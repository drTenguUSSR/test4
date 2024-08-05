package mil.teng.q2024a.temp.test4logging;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class TestLoggingLog4jApplication {
	private static final Logger logger = LoggerFactory.getLogger(TestLoggingLog4jApplication.class);

	public static void main(String[] args) {
		logger.debug("app started");
		SpringApplication.run(TestLoggingLog4jApplication.class, args);

	}

}
