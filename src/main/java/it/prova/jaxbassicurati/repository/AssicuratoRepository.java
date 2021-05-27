package it.prova.jaxbassicurati.repository;

import it.prova.jaxbassicurati.model.Assicurato;
import org.springframework.data.repository.CrudRepository;

public interface AssicuratoRepository extends CrudRepository<Assicurato, Long> {

    Assicurato findByCodiceFiscale(String codiceFiscale);
}
