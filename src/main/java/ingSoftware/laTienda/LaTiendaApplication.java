package ingSoftware.laTienda;

import ingSoftware.laTienda.client.SoapClient;
import ingSoftware.laTienda.controller.SoapControlador;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LaTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaTiendaApplication.class, args);
	}

}
