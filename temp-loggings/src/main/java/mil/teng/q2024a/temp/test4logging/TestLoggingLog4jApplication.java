package mil.teng.q2024a.temp.test4logging;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class TestLoggingLog4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestLoggingLog4jApplication.class, args);
	}

}
