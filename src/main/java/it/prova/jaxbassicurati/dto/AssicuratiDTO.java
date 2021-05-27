package it.prova.jaxbassicurati.dto;

import it.prova.jaxbassicurati.model.Assicurati;
import it.prova.jaxbassicurati.model.Assicurato;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssicuratiDTO {

    List<Assicurato> assicurato = new ArrayList<>();

    public AssicuratiDTO() {
    }

    public AssicuratiDTO(List<Assicurato> assicurato) {
        this.assicurato = assicurato;
    }

    public List<Assicurato> getAssicurato() {
        return assicurato;
    }

    public void setAssicurato(List<Assicurato> assicurato) {
        this.assicurato = assicurato;
    }

    public Assicurati buildAssicuratoModel() {
        return new Assicurati(this.assicurato);
    }

    public static AssicuratiDTO buildAssicuratiDTOFromModel(Assicurati assicuratiModel) {
        return new AssicuratiDTO(assicuratiModel.getAssicurato());
    }


}
