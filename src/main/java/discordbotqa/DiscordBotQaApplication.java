package discordbotqa;

import discordbotqa.comenzi.CreatorComenzi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
public class DiscordBotQaApplication {
	private static final Logger logger = LogManager.getLogger(DiscordBotQaApplication.class);
	public static Map<String, CreatorComenzi> comenzi = new HashMap<>();

	public static void main(String[] args) {
		logger.trace("Aplicatia a pornit.");
		SpringApplication.run(DiscordBotQaApplication.class, args);
		ManagerBot.getInstance();
	}

}
