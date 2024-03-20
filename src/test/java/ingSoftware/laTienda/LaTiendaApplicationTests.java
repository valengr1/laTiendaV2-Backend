package ingSoftware.laTienda;
import ingSoftware.laTienda.DTOs.StockYCantidad;
import ingSoftware.laTienda.controller.VentaControlador;
import ingSoftware.laTienda.model.Cliente;
import ingSoftware.laTienda.model.Stock;
import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.*;
import ingSoftware.laTienda.service.VentaServicio;
import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class LaTiendaApplicationTests {
	@Mock
	ClienteRepositorio clienteRepositorio;

	@Mock
	VendedorRepositorio vendedorRepositorio;

	@Mock
	StockRepositorio stockRepositorio;

	@Mock
	ComprobanteRepositorio comprobanteRepositorio;

	@Mock
	VentaRepositorio ventaRepositorio;

	VentaControlador ventaControlador;

	@Mock
	List<String> mockList;

	@Test
	public void test() {
		when(mockList.get(0)).thenReturn("Hola Mundo");
		assertEquals("Hola Mundo", mockList.get(0));
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
		assertEquals(43501537L, solicitudAutorizacion.getNumeroDocumento());
		assertEquals(1000.00, solicitudAutorizacion.getImporteTotal());
		assertEquals(210.00, solicitudAutorizacion.getImporteIva());
		assertEquals(790.00, solicitudAutorizacion.getImporteNeto());
		assertEquals(1, solicitudAutorizacion.getNumero());
		assertEquals(TipoComprobante.FacturaB, solicitudAutorizacion.getTipoComprobante());
		assertEquals(TipoDocumento.Dni, solicitudAutorizacion.getTipoDocumento());
	}
}
