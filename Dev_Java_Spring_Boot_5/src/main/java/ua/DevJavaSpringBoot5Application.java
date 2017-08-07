package ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.repository.ComponentRepository;

@SpringBootApplication
public class DevJavaSpringBoot5Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DevJavaSpringBoot5Application.class, args);
		ComponentRepository repository = run.getBean(ComponentRepository.class);
		System.out.println(repository.findAll());
	}
}