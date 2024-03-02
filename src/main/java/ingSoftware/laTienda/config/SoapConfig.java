package ingSoftware.laTienda.config;

import ingSoftware.laTienda.service.AutorizacionAFIPServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("ingSoftware.laTienda.wsdl");
        return marshaller;
    }
    @Bean
    public AutorizacionAFIPServicio getSoapClient(Jaxb2Marshaller marshaller){
        AutorizacionAFIPServicio client = new AutorizacionAFIPServicio();
        client.setDefaultUri("http://istp1service.azurewebsites.net/LoginService.svc");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
