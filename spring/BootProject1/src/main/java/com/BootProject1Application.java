package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//부트스트램 클래스(시작 클래스) - @springBootApplication이 붙어있음
/*@SpringBootApplicaton
 * @Configuration : 설정파일(xml대신으로 등장, bean생성 가능)
 * @ComponentScan : 현재 부트스트랩 클래스가 포함된 패키지를 기준으로 하위 패키지를 스캔해서 필요한 객체를 생성하거나 주입시켜줌
 * : @Component, @Service, @Repository, @AutoWired 
   @CompoenentScan(basePackages={"com.aa", "com.bb"})
 * @EnableAutoConfiguration : boot가 작업하는데 필요한 추가 빈들을 자동으로 생성해서 활성화시킴
 * */
@SpringBootApplication
public class BootProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootProject1Application.class, args);
	}

}
