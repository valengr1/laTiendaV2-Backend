package ingSoftware.laTienda.service;
import ingSoftware.laTienda.DTOs.StockYCantidad;
import ingSoftware.laTienda.model.*;
import ingSoftware.laTienda.model.Comprobante;
import ingSoftware.laTienda.model.TipoDocumento;
import ingSoftware.laTienda.repository.*;
import ingSoftware.laTienda.wsdl.*;
import ingSoftware.laTienda.wsdl.TipoComprobante;
import org.hibernate.query.sqm.sql.internal.AnyDiscriminatorPathInterpretation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class VentaServicioTest {
    @Mock
    VentaRepositorio ventaRepositorio;
    @Mock
    ClienteRepositorio clienteRepositorio;
    @Mock
    VendedorRepositorio vendedorRepositorio;
    @Mock
    StockRepositorio stockRepositorio;
    @Mock
    ComprobanteRepositorio comprobanteRepositorio;
    @Mock
    AutorizacionAFIPServicio autorizacionAfipServicio;
    @InjectMocks
    VentaServicio ventaServicio;

//    Cliente cliente;
//    Vendedor vendedor;
//    PuntoVenta puntoVenta;
//    Sucursal sucursal;
//    Stock stock;
//    Articulo articulo;
//    Venta venta;
//    Pago pago;
//    Comprobante comprobante;
//    List<StockYCantidad> stocksYCantidades = new ArrayList<>();
//    String token;
//    SolicitarCaeResponse solicitarCaeResponse;
//    ResultadoSolicitudAutorizacion resultadoSolicitudAutorizacion;

    @BeforeEach
    void setUp() throws DatatypeConfigurationException {
        MockitoAnnotations.openMocks(this);


//
//        vendedor = new Vendedor();
//        vendedor.setLegajo(50545L);
//        vendedor.setNombre("Carlos");
//        vendedor.setApellido("Gomez");
//
//        puntoVenta = new PuntoVenta();
//        puntoVenta.setId(2L);
//
//        puntoVenta.setSucursal(sucursal);
//        vendedor.setPuntoVenta(puntoVenta);
//
//
//
//
//
//        venta = new Venta();
//        venta.agregarLineaVenta(stock, 1);
//        venta.setCliente(cliente);
//        venta.setVendedor(vendedor);
//        pago = venta.crearPago(1000.0);
//        venta.setPago(pago);
//        LocalDateTime fecha = LocalDateTime.now();
//        venta.setFecha(fecha);
//        int ultimoNumeroComprobante = comprobanteRepositorio.obtenerUltimoNumeroComprobante();
//        comprobante = venta.crearComprobante("Consumidor Final", ultimoNumeroComprobante + 1);
//        venta.setComprobante(comprobante);
//        token = "222D6106-B8FA-4F08-B0E6-A2E89AE02247PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhaG9tbywgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiIHVuaXF1ZV9pZD0iNDE5NTE1MTA4OCIgZ2VuX3RpbWU9IjE3MTA5MzgyMTkiIGV4cF90aW1lPSIxNzEwOTgxNDc5Ii8+CiAgICA8b3BlcmF0aW9uIHR5cGU9ImxvZ2luIiB2YWx1ZT0iZ3JhbnRlZCI+CiAgICAgICAgPGxvZ2luIGVudGl0eT0iMzM2OTM0NTAyMzkiIHNlcnZpY2U9IndzZmUiIHVpZD0iU0VSSUFMTlVNQkVSPUNVSVQgMjAyNTk5MjcxNjIsIENOPXNnZWZqdjA1IiBhdXRobWV0aG9kPSJjbXMiIHJlZ21ldGhvZD0iMjIiPgogICAgICAgICAgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIGtleT0iMjAyNTk5MjcxNjIiIHJlbHR5cGU9IjQiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4K";
//        solicitarCaeResponse = new SolicitarCaeResponse();
//        resultadoSolicitudAutorizacion = new ResultadoSolicitudAutorizacion();
//        ObjectFactory factory = new ObjectFactory();
//        resultadoSolicitudAutorizacion.setCae(factory.createResultadoSolicitudAutorizacionCae("12345678901234"));
//        resultadoSolicitudAutorizacion.setError(factory.createResultadoSolicitudAutorizacionError(null));
//        resultadoSolicitudAutorizacion.setEstado(factory.createResultadoSolicitudAutorizacionEstado(EstadoSolicitud.APROBADA));
//        resultadoSolicitudAutorizacion.setTipoComprobante(factory.createResultadoSolicitudAutorizacionTipoComprobante(TipoComprobante.FacturaB));
//        resultadoSolicitudAutorizacion.setObservacion(factory.createResultadoSolicitudAutorizacionObservacion(null));
//        GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
//        XMLGregorianCalendar fechaSolicitud = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
//        resultadoSolicitudAutorizacion.setFechaDeVencimiento(factory.createResultadoSolicitudAutorizacionFechaDeVencimiento(fechaSolicitud.toString()));
//        solicitarCaeResponse.setSolicitarCaeResult(factory.createSolicitarCaeResponseSolicitarCaeResult(resultadoSolicitudAutorizacion));
    }

    @Test
    public void siElClienteNoExisteSeDeberiaLanzarUnaExcepcion() {
        when(clienteRepositorio.findCliente(anyLong())).thenReturn(null); // Simulamos un cliente inexistente
        assertThrows(IllegalArgumentException.class, () -> ventaServicio.buscarCliente(43501537L));
    }

    @Test
    public void alBuscarClientePorSuNumeroDeDocumentoDeberiaRetornarElCliente(){
        CondicionTributaria condicionTributaria = new CondicionTributaria();
        condicionTributaria.setId(5L);
        condicionTributaria.setDescripcion("Consumidor Final");
        Cliente cliente = new Cliente();
        cliente.setNumeroDocumento(43501537L);
        cliente.setApellido("Perez");
        cliente.setNombre("Juan");
        cliente.setCondicionTributaria(condicionTributaria);
        cliente.setDireccion("Av. Siempre Viva 123");
        cliente.setTelefono("123456789");
        cliente.setTipoDocumento(TipoDocumento.DNI);
        when(clienteRepositorio.findCliente(anyLong())).thenReturn(cliente);
        Cliente clienteEnDb = ventaServicio.buscarCliente(43501537L);
        assertNotNull(clienteEnDb.getNumeroDocumento());
        assertNotNull(clienteEnDb.getTipoDocumento());
        assertNotNull(clienteEnDb.getNombre());
        assertNotNull(clienteEnDb.getCondicionTributaria());
        assertNotNull(clienteEnDb.getApellido());
        assertNotNull(clienteEnDb.getTelefono());
        assertNotNull(clienteEnDb.getDireccion());
    }

    @Test
    public void siNoExisteElVendedorSeDeberiaLanzarUnaExcepcion() {
        when(vendedorRepositorio.findByLegajo(anyLong())).thenReturn(null); // Simulamos un vendedor inexistente
        assertThrows(IllegalArgumentException.class, () -> ventaServicio.buscarVendedor(50545L));
    }

    @Test
    public void alBuscarUnVendedorPorSuNumeroDeLegajoSeDeberiaRetornarAlVendedor(){
        Vendedor vendedor = new Vendedor();
        vendedor.setLegajo(50545L);
        vendedor.setNombre("Carlos");
        vendedor.setApellido("Gomez");
        PuntoVenta puntoVenta = new PuntoVenta();
        puntoVenta.setId(2L);
        Sucursal sucursal = new Sucursal();
        sucursal.setId(1L);
        puntoVenta.setSucursal(sucursal);
        vendedor.setPuntoVenta(puntoVenta);

        when(vendedorRepositorio.findByLegajo(anyLong())).thenReturn(vendedor);

        Vendedor vendedorEnDb = ventaServicio.buscarVendedor(50545L);

        Long legajo = vendedorEnDb.getLegajo();
        String nombre = vendedorEnDb.getNombre();
        String apellido = vendedorEnDb.getApellido();
        PuntoVenta puntoVentaVendedor = vendedorEnDb.getPuntoVenta();

        assertNotNull(legajo);
        assertNotNull(nombre);
        assertNotNull(apellido);
        assertNotNull(puntoVentaVendedor);
    }

    @Test
    public void siLaCantidadDeStockEsInSuficienteSeDeberiaLanzarUnaExcepcion() {
        StockYCantidad stockYCantidad = new StockYCantidad();
        stockYCantidad.setStockid(14L);
        stockYCantidad.setCantidadRequerida(10);
        List<StockYCantidad> stocksYCantidades = new ArrayList<>();
        stocksYCantidades.add(stockYCantidad);
        Stock stockEnDb = new Stock();
        stockEnDb.setCantidad(1);

        when(stockRepositorio.findStockByIdAndSucursalId(anyLong(), anyLong())).thenReturn(stockEnDb); // Simulamos un stock con cantidad disponible menor que la cantidad requerida

        assertThrows(IllegalArgumentException.class, () -> ventaServicio.verificarStockSuficiente(stocksYCantidades, 1L));
    }

    @Test
    public void siElStockNoExisteSeDeberiaLanzarUnaExcepcion() {
        StockYCantidad stockYCantidad = new StockYCantidad();
        stockYCantidad.setStockid(14L);
        stockYCantidad.setCantidadRequerida(10);
        List<StockYCantidad> stocksYCantidades = new ArrayList<>();
        stocksYCantidades.add(stockYCantidad);
        when(stockRepositorio.findStockByIdAndSucursalId(anyLong(), anyLong())).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> ventaServicio.verificarStockSuficiente(stocksYCantidades, 1L));
    }




//    private static Articulo getArticulo() {
//        Articulo articulo = new Articulo();
//        articulo.setDescripcion("Articulo de prueba");
//        articulo.setCosto(1000.0);
//        articulo.setMargenGanancia(0.5);
//        articulo.setCodigo(1L);
//        Categoria categoria = new Categoria();
//        categoria.setId(1L);
//        categoria.setDescripcion("Categoria de prueba");
//        articulo.setCategoria(categoria);
//        Marca marca = new Marca();
//        marca.setId(1L);
//        marca.setDescripcion("Marca de prueba");
//        articulo.setMarca(marca);
//        TipoTalle tipoTalle = new TipoTalle();
//        tipoTalle.setId(1L);
//        tipoTalle.setDescripcion("Tipo talle de prueba");
//        articulo.setTipoTalle(tipoTalle);
//        return articulo;
//    }

//    private static Stock getStock() {
//        Stock stock = new Stock();
//        stock.setId(14L);
//        stock.setCantidad(10);
//        Sucursal sucursal = new Sucursal();
//        sucursal.setId(1L);
//        stock.setSucursal(sucursal);
//        Color color = new Color();
//        color.setId(1L);
//        color.setDescripcion("Rojo");
//        stock.setColor(color);
//        Talle talle = new Talle();
//        talle.setId(1L);
//        talle.setDescripcion("M");
//        stock.setTalle(talle);
//        Articulo articulo = getArticulo();
//        stock.setArticulo(articulo);
//        return stock;
//    }

//    @Test
//    public void testRegistroVentaExitoso() throws DatatypeConfigurationException {
//        when(clienteRepositorio.findCliente(anyLong())).thenReturn(cliente); // Simulamos un cliente existente
//        when(vendedorRepositorio.findByLegajo(anyLong())).thenReturn(vendedor); // Simulamos un vendedor existente
//        when(stockRepositorio.findStockByIdAndSucursalId(anyLong(), anyLong())).thenReturn(stock); // Simulamos un stock existente
//        when(comprobanteRepositorio.obtenerUltimoNumeroComprobante()).thenReturn(100); // Simulamos un número de comprobante
//        when(ventaRepositorio.save(any(Venta.class))).thenReturn(venta); // Simulamos que la venta se guardó correctamente
//        when(autorizacionAfipServicio.solicitarCae(anyString(), any(SolicitudAutorizacion.class))).thenReturn(solicitarCaeResponse); // Simulamos que la solicitud de CAE fue exitosa
//        //String resultado = ventaServicio.registrar(stocksYCantidades, 50545L, 43501537, token);
//        //assertEquals("Venta registrada con éxito", resultado);
//    }
}