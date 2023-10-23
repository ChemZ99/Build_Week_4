package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
@DiscriminatorValue("utente")

public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private LocalDate data_nascita;
    @OneToMany(mappedBy = "utente")
    private List<Abbonamento> abbonamento;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_tessera")
    private Tessera tessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate data_nascita, Tessera tessera) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.tessera = tessera;
    }

    public UUID getId() {
        return id;
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

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public List<Abbonamento> getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(List<Abbonamento> abbonamento) {
        this.abbonamento = abbonamento;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                ", abbonamento=" + abbonamento +
                ", tessera=" + tessera +
                '}';
    }
}
