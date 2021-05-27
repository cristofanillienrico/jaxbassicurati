package it.prova.jaxbassicurati.service;

import it.prova.jaxbassicurati.model.Assicurato;
import it.prova.jaxbassicurati.repository.AssicuratoRepository;

import javax.persistence.PersistenceContext;
import java.util.List;

public class AssicuratoServiceImpl implements AssicuratoService {
    @PersistenceContext
    private AssicuratoRepository repository;

    @Override
    public List<Assicurato> listAllElements() {
        return (List<Assicurato>) repository.findAll();
    }

    @Override
    public Assicurato caricaSingoloElemento(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Assicurato aggiorna(Assicurato assicuratoInstance) {
        return repository.save(assicuratoInstance);
    }

    @Override
    public Assicurato inserisciNuovo(Assicurato assicuratoInstance) {
        return repository.save(assicuratoInstance);
    }

    @Override
    public void rimuovi(Assicurato assicuratoInstance) {
        repository.delete(assicuratoInstance);

    }
}
