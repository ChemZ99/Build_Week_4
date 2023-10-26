package Main.Entities;


import Main.Enum.Stato_abbonamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate data_creazione_tessera;
    private LocalDate data_scadenza_tessera;
    @Enumerated(EnumType.STRING)
    private Stato_abbonamento stato_abbonamento;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToMany(mappedBy = "tessera", cascade = CascadeType.REMOVE)
    private List<Abbonamento> abbonamento;

    public Tessera() {
    }


    public Tessera(LocalDate data_creazione_tessera, Utente utente) {
        this.utente = utente;
        this.data_creazione_tessera = data_creazione_tessera;
        this.data_scadenza_tessera = data_creazione_tessera.plusYears(1);
        if (LocalDate.now().isAfter(data_scadenza_tessera)) {
            this.stato_abbonamento = Stato_abbonamento.SCADUTO;
        } else {
            this.stato_abbonamento = Stato_abbonamento.VALIDO;
        }

    }


    public LocalDate getData_creazione_tessera() {
        return data_creazione_tessera;
    }

    public void setData_creazione_tessera(LocalDate data_creazione_tessera) {
        this.data_creazione_tessera = data_creazione_tessera;
    }

    public UUID getId() {
        return id;
    }


    public Stato_abbonamento getStato_abbonamento() {
        return stato_abbonamento;
    }

    public void setStato_abbonamento(Stato_abbonamento stato_abbonamento) {
        this.stato_abbonamento = stato_abbonamento;
    }

    public LocalDate getData_scadenza_tessera() {
        return data_scadenza_tessera;
    }

    public void setData_scadenza_tessera(LocalDate data_scadenza_tessera) {
        this.data_scadenza_tessera = data_scadenza_tessera;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Abbonamento> getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(List<Abbonamento> abbonamento) {
        this.abbonamento = abbonamento;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", data_creazione_tessera=" + data_creazione_tessera +
                ", data_scadenza_tessera=" + data_scadenza_tessera +
                ", stato_abbonamento=" + stato_abbonamento +
                ", utente=" + utente +
                '}';
    }
}
