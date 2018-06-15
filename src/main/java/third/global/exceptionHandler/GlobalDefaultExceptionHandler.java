package third.global.exceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value=Exception.class)
	public void defaultExceptionHandler(HttpServletRequest request,Exception e){
		e.printStackTrace();
		System.out.println("=================全局异常捕获！！");
	}
}
