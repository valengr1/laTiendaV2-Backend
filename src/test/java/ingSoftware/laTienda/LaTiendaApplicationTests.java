package ingSoftware.laTienda;
import ingSoftware.laTienda.wsdl.ObjectFactory;
import ingSoftware.laTienda.wsdl.TipoComprobante;
import ingSoftware.laTienda.wsdl.TipoDocumento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LaTiendaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void redondearADosDigitos(){
		Double numero = 82.0;
		numero = Math.round(numero * 100.0)/100.0;
		Assertions.assertEquals(82.00, numero);
	}

	@Test
	public void facturaAShouldBe1(){
		String comprobante = TipoComprobante.FACTURA_A.value();
		ObjectFactory factory = new ObjectFactory();
		Assertions.assertEquals("FacturaA", comprobante);
	}

	@Test
	public void redondearDecimales() {
		double parteEntera, resultado;
		resultado = 120000.35532;
		parteEntera = Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10, 2);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10, 2))+parteEntera;
		Assertions.assertEquals(120000.36, resultado);
	}
}
