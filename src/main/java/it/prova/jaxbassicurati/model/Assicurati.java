package it.prova.jaxbassicurati.model;

import it.prova.jaxbassicurati.dto.AssicuratiDTO;

import java.util.ArrayList;
import java.util.List;

public class Assicurati {
    List<Assicurato> assicurato = new ArrayList<>();

    public Assicurati() {
    }

    public Assicurati(List<Assicurato> assicurato) {
        this.assicurato = assicurato;
    }

    public List<Assicurato> getAssicurato() {
        return assicurato;
    }

    public void setAssicurato(List<Assicurato> assicurato) {
        this.assicurato = assicurato;
    }

    @Override
    public String toString() {
        return "Assicurati{" +
                "assicurato=" + assicurato +
                '}';
    }


}
