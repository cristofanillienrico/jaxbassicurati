package it.prova.jaxbassicurati.service;

import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.model.Assicurato;

import javax.xml.bind.JAXBException;

public interface MarshallService {

    public Assicurati unmarshall() throws JAXBException;

    public void marshallProcessed(Assicurati assicurati) throws JAXBException;

    public void marshallScarti(Assicurati assicurati) throws JAXBException;

    public Assicurato fromMarshallToModel(it.prova.jaxbassicurati.flusso.marshall.Assicurato assicuratoMarshall);

    public boolean validate(it.prova.jaxbassicurati.flusso.marshall.Assicurato assicuratoMarshall);


}
