package it.prova.jaxbassicurati.test;

import it.prova.jaxbassicurati.flusso.marshall.Assicurati;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MarshallUtility {

    public static Assicurati unmarshall() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        return (Assicurati) jaxbUnmarshaller.unmarshal(new File("src/input/assicurati.xml"));

    }

    public static void  marshallProcessed(Assicurati assicurati) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(assicurati, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(assicurati, new File("src/processed/processed.xml"));

    }

    public static void  marshallScarti(Assicurati assicurati) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(assicurati, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(assicurati, new File("src/scarti/scarti.xml"));

    }
}
