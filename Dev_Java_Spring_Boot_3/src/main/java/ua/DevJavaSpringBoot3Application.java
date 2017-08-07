package ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.repository.CargoRepository;
import ua.repository.ModelRepository;

@SpringBootApplication
public class DevJavaSpringBoot3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DevJavaSpringBoot3Application.class, args);
		CargoRepository repository = run.getBean(CargoRepository.class);
		ModelRepository repository2 = run.getBean(ModelRepository.class);
		System.out.println(repository2.findByName("Premium").getId());
		System.out.println(repository.findAll());
	}
}
