package it.prova.jaxbassicurati.test;


import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.flusso.marshall.Assicurato;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TestUnmarshal {


    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        Assicurati assicurati = (Assicurati) jaxbUnmarshaller.unmarshal(new File("c:/Users/assicurati.xml"));

        System.out.println(assicurati.getAssicurato().get(1).getNome());

        for(Assicurato assicurato : assicurati.getAssicurato()){
            System.out.println(assicurato.getCognome());
        }

    }

}
