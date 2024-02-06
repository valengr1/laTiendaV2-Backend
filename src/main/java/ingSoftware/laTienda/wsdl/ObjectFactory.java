//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.02.05 a las 08:40:28 PM ART 
//


package ingSoftware.laTienda.wsdl;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ingSoftware.laTienda.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Autorizacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Autorizacion");
    private final static QName _UltimoComprobante_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "UltimoComprobante");
    private final static QName _ArrayOfComprobante_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "ArrayOfComprobante");
    private final static QName _Comprobante_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Comprobante");
    private final static QName _SolicitudAutorizacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "SolicitudAutorizacion");
    private final static QName _ResultadoSolicitudAutorizacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "ResultadoSolicitudAutorizacion");
    private final static QName _TipoComprobante_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core", "TipoComprobante");
    private final static QName _TipoDocumento_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core", "TipoDocumento");
    private final static QName _EstadoSolicitud_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core", "EstadoSolicitud");
    private final static QName _SolicitarAutorizacionCodigo_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "codigo");
    private final static QName _SolicitarAutorizacionResponseSolicitarAutorizacionResult_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "SolicitarAutorizacionResult");
    private final static QName _SolicitarUltimosComprobantesToken_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "token");
    private final static QName _SolicitarUltimosComprobantesResponseSolicitarUltimosComprobantesResult_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "SolicitarUltimosComprobantesResult");
    private final static QName _SolicitarCaeSolicitud_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "solicitud");
    private final static QName _SolicitarCaeResponseSolicitarCaeResult_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "SolicitarCaeResult");
    private final static QName _ComprobanteDescripcion_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Descripcion");
    private final static QName _ResultadoSolicitudAutorizacionCae_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Cae");
    private final static QName _ResultadoSolicitudAutorizacionError_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Error");
    private final static QName _ResultadoSolicitudAutorizacionEstado_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Estado");
    private final static QName _ResultadoSolicitudAutorizacionFechaDeVencimiento_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "FechaDeVencimiento");
    private final static QName _ResultadoSolicitudAutorizacionObservacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Observacion");
    private final static QName _ResultadoSolicitudAutorizacionTipoComprobante_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "TipoComprobante");
    private final static QName _SolicitudAutorizacionFecha_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Fecha");
    private final static QName _UltimoComprobanteComprobantes_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Comprobantes");
    private final static QName _AutorizacionToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Token");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ingSoftware.laTienda.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitarAutorizacion }
     * 
     */
    public SolicitarAutorizacion createSolicitarAutorizacion() {
        return new SolicitarAutorizacion();
    }

    /**
     * Create an instance of {@link SolicitarAutorizacionResponse }
     * 
     */
    public SolicitarAutorizacionResponse createSolicitarAutorizacionResponse() {
        return new SolicitarAutorizacionResponse();
    }

    /**
     * Create an instance of {@link Autorizacion }
     * 
     */
    public Autorizacion createAutorizacion() {
        return new Autorizacion();
    }

    /**
     * Create an instance of {@link SolicitarUltimosComprobantes }
     * 
     */
    public SolicitarUltimosComprobantes createSolicitarUltimosComprobantes() {
        return new SolicitarUltimosComprobantes();
    }

    /**
     * Create an instance of {@link SolicitarUltimosComprobantesResponse }
     * 
     */
    public SolicitarUltimosComprobantesResponse createSolicitarUltimosComprobantesResponse() {
        return new SolicitarUltimosComprobantesResponse();
    }

    /**
     * Create an instance of {@link UltimoComprobante }
     * 
     */
    public UltimoComprobante createUltimoComprobante() {
        return new UltimoComprobante();
    }

    /**
     * Create an instance of {@link SolicitarCae }
     * 
     */
    public SolicitarCae createSolicitarCae() {
        return new SolicitarCae();
    }

    /**
     * Create an instance of {@link SolicitudAutorizacion }
     * 
     */
    public SolicitudAutorizacion createSolicitudAutorizacion() {
        return new SolicitudAutorizacion();
    }

    /**
     * Create an instance of {@link SolicitarCaeResponse }
     * 
     */
    public SolicitarCaeResponse createSolicitarCaeResponse() {
        return new SolicitarCaeResponse();
    }

    /**
     * Create an instance of {@link ResultadoSolicitudAutorizacion }
     * 
     */
    public ResultadoSolicitudAutorizacion createResultadoSolicitudAutorizacion() {
        return new ResultadoSolicitudAutorizacion();
    }

    /**
     * Create an instance of {@link ArrayOfComprobante }
     * 
     */
    public ArrayOfComprobante createArrayOfComprobante() {
        return new ArrayOfComprobante();
    }

    /**
     * Create an instance of {@link Comprobante }
     * 
     */
    public Comprobante createComprobante() {
        return new Comprobante();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autorizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Autorizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Autorizacion")
    public JAXBElement<Autorizacion> createAutorizacion(Autorizacion value) {
        return new JAXBElement<Autorizacion>(_Autorizacion_QNAME, Autorizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UltimoComprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UltimoComprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "UltimoComprobante")
    public JAXBElement<UltimoComprobante> createUltimoComprobante(UltimoComprobante value) {
        return new JAXBElement<UltimoComprobante>(_UltimoComprobante_QNAME, UltimoComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfComprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfComprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "ArrayOfComprobante")
    public JAXBElement<ArrayOfComprobante> createArrayOfComprobante(ArrayOfComprobante value) {
        return new JAXBElement<ArrayOfComprobante>(_ArrayOfComprobante_QNAME, ArrayOfComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Comprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Comprobante")
    public JAXBElement<Comprobante> createComprobante(Comprobante value) {
        return new JAXBElement<Comprobante>(_Comprobante_QNAME, Comprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudAutorizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolicitudAutorizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "SolicitudAutorizacion")
    public JAXBElement<SolicitudAutorizacion> createSolicitudAutorizacion(SolicitudAutorizacion value) {
        return new JAXBElement<SolicitudAutorizacion>(_SolicitudAutorizacion_QNAME, SolicitudAutorizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoSolicitudAutorizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResultadoSolicitudAutorizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "ResultadoSolicitudAutorizacion")
    public JAXBElement<ResultadoSolicitudAutorizacion> createResultadoSolicitudAutorizacion(ResultadoSolicitudAutorizacion value) {
        return new JAXBElement<ResultadoSolicitudAutorizacion>(_ResultadoSolicitudAutorizacion_QNAME, ResultadoSolicitudAutorizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoComprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoComprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core", name = "TipoComprobante")
    public JAXBElement<TipoComprobante> createTipoComprobante(TipoComprobante value) {
        return new JAXBElement<TipoComprobante>(_TipoComprobante_QNAME, TipoComprobante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoDocumento }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core", name = "TipoDocumento")
    public JAXBElement<TipoDocumento> createTipoDocumento(TipoDocumento value) {
        return new JAXBElement<TipoDocumento>(_TipoDocumento_QNAME, TipoDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoSolicitud }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EstadoSolicitud }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core", name = "EstadoSolicitud")
    public JAXBElement<EstadoSolicitud> createEstadoSolicitud(EstadoSolicitud value) {
        return new JAXBElement<EstadoSolicitud>(_EstadoSolicitud_QNAME, EstadoSolicitud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "codigo", scope = SolicitarAutorizacion.class)
    public JAXBElement<String> createSolicitarAutorizacionCodigo(String value) {
        return new JAXBElement<String>(_SolicitarAutorizacionCodigo_QNAME, String.class, SolicitarAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autorizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Autorizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "SolicitarAutorizacionResult", scope = SolicitarAutorizacionResponse.class)
    public JAXBElement<Autorizacion> createSolicitarAutorizacionResponseSolicitarAutorizacionResult(Autorizacion value) {
        return new JAXBElement<Autorizacion>(_SolicitarAutorizacionResponseSolicitarAutorizacionResult_QNAME, Autorizacion.class, SolicitarAutorizacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "token", scope = SolicitarUltimosComprobantes.class)
    public JAXBElement<String> createSolicitarUltimosComprobantesToken(String value) {
        return new JAXBElement<String>(_SolicitarUltimosComprobantesToken_QNAME, String.class, SolicitarUltimosComprobantes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UltimoComprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UltimoComprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "SolicitarUltimosComprobantesResult", scope = SolicitarUltimosComprobantesResponse.class)
    public JAXBElement<UltimoComprobante> createSolicitarUltimosComprobantesResponseSolicitarUltimosComprobantesResult(UltimoComprobante value) {
        return new JAXBElement<UltimoComprobante>(_SolicitarUltimosComprobantesResponseSolicitarUltimosComprobantesResult_QNAME, UltimoComprobante.class, SolicitarUltimosComprobantesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "token", scope = SolicitarCae.class)
    public JAXBElement<String> createSolicitarCaeToken(String value) {
        return new JAXBElement<String>(_SolicitarUltimosComprobantesToken_QNAME, String.class, SolicitarCae.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudAutorizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolicitudAutorizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "solicitud", scope = SolicitarCae.class)
    public JAXBElement<SolicitudAutorizacion> createSolicitarCaeSolicitud(SolicitudAutorizacion value) {
        return new JAXBElement<SolicitudAutorizacion>(_SolicitarCaeSolicitud_QNAME, SolicitudAutorizacion.class, SolicitarCae.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoSolicitudAutorizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResultadoSolicitudAutorizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "SolicitarCaeResult", scope = SolicitarCaeResponse.class)
    public JAXBElement<ResultadoSolicitudAutorizacion> createSolicitarCaeResponseSolicitarCaeResult(ResultadoSolicitudAutorizacion value) {
        return new JAXBElement<ResultadoSolicitudAutorizacion>(_SolicitarCaeResponseSolicitarCaeResult_QNAME, ResultadoSolicitudAutorizacion.class, SolicitarCaeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Descripcion", scope = Comprobante.class)
    public JAXBElement<String> createComprobanteDescripcion(String value) {
        return new JAXBElement<String>(_ComprobanteDescripcion_QNAME, String.class, Comprobante.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Cae", scope = ResultadoSolicitudAutorizacion.class)
    public JAXBElement<String> createResultadoSolicitudAutorizacionCae(String value) {
        return new JAXBElement<String>(_ResultadoSolicitudAutorizacionCae_QNAME, String.class, ResultadoSolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Error", scope = ResultadoSolicitudAutorizacion.class)
    public JAXBElement<String> createResultadoSolicitudAutorizacionError(String value) {
        return new JAXBElement<String>(_ResultadoSolicitudAutorizacionError_QNAME, String.class, ResultadoSolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoSolicitud }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EstadoSolicitud }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Estado", scope = ResultadoSolicitudAutorizacion.class)
    public JAXBElement<EstadoSolicitud> createResultadoSolicitudAutorizacionEstado(EstadoSolicitud value) {
        return new JAXBElement<EstadoSolicitud>(_ResultadoSolicitudAutorizacionEstado_QNAME, EstadoSolicitud.class, ResultadoSolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "FechaDeVencimiento", scope = ResultadoSolicitudAutorizacion.class)
    public JAXBElement<String> createResultadoSolicitudAutorizacionFechaDeVencimiento(String value) {
        return new JAXBElement<String>(_ResultadoSolicitudAutorizacionFechaDeVencimiento_QNAME, String.class, ResultadoSolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Observacion", scope = ResultadoSolicitudAutorizacion.class)
    public JAXBElement<String> createResultadoSolicitudAutorizacionObservacion(String value) {
        return new JAXBElement<String>(_ResultadoSolicitudAutorizacionObservacion_QNAME, String.class, ResultadoSolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoComprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoComprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "TipoComprobante", scope = ResultadoSolicitudAutorizacion.class)
    public JAXBElement<TipoComprobante> createResultadoSolicitudAutorizacionTipoComprobante(TipoComprobante value) {
        return new JAXBElement<TipoComprobante>(_ResultadoSolicitudAutorizacionTipoComprobante_QNAME, TipoComprobante.class, ResultadoSolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Fecha", scope = SolicitudAutorizacion.class)
    public JAXBElement<XMLGregorianCalendar> createSolicitudAutorizacionFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SolicitudAutorizacionFecha_QNAME, XMLGregorianCalendar.class, SolicitudAutorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfComprobante }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfComprobante }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Comprobantes", scope = UltimoComprobante.class)
    public JAXBElement<ArrayOfComprobante> createUltimoComprobanteComprobantes(ArrayOfComprobante value) {
        return new JAXBElement<ArrayOfComprobante>(_UltimoComprobanteComprobantes_QNAME, ArrayOfComprobante.class, UltimoComprobante.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Error", scope = UltimoComprobante.class)
    public JAXBElement<String> createUltimoComprobanteError(String value) {
        return new JAXBElement<String>(_ResultadoSolicitudAutorizacionError_QNAME, String.class, UltimoComprobante.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Error", scope = Autorizacion.class)
    public JAXBElement<String> createAutorizacionError(String value) {
        return new JAXBElement<String>(_ResultadoSolicitudAutorizacionError_QNAME, String.class, Autorizacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Token", scope = Autorizacion.class)
    public JAXBElement<String> createAutorizacionToken(String value) {
        return new JAXBElement<String>(_AutorizacionToken_QNAME, String.class, Autorizacion.class, value);
    }

}
