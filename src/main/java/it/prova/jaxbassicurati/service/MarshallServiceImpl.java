package it.prova.jaxbassicurati.service;

import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.model.Assicurato;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
public class MarshallServiceImpl implements MarshallService {


    @Override
    public Assicurati unmarshall() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        return (Assicurati) jaxbUnmarshaller.unmarshal(new File("src/input/assicurati.xml"));
    }

    @Override
    public void marshallProcessed(Assicurati assicurati) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(assicurati, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(assicurati, new File("src/processed/processed.xml"));

    }

    @Override
    public void marshallScarti(Assicurati assicurati) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(assicurati, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(assicurati, new File("src/scarti/scarti.xml"));

    }

    @Override
    public Assicurato fromMarshallToModel(it.prova.jaxbassicurati.flusso.marshall.Assicurato assicuratoMarshall) {
        Assicurato assicuratoModel = new Assicurato();
        assicuratoModel.setCodiceFiscale(assicuratoMarshall.getCodicefiscale());
        assicuratoModel.setNome(assicuratoMarshall.getNome());
        assicuratoModel.setCognome(assicuratoMarshall.getCognome());
        assicuratoModel.setDataNascita(assicuratoMarshall.getDatanascita().toGregorianCalendar().getTime());
        assicuratoModel.setNumeroSinistri((int) assicuratoMarshall.getNuovisinistri());

        return assicuratoModel;
    }

    @Override
    public boolean validate(it.prova.jaxbassicurati.flusso.marshall.Assicurato assicuratoMarshall) {
        if (assicuratoMarshall.getNuovisinistri() > 10) {
            return false;
        }
        return true;
    }
}
