package ingSoftware.laTienda;
import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

@SpringBootTest
class LaTiendaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void redondearADosDigitos(){
		Double numero = 82.00;
		numero = Math.round(numero * 100.0)/100.0;
		Assertions.assertEquals(82.00, numero);
	}

	@Test
	public void facturaAShouldBe1(){
		String comprobante = TipoComprobante.FacturaA.value();
		ObjectFactory factory = new ObjectFactory();
		Assertions.assertEquals("FacturaA", comprobante);
	}

	@Test
	public void redondearDecimales() {
		double parteEntera, resultado;
		resultado = 120000.0;
		parteEntera = Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10, 2);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10, 2))+parteEntera;
		Assertions.assertEquals(120000.00, resultado);
	}

	@Test
	public void solicitarAutorizacion() throws DatatypeConfigurationException {
		GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
		XMLGregorianCalendar fechaSolicitud = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<XMLGregorianCalendar> fechaJaxb = factory.createSolicitudAutorizacionFecha(fechaSolicitud);
		long numero = 1;
		SolicitudAutorizacion solicitudAutorizacion = new SolicitudAutorizacion();
		solicitudAutorizacion.setFecha(fechaJaxb);
		solicitudAutorizacion.setImporteIva(210.00);
		solicitudAutorizacion.setImporteNeto(790.00);
		solicitudAutorizacion.setImporteTotal(1000.00);
		solicitudAutorizacion.setNumero(numero);
		solicitudAutorizacion.setNumeroDocumento(43501537L);
		solicitudAutorizacion.setTipoComprobante(TipoComprobante.FacturaB);
		solicitudAutorizacion.setTipoDocumento(TipoDocumento.Dni);
		Assertions.assertEquals(43501537L, solicitudAutorizacion.getNumeroDocumento());
		Assertions.assertEquals(1000.00, solicitudAutorizacion.getImporteTotal());
		Assertions.assertEquals(210.00, solicitudAutorizacion.getImporteIva());
		Assertions.assertEquals(790.00, solicitudAutorizacion.getImporteNeto());
		Assertions.assertEquals(1, solicitudAutorizacion.getNumero());
		Assertions.assertEquals(TipoComprobante.FacturaB, solicitudAutorizacion.getTipoComprobante());
		Assertions.assertEquals(TipoDocumento.Dni, solicitudAutorizacion.getTipoDocumento());
	}
}
