package nc.mytest.lover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FirstController {
	
	@RequestMapping(value = "/")
	String home() {
		return "Helloword";
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstController.class, args);
	}
}
