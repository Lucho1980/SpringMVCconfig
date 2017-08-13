package ar.com.basic.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ar.com.basic.service.UserService;
import ar.com.basic.service.impl.UserServiceImpl;

@EnableJpaRepositories(basePackages = { "ar.com.basic.dao" })
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}

	// Este metodo activa el populador de tablas
	private DatabasePopulator databasePopulator() {

		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("test-data.sql"));
		return databasePopulator;

	}
	
	@Bean
	public UserService userService() {

		return new UserServiceImpl();
	}

	@Bean
	@Qualifier("embedded")
	public DataSource dataSourceEmbedded() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = builder.setType(EmbeddedDatabaseType.HSQL).addScript("dbschema.sql")
				.addScript("test-data.sql").build();
		return embeddedDatabase;
	}

	@Bean // Era JpaTransactionManager
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

		DatabasePopulatorUtils.execute(databasePopulator(), dataSource());// Aplico
																			// el
																			// populator
																			// para
																			// poblar
																			// las
																			// tablas

		return jpaTransactionManager;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		jpaVendorAdapter.setDatabase(Database.MYSQL);

		jpaVendorAdapter.setShowSql(true);

		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());

		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());

		entityManagerFactory.setPackagesToScan("ar.com.basic.dao.impl");// Escanea
																		// todo
																		// lo
																		// que
																		// esta
																		// acá
																		// adentro

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		entityManagerFactory.setJpaProperties(jpaProperties);

		return entityManagerFactory;

	}
}
