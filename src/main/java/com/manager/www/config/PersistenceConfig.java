package com.manager.www.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.manager.www.repositories")
public class PersistenceConfig {

	
	  @Bean
	  public PlatformTransactionManager transactionManager()
	  {
	    EntityManagerFactory factory = entityManagerFactory().getObject();
	    return new JpaTransactionManager(factory);
	  }
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	  {
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(Boolean.TRUE);
	    vendorAdapter.setShowSql(Boolean.TRUE);
	    factory.setDataSource(dataSource());
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.manager.www.entities");
	    Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	    jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    factory.setJpaProperties(jpaProperties);
	    factory.afterPropertiesSet();
	    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
	    return factory;
	  }
	  @Bean
	  public HibernateExceptionTranslator hibernateExceptionTranslator()
	  {
	    return new HibernateExceptionTranslator();
	  }
	  @Bean
	  public DataSource dataSource()
	  {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/joy1joy?useUnicode=true&characterEncoding=UTF-8");
	    dataSource.setUsername("root");
	    dataSource.setPassword("");
	    return dataSource;
	  }
	  
	  
	  
//	  @Bean
//	  public DataSourceInitializer dataSourceInitializer(DataSource dataSource) 
//	  {
//	    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//	    dataSourceInitializer.setDataSource(dataSource);
//	    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//	    databasePopulator.addScript(new ClassPathResource("db.sql"));
//	    dataSourceInitializer.setDatabasePopulator(databasePopulator);
//	    dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
//	    return dataSourceInitializer;
//	  }	
}
