package io.dhawal.restdemo;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagaerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		emf.setPackagesToScan("io.dhawal.restdemo.entity");
		
		return emf;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employee-db?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	private Properties jpaProperties(){
		Properties props=new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
		props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING, "False");
		
		return props; 
	}
	
	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf){
		JpaTransactionManager txnManager=new JpaTransactionManager(emf);
		return txnManager;
	}
}
