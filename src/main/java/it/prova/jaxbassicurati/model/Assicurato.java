package it.prova.jaxbassicurati.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


//    <nome>Giovanni</nome>
//        <cognome>Gemini</cognome>
//        <datanascita>1996-02-01</datanascita>
//        <nuovisinistri>15</nuovisinistri>
//        <codicefiscale>GMNGNN96B01H501D</codicefiscale>

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "assicurato")
public class Assicurato {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "{codicefiscale.notblank}")
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @NotBlank(message = "{nome.notblank}")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "{cognome.notblank}")
    @Column(name = "cognome")
    private String cognome;

    @NotNull(message = "{datanascita.notnull}")
    @Column(name = "data_nascita")
    private Date dataNascita;

    @NotNull(message = "{numerosinistri.notnull}")
    @Column(name = "numero_sinistri")
    private Integer numeroSinistri;


    public Assicurato() {
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

    @Override
    public String toString() {
        return "Assicurato{" +
                "codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroSinistri=" + numeroSinistri +
                '}';
    }
}
