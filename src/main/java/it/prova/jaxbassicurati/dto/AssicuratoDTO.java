package it.prova.jaxbassicurati.dto;


import it.prova.jaxbassicurati.model.Assicurato;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AssicuratoDTO {

    private String codiceFiscale;

    private String nome;

    private String cognome;

    private Date dataNascita;

    private Integer numeroSinistri;

    public AssicuratoDTO() {
    }

    public AssicuratoDTO(String codiceFiscale, String nome, String cognome, Date dataNascita, Integer numeroSinistri) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroSinistri = numeroSinistri;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Integer getNumeroSinistri() {
        return numeroSinistri;
    }

    public void setNumeroSinistri(Integer numeroSinistri) {
        this.numeroSinistri = numeroSinistri;
    }

    public Assicurato buildAssicuratoModel() {
        return new Assicurato(this.codiceFiscale, this.nome, this.cognome, this.dataNascita, this.numeroSinistri);
    }

    public static AssicuratoDTO buildAssicuratoDTOFromModel(Assicurato assicuratoModel) {
        return new AssicuratoDTO(assicuratoModel.getCodiceFiscale(), assicuratoModel.getNome(), assicuratoModel.getCognome(),
                assicuratoModel.getDataNascita(), assicuratoModel.getNumeroSinistri());
    }

    public static List<AssicuratoDTO> createAssicuratoDTOListFromModelList(List<Assicurato> modelListInput) {
        return modelListInput.stream().map(assicuratoEntity -> {
            return AssicuratoDTO.buildAssicuratoDTOFromModel(assicuratoEntity);
        }).collect(Collectors.toList());
    }
}
