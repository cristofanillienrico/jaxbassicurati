package it.prova.jaxbassicurati.web.api;


import it.prova.jaxbassicurati.service.AssicuratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/assicurato")
public class AssicuratoController {

    @Autowired
    private AssicuratoService assicuratoService;

    @GetMapping
    public void trigger() {
        return registaService.listAllElements();
    }
}
