//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.27 alle 10:02:59 AM CEST 
//


package it.prova.jaxbassicurati.flusso.marshall;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _Codicefiscale_QNAME = new QName("", "codicefiscale");
    private final static QName _Cognome_QNAME = new QName("", "cognome");
    private final static QName _Nome_QNAME = new QName("", "nome");
    private final static QName _Datanascita_QNAME = new QName("", "datanascita");
    private final static QName _Nuovisinistri_QNAME = new QName("", "nuovisinistri");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Assicurati }
     * 
     */
    public Assicurati createAssicurati() {
        return new Assicurati();
    }

    /**
     * Create an instance of {@link Assicurato }
     * 
     */
    public Assicurato createAssicurato() {
        return new Assicurato();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codicefiscale")
    public JAXBElement<String> createCodicefiscale(String value) {
        return new JAXBElement<String>(_Codicefiscale_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cognome")
    public JAXBElement<String> createCognome(String value) {
        return new JAXBElement<String>(_Cognome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nome")
    public JAXBElement<String> createNome(String value) {
        return new JAXBElement<String>(_Nome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datanascita")
    public JAXBElement<XMLGregorianCalendar> createDatanascita(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Datanascita_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nuovisinistri")
    public JAXBElement<Byte> createNuovisinistri(Byte value) {
        return new JAXBElement<Byte>(_Nuovisinistri_QNAME, Byte.class, null, value);
    }

}
