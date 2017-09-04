package ua;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ua.argument.resolver.UserMethodHandlerArgumentResolver;

@SpringBootApplication
@ImportAutoConfiguration(classes=WebMvcAutoConfiguration.class)
public class DevJavaSpringBoot5Application extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(DevJavaSpringBoot5Application.class, args);
	}
	
	@Autowired
	UserMethodHandlerArgumentResolver userResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		argumentResolvers.add(resolver);
		argumentResolvers.add(userResolver);
		super.addArgumentResolvers(argumentResolvers);
	}
}