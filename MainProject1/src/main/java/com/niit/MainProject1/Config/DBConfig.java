package com.niit.MainProject1.Config;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
	@Configuration
	@EnableTransactionManagement
	@ComponentScan(basePackages="com.niit")
	public class DBConfig 
	{
	 @Bean(name="dataSource")
	 public DataSource dataSource()
	 {
		 System.out.println("DB-Data___Source");
		 DriverManagerDataSource dataSource=new DriverManagerDataSource();
		 dataSource.setDriverClassName("org.h2.Driver");
		 dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		 dataSource.setUsername("sa");
		 dataSource.setPassword("sa");
		 return dataSource;
	 }
	 public Properties getHibernateProperties()
	 {
		 System.out.println("DB-HIBpot");

		 Properties hProperties=new Properties();
		 hProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		 hProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		 hProperties.setProperty("hibernate.show_sql", "true");
		 return hProperties;
	 }
	 @Bean(name="sessionFactory")
	 @Autowired
	 public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	 {  
			System.out.println("session Factory ...");
	 LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
	 
	 System.out.println("session Factory 2222");
	 
	 sessionFactory.setDataSource(dataSource);
	 
	 System.out.println("session Factory 333");
	 
	 sessionFactory.setHibernateProperties(getHibernateProperties());
	 
	 System.out.println("session Factory 444");
	 
	 sessionFactory.setPackagesToScan("com.niit");
	 
	 System.out.println("session Factory 555");
	 
	 return sessionFactory;
	 
	 }
	 @Bean(name="transactionManager")
	 @Autowired
	 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	 {

			System.out.println("transaction Factory ...");
		 HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		 transactionManager.setSessionFactory(sessionFactory);
		 return transactionManager;
	 }
	}



