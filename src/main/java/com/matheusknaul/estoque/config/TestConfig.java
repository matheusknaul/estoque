package com.matheusknaul.estoque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusknaul.estoque.services.DBService;

@Configuration
@Profile("'test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
