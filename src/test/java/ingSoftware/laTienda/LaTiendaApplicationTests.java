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

}
