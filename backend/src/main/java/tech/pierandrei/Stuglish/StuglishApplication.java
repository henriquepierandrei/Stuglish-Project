package tech.pierandrei.Stuglish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StuglishApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuglishApplication.class, args);
	}

}
