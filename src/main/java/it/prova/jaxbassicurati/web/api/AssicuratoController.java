package it.prova.jaxbassicurati.web.api;


import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.flusso.marshall.Assicurato;
import it.prova.jaxbassicurati.service.AssicuratoService;
import it.prova.jaxbassicurati.test.MarshallUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("api/assicurato")
public class AssicuratoController {

    @Autowired
    private AssicuratoService assicuratoService;

    @GetMapping
    public ResponseEntity<String> trigger() throws JAXBException {

        Assicurati assicuratiProcessed = new Assicurati();

        Assicurati assicuratiScarti = new Assicurati();

        Assicurati assicurati = MarshallUtility.unmarshall();

        for (Assicurato assicurato : assicurati.getAssicurato()) {

            //faccio tutti i controlli di validità
            if (!MarshallUtility.validate(assicurato)) {
                assicuratiScarti.getAssicurato().add(assicurato);
                continue;
            }

            //ora che ho il model faccio la query sul db per vedere se esiste l'assicurato
            it.prova.jaxbassicurati.model.Assicurato assicuratoInCanna = assicuratoService.findByCodiceFiscale(assicurato.getCodicefiscale());

            //se non esiste lo inserisco nel db e lo aggiungo alla lista dei processati
            if (assicuratoInCanna == null) {

                it.prova.jaxbassicurati.model.Assicurato assicuratoModel = MarshallUtility.fromMarshallToModel(assicurato);
                assicuratoService.inserisciNuovo(assicuratoModel);
                assicuratiProcessed.getAssicurato().add(assicurato);

                //se esiste aggiorno il numero di sinistri nel db e se però superano 10 li aggiungo allo scarto
            } else {

                assicuratoInCanna.setNumeroSinistri(assicuratoInCanna.getNumeroSinistri() + assicurato.getNuovisinistri());
                assicuratoService.aggiorna(assicuratoInCanna);
                assicuratiProcessed.getAssicurato().add(assicurato);


            }


        }

        MarshallUtility.marshallScarti(assicuratiScarti);
        MarshallUtility.marshallProcessed(assicuratiProcessed);

        return ResponseEntity.ok("Operazione Effettuata");
    }
}
