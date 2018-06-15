package third.global.exceptionHandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestGlobalDefaultExceptionHandler {
	@GetMapping("/exce")
	public int testGlobalDefaultExceptionHandler() {
		return 100 / 0;
	}
}
