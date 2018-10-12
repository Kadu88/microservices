package com.ceobarros.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;


import javax.sql.DataSource;


@SpringBootApplication
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

	// mysql
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pet_data_produto");
		dataSource.setUsername("rootapp");
		dataSource.setPassword("Vi0i57qr");

//		// schema init
//		Resource initSchema = new ClassPathResource("scripts/schema.sql");
//		DatabasePopulator databaseCreator = new ResourceDatabasePopulator(initSchema);
//		DatabasePopulatorUtils.execute(databaseCreator, dataSource);
//
//		// schema init
//		Resource initData = new ClassPathResource("scripts/database_00.sql");
//		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initData);
//		DatabasePopulatorUtils.execute(databasePopulator, dataSource);

		return dataSource;
	}

	//H2
//	@Bean
//	public DataSource dataSource() throws InterruptedException {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:file:~/h2db");
//		dataSource.setUsername("h2sa");
//		dataSource.setPassword("admin");
//
//		// schema init
//		Resource initSchema = new ClassPathResource("scripts/schema.sql");
//		DatabasePopulator databaseCreator = new ResourceDatabasePopulator(initSchema);
//		DatabasePopulatorUtils.execute(databaseCreator, dataSource);
//
//		// schema init
//		Resource initData = new ClassPathResource("scripts/database_00_H2.sql");
//		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initData);
//		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
//
//		return dataSource;
//	}


//
//
//	server.port = 9000
//			#H2
//# -Habilitará o acesso ao console do banco de dados
//	spring.h2.console.enabled=true
//			# -URL na qual o console será habilitado
//	spring.h2.console.path=/h2
//#Datasource
//# -URL de acesso ao banco
//	spring.datasource.url=jdbc:h2:file:~/h2db
//# -Usuário de acesso
//	spring.datasource.username=h2sa
//# -Senha de acesso
//	spring.datasource.password=admin
//# -Driver utilizado para conexão
//	spring.datasource.driver-class-name=org.h2.Driver

}
