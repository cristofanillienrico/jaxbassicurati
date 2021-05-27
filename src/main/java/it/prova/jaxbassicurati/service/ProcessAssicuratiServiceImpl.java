package it.prova.jaxbassicurati.service;

import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.flusso.marshall.Assicurato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Service
public class ProcessAssicuratiServiceImpl implements ProcessAssicuratiService {

    @Autowired
    private AssicuratoService assicuratoService;

    @Autowired
    private MarshallService marshallService;


    @Override
    public void processaAssicurati() throws JAXBException {
        Assicurati assicuratiProcessed = new Assicurati();

        Assicurati assicuratiScarti = new Assicurati();

        Assicurati assicurati = marshallService.unmarshall();

        for (Assicurato assicurato : assicurati.getAssicurato()) {

            //faccio tutti i controlli di validità
            if (!marshallService.validate(assicurato)) {
                assicuratiScarti.getAssicurato().add(assicurato);
                continue;
            }

            //ora che ho il model faccio la query sul db per vedere se esiste l'assicurato
            it.prova.jaxbassicurati.model.Assicurato assicuratoInCanna = assicuratoService.findByCodiceFiscale(assicurato.getCodicefiscale());

            //se non esiste lo inserisco nel db e lo aggiungo alla lista dei processati
            if (assicuratoInCanna == null) {

                it.prova.jaxbassicurati.model.Assicurato assicuratoModel = marshallService.fromMarshallToModel(assicurato);
                assicuratoService.inserisciNuovo(assicuratoModel);
                assicuratiProcessed.getAssicurato().add(assicurato);

                //se esiste aggiorno il numero di sinistri nel db e se però superano 10 li aggiungo allo scarto
            } else {

                assicuratoInCanna.setNumeroSinistri(assicuratoInCanna.getNumeroSinistri() + assicurato.getNuovisinistri());
                assicuratoService.aggiorna(assicuratoInCanna);
                assicuratiProcessed.getAssicurato().add(assicurato);


            }


        }

        marshallService.marshallScarti(assicuratiScarti);
        marshallService.marshallProcessed(assicuratiProcessed);

    }
}
