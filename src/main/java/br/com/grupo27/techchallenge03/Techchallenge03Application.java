package br.com.grupo27.techchallenge03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.grupo27.techchallenge03")
public class Techchallenge03Application {

	public static void main(String[] args) {
		SpringApplication.run(Techchallenge03Application.class, args);
	}

}
