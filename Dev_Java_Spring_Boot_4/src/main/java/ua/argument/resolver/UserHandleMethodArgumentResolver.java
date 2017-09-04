package ua.argument.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import ua.entity.User;
import ua.repository.UserRepository;

@Component
public class UserHandleMethodArgumentResolver implements HandlerMethodArgumentResolver{

	private static final String ANONIMUS = "anonymousUser";
	
	private final UserRepository repository;
	
	public UserHandleMethodArgumentResolver(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return User.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if(username.equals(ANONIMUS)) return null;
		return repository.findByEmail(username);
	}

}
