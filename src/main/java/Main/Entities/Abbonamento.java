package Main.Entities;


import Main.Enum.Stato_abbonamento;
import Main.Enum.Tipo_Abbonamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Stato_abbonamento stato_abbonamento;
    @ManyToOne
    @JoinColumn(name = "id_rivenditore")
    private Rivenditore punto_emissione;
    private LocalDate data_emissione;
    private LocalDate data_scadenza;
    @Enumerated(EnumType.STRING)
    private Tipo_Abbonamento tipo_abbonamento;
    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Tessera tessera;

    public Abbonamento(Rivenditore punto_emissione, LocalDate data_emissione, Tipo_Abbonamento tipo_abbonamento, Tessera tessera) {

        this.punto_emissione = punto_emissione;
        this.data_emissione = data_emissione;
        this.tipo_abbonamento = tipo_abbonamento;
        this.tessera = tessera;
        if (tipo_abbonamento == Tipo_Abbonamento.MENSILE) {
            this.data_scadenza = data_emissione.plusMonths(1);
        } else {
            this.data_scadenza = data_emissione.plusDays(7);
        }
        if (this.data_scadenza.isAfter(LocalDate.now())) {
            this.stato_abbonamento = Stato_abbonamento.VALIDO;
        } else {
            this.stato_abbonamento = Stato_abbonamento.SCADUTO;
        }
    }

    public Abbonamento() {
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

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
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
                ", tessera=" + tessera +
                '}';
    }


}
