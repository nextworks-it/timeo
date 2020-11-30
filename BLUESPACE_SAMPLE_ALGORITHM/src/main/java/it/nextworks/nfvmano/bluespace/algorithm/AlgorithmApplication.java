package it.nextworks.nfvmano.bluespace.algorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class AlgorithmApplication {

	@Value("${crossorigin.origin}")
	public static String crossOrigin;
	
	public static void main(String[] args) {
		SpringApplication.run(AlgorithmApplication.class, args);
	}

}
