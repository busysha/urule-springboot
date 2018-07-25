package com.bstek.urule.springboot;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Jacky.gao
 * @since 2016年10月12日
 */
@Component
public class TestServletRegistration {
	@Bean
	public ServletRegistrationBean registerTestServlet(){
		return new ServletRegistrationBean(new TestServlet(),"/fire");
	}
}
