package it.prova.jaxbassicurati.web.api;


import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
import it.prova.jaxbassicurati.flusso.marshall.Assicurato;
import it.prova.jaxbassicurati.service.AssicuratoService;
import it.prova.jaxbassicurati.service.MarshallService;
import it.prova.jaxbassicurati.service.ProcessAssicuratiService;
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
    private ProcessAssicuratiService processAssicuratiService;


    @GetMapping
    public ResponseEntity<String> trigger() throws JAXBException {

        processAssicuratiService.processaAssicurati();
        return ResponseEntity.ok("Operazione Effettuata");
    }
}
