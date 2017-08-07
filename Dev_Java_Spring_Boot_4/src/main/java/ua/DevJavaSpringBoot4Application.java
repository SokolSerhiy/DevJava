package ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.repository.CafeRepository;

@SpringBootApplication
public class DevJavaSpringBoot4Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DevJavaSpringBoot4Application.class, args);
		CafeRepository repository = run.getBean(CafeRepository.class);
		System.out.println(repository.findByName("Aasasas"));
	}
}
