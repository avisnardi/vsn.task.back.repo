package br.com.vsn.tsk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.vsn.tsk.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Value("${prop.teste}")
	private String prop;
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaBaseDeDados() {
		System.out.println(prop);
		System.out.println("strategy:" + strategy);
		this.dbService.instanciaBaseDeDados();
		if (strategy.equals("create")) {
//			this.dbService.instanciaBaseDeDados();
		}
	}

}
