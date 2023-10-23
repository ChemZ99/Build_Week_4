package Main.Entities;

import Main.Enum.Stato_Biglietto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Biglietti")
public class Biglietto {
    @Id
    @Column(name = "Id")
    UUID id;

    @Column(name = "Data_Emissione")
    private LocalDate dataEmissione;
    @Column(name = "Data_Vidimazione")
    private LocalDate dataVidimazione;
    @ManyToOne
    @JoinColumn(name = "id_veicolo")
    private Veicolo veicolo;

    @ManyToOne
    @JoinColumn(name = "id_rivenditore")
    private Emissione puntoEmissione;
    @Enumerated
    @Column(name = "Stato")
    private Stato_Biglietto stato;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, LocalDate dataVidimazione, Veicolo veicolo, Emissione puntoEmissione, Stato_Biglietto stato) {
        this.dataEmissione = dataEmissione;
        this.dataVidimazione = dataVidimazione;
        this.veicolo = veicolo;
        this.puntoEmissione = puntoEmissione;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Emissione getPuntoEmissione() {
        return puntoEmissione;
    }

    public void setPuntoEmissione(Emissione puntoEmissione) {
        this.puntoEmissione = puntoEmissione;
    }

    public Stato_Biglietto getStato() {
        return stato;
    }

    public void setStato(Stato_Biglietto stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", dataVidimazione=" + dataVidimazione +
                ", veicolo=" + veicolo +
                ", puntoEmissione=" + puntoEmissione +
                ", stato=" + stato +
                '}';
    }
}