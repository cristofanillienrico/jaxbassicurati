package it.prova.jaxbassicurati.service;

import it.prova.jaxbassicurati.model.Assicurato;
import it.prova.jaxbassicurati.repository.AssicuratoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
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

    @Transactional
    public Assicurato aggiorna(Assicurato assicuratoInstance) {
        return repository.save(assicuratoInstance);
    }

    @Transactional
    public Assicurato inserisciNuovo(Assicurato assicuratoInstance) {
        return repository.save(assicuratoInstance);
    }

    @Transactional
    public void rimuovi(Assicurato assicuratoInstance) {
        repository.delete(assicuratoInstance);

    }
}
