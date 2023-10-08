package online.menkar.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class holds the entrypoint for the application at hand.
 */
@SpringBootApplication
public class SchoolApplication {
	/**
	 * Invoked at startup.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
}