package ua;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ua.argument.resolver.UserHandleMethodArgumentResolver;

@SpringBootApplication
@ImportAutoConfiguration(classes=WebMvcAutoConfiguration.class)
public class DevJavaSpringBoot4Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(DevJavaSpringBoot4Application.class, args);
	}
	
	@Autowired
	UserHandleMethodArgumentResolver userResolver;
	
	@Value("${file.path}")
	private String path;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		argumentResolvers.add(resolver);
		argumentResolvers.add(userResolver);
		super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/*").addResourceLocations("file:"+path);
		super.addResourceHandlers(registry);
	}
	
	
}
