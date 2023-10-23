package Main.Entities;

import Main.Enum.Stato_abbonamento;
import Main.Enum.Tipo_Abbonamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Abbonamenti")
@DiscriminatorValue("Abbonamento")
public class Abbonamento {
    @Id
    @GeneratedValue
    private UUID id;

    private Stato_abbonamento stato_abbonamento;
    @ManyToOne
    private Rivenditore punto_emissione;
    private LocalDate data_emissione;
    private LocalDate data_scadenza;
    private Tipo_Abbonamento tipo_abbonamento;
    @ManyToOne
    private Utente utente;

    public UUID getId() {
        return id;
    }

    public Stato_abbonamento getStato_abbonamento() {
        return stato_abbonamento;
    }

    public void setStato_abbonamento(Stato_abbonamento stato_abbonamento) {
        this.stato_abbonamento = stato_abbonamento;
    }

    public Rivenditore getPunto_emissione() {
        return punto_emissione;
    }

    public void setPunto_emissione(Rivenditore punto_emissione) {
        this.punto_emissione = punto_emissione;
    }

    public LocalDate getData_emissione() {
        return data_emissione;
    }

    public void setData_emissione(LocalDate data_emissione) {
        this.data_emissione = data_emissione;
    }

    public LocalDate getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(LocalDate data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public Tipo_Abbonamento getTipo_abbonamento() {
        return tipo_abbonamento;
    }

    public void setTipo_abbonamento(Tipo_Abbonamento tipo_abbonamento) {
        this.tipo_abbonamento = tipo_abbonamento;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Abbonamento(Stato_abbonamento stato_abbonamento, Rivenditore punto_emissione, LocalDate data_emissione, LocalDate data_scadenza, Tipo_Abbonamento tipo_abbonamento, Utente utente) {
        this.stato_abbonamento = stato_abbonamento;
        this.punto_emissione = punto_emissione;
        this.data_emissione = data_emissione;
        this.data_scadenza = data_scadenza;
        this.tipo_abbonamento = tipo_abbonamento;
        this.utente = utente;
    }


    public Abbonamento() {
    }
    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", stato_abbonamento=" + stato_abbonamento +
                ", punto_emissione=" + punto_emissione +
                ", data_emissione=" + data_emissione +
                ", data_scadenza=" + data_scadenza +
                ", tipo_abbonamento=" + tipo_abbonamento +
                ", utente=" + utente +
                '}';
    }
}
