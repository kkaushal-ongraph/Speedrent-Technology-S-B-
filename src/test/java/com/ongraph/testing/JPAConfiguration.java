package com.ongraph.testing;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.ongraph.test")
@ComponentScan("com.ongraph.test.services")
@PropertySource("classpath:persistence.properties")
@EnableTransactionManagement
public class JPAConfiguration {

	  @Autowired
	    private Environment env;

	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getProperty("jdbc.url"));
	        dataSource.setUsername(env.getProperty("jdbc.user"));
	        dataSource.setPassword(env.getProperty("jdbc.pass"));

	        return dataSource;
	    }

	    private Properties additionalProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        return properties;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        //JpaVendorAdapteradapter can be autowired as well if it's configured in application properties.
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setGenerateDdl(false);

	        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	        factory.setJpaVendorAdapter(vendorAdapter);
	        //Add package to scan for entities.
	        factory.setPackagesToScan("com.ongraph.test");
	        factory.setDataSource(dataSource());
	        factory.setJpaProperties(additionalProperties());
	        return factory;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager txManager = new JpaTransactionManager();
	        txManager.setEntityManagerFactory(entityManagerFactory);
	        return txManager;
	    }
}

