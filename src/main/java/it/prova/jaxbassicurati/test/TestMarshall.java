package it.prova.jaxbassicurati.test;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.flusso.marshall.Assicurato;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;

public class TestMarshall {

//        <nome>Giovanni</nome>
//        <cognome>Gemini</cognome>
//        <datanascita>1996-02-01</datanascita>
//        <nuovisinistri>15</nuovisinistri>
//        <codicefiscale>GMNGNN96B01H501D</codicefiscale>


    //Initialize the employees list
    static Assicurati assicurati = new Assicurati();

    static {

        Assicurato assicurato1 = new Assicurato();
        assicurato1.setNome("Ugulo");
        assicurato1.setCognome("Sambotilo");
        assicurato1.setCodicefiscale("GMNGNN96B01H501D");
        assicurato1.setNuovisinistri((byte) 11);
        assicurato1.setDatanascita(XMLGregorianCalendarImpl.parse("1996-02-01"));

        assicurati.getAssicurato().add(assicurato1);

    }


    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(assicurati, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(assicurati, new File("src/processed/ciao.xml"));
    }


}
