
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
    @Column(name = "Veicolo vidimazione")
    private int veicoloEmisione; /*-DA SISTEMARE-*/
    @Column(name = "Punto_Emissione")
    private int puntoEmissione;  /*-DA SISTEMARE-*/
    @Enumerated
    @Column(name = "Stato")
    private Stato_Biglietto stato;

    public Biglietto(LocalDate dataEmissione, LocalDate dataVidimazione, int veicoloEmisione, int puntoEmissione, Stato_Biglietto stato) {
        this.dataEmissione = dataEmissione;
        this.dataVidimazione = dataVidimazione;
        this.veicoloEmisione = veicoloEmisione;
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

    public int getVeicoloEmisione() {
        return veicoloEmisione;
    }

    public void setVeicoloEmisione(int veicoloEmisione) {
        this.veicoloEmisione = veicoloEmisione;
    }

    public int getPuntoEmissione() {
        return puntoEmissione;
    }

    public void setPuntoEmissione(int puntoEmissione) {
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
                ", veicoloEmisione=" + veicoloEmisione +
                ", puntoEmissione=" + puntoEmissione +
                ", stato=" + stato +
                '}';
    }
}