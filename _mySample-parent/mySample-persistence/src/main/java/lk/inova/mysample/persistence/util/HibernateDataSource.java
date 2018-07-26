/**
 * 
 */
package lk.inova.mysample.persistence.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author imasmohamed
 * @Description hibernate related configuration and beans are defined in this
 *              class
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
		"lk.inova.mysample.persistence.dao" })
public class HibernateDataSource {
	Map<String, Object> properties = new HashMap<String, Object>();

	/*private Map<String, Object> getBasicProperties() {
		Map<String, Object> basicProps = new HashMap<String, Object>();
		basicProps.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		basicProps.put("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
		basicProps.put("hibernate.connection.url", "jdbc:oracle:thin:@//localhost:1521/mysampleDb");
		basicProps.put("hibernate.connection.username", "mysampleuser");
		basicProps.put("hibernate.connection.password", "aa123");
		basicProps.put("hibernate.connection.autocommit", false);
		basicProps.put("hibernate.hbm2ddl.auto", "update");
		
		return basicProps;
	}
	*/
	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		DataSource source  = (DataSource) DataSourceBuilder.create().build();
		
		//set tomcat pooling properties
		  PoolProperties p = new PoolProperties();
          p.setMaxWait(20000);
          p.setInitialSize(10);
          p.setMaxActive(50);
          p.setMaxIdle(20);
          p.setMinIdle(15);
          p.setTestWhileIdle(true);
          p.setTimeBetweenEvictionRunsMillis(300000);
          p.setMinEvictableIdleTimeMillis(400000);
          p.setTestOnBorrow(true);
          p.setValidationInterval(300000);
          p.setValidationQuery("select 1 from dual");
          p.setConnectionProperties("oracle.jdbc.timezoneAsRegion=false;");
         
          
          
         
          source.setPoolProperties(p);
		System.out.println("Data source ########:"+source.toString());
		
		return source;
	}
	
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		/*'hibernate.ddl-auto=update' to use this property,we have to set below
		hibernate.default_schema property!other wise "More than one table found in
		namespace (, ) - SchemaExtractionException" will be occurred."
		issue raised:https://stackoverflow.com/a/36934503/2672101
		'hibernate.ddl-auto=update' property is used in application.propeties file.
		*/	
		properties.put("hibernate.default_schema", "mysampleuser");//FIXME make username confiurable
		return builder.dataSource(dataSource).packages("lk.inova.mysample.common.entities").properties(properties)
				.build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Primary
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("Hibernate SessionFactory not found.");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
