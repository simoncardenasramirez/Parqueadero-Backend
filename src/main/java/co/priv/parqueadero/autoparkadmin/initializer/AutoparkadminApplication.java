package co.priv.parqueadero.autoparkadmin.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"co.priv.parqueadero.controller"})
public class AutoparkadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoparkadminApplication.class, args);
	}

}
