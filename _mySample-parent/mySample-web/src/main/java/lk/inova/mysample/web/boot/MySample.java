/**
 * 
 */
package lk.inova.mysample.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imasmohamed
 * @Description this is the starting point of application.run this main method to start the application with embedded tom-cat
 */
@SpringBootApplication
@ComponentScan(basePackages= {"lk.inova.mysample.web.controller","lk.inova.mysample.core.service","lk.inova.mysample.persistence","lk.inova.mysample.config"})
@EntityScan(basePackages= {"lk.inova.mysample.common.entities"})

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class/*, HibernateJpaAutoConfiguration.class*/})
public class MySample {

	public static void main(String[] args) {
		SpringApplication.run(MySample.class, args);
	}
}
