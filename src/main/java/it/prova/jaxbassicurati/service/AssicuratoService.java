package it.prova.jaxbassicurati.service;

import it.prova.jaxbassicurati.model.Assicurato;

import java.util.List;

public interface AssicuratoService {

    List<Assicurato> listAllElements();

    Assicurato caricaSingoloElemento(Long id);

    Assicurato aggiorna(Assicurato assicuratoInstance);

    Assicurato inserisciNuovo(Assicurato assicuratoInstance);

    void rimuovi(Assicurato assicuratoInstance);

    Assicurato findByCodiceFiscale(String codiceFiscale);


}
