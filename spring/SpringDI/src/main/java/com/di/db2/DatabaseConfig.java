package com.di.db2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
	@Bean
	public MySQLDataServiceImpl getMysql() {
		MySQLDataServiceImpl dd = new MySQLDataServiceImpl(1111, 1111);
		dd.setDriver("Dd");
		dd.setUrl("d");
		return dd;
	}
	
	@Bean
	public OracleDataServiceImpl getMyoracle() {
		OracleDataServiceImpl dd = new OracleDataServiceImpl(2222, 2222);
		dd.setDriver("22");
		dd.setUrl("d");
		return dd;
	}
}
