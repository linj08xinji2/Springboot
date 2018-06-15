package four.handlerInterceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
	@RequestMapping("/api")
	public String test() {
		return "测试拦截器";
	}
}
