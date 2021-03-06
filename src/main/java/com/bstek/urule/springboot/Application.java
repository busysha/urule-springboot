package com.bstek.urule.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Jacky.gao
 * @since 2016年10月12日
 */
@SpringBootApplication
@ImportResource({"classpath:urule-console-context.xml","classpath:spring-urule.xml"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}
