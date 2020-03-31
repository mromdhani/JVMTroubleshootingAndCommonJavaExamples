package be.businesstraining;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.businesstraining.domain.Compte;
import be.businesstraining.services.IComptesService;

@Configuration
@ComponentScan
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfiguration {
	@Autowired
	private Environment env;

	@Bean
	public DataSource buildDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource ds) {

		return new DataSourceTransactionManager(ds);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		context.registerShutdownHook();

		IComptesService service = context.getBean(IComptesService.class);

		Compte c1 = new Compte("NEW_100", "CLIENT_100", new BigDecimal("100.5"));
		Compte c2 = new Compte("NEW_600", "CLIENT_600", new BigDecimal("400.5"));

		try {
			service.createTwoAccounts(c1, c2);
		} catch (Exception e) {
			System.out.println("Ouf ... nous venons de loin ! Message: " + e.getMessage());
		}

		context.close();
		System.out.println(" ==== FIN Du PROGRAMME ======");

	}
}
