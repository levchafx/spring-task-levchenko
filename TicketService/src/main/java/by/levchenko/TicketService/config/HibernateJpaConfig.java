package by.levchenko.TicketService.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.levchenko.TicketService")
@PropertySource("classpath:db.properties")
public class HibernateJpaConfig {
	@Autowired
	Environment env;

	@PostConstruct
	public void init() {
		final String[] args = new String[] { "-tcpPort", "8092", "-tcpAllowOthers", "true" };
		try {
			Server.createTcpServer(args).start();
		} catch (SQLException e) {

		}
	}

	@Bean

	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		em.setPackagesToScan("by.levchenko.TicketService.domain");
		em.setPersistenceUnitName("name");
		return em;
	}

	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor",
				"org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor");

		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("packagesToScan", "by.levchenko.TicketService");

		properties.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
		properties.setProperty("javax.persistence.schema-generation.create-source", "script");
		properties.setProperty("javax.persistence.schema-generation.create-script-source", "META-INF/create.sql");

		properties.setProperty("javax.persistence.schema-generation.drop-source", "script");
		properties.setProperty("javax.persistence.schema-generation.drop-script-source", "META-INF/drop.sql");
		properties.setProperty("javax.persistence.sql-load-script-source", "META-INF/data.sql");

		return properties;

	}

	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty("driver"));
		hikariConfig.setJdbcUrl(env.getProperty("url"));
		hikariConfig.setUsername(env.getProperty("userName"));
		hikariConfig.setPassword(env.getProperty("password"));

		hikariConfig.setMaximumPoolSize(5);
		hikariConfig.setConnectionTestQuery("SELECT 1");
		hikariConfig.setPoolName("springHikariCP");

		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
