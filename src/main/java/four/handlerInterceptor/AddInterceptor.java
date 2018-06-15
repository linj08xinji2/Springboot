package four.handlerInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义一个类继承WebMvcConfigurerAdapter类，添加@Configuration注解，
 * 将自定义的拦截器添加到拦截器的队列中（@configuration声明当前类是一个配置类，
 * 相当于一个Spring配置的xml文件，这是Spring4.x推荐的配置方式）
 * 
 */
@Configuration
public class AddInterceptor extends WebMvcConfigurerAdapter {

	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		 //addPattern(“/api/**”) 用来指定要拦截的请求路径
		 registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/**");
	}
}
