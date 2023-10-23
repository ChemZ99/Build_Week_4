
package Main.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Biglietti")
public class Biglietto {
    @Id
    @Column(name = "Id")
    UUID id;

    @Column(name = "Data_Emissione")
    LocalDate dataEmissione;
    @Column(name = "Data_Vidimazione")
    LocalDate dataVidimazione;
    @Column(name = "Veicolo vidimazione")
    int veicoloEmissioine; /*-DA SISTEMARE-*/
    @Column(name = "Punto_Emissione")
    int puntoEmissione;  /*-DA SISTEMARE-*/
    /*@Column(name = "Stato")
    Enum (vidimizato, utilizabile)*/ /*-DA COLLEGARE GLI ENUM-*/

    public Biglietto(LocalDate dataEmissione, LocalDate dataVidimazione, int veicoloEmissioine, int puntoEmissione) {
        this.dataEmissione = dataEmissione;
        this.dataVidimazione = dataVidimazione;
        this.veicoloEmissioine = veicoloEmissioine;
        this.puntoEmissione = puntoEmissione;
    } /*-AGGIUNGERE STATO-*/

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

    public int getVeicoloEmissioine() {
        return veicoloEmissioine;
    }

    public void setVeicoloEmissioine(int veicoloEmissioine) {
        this.veicoloEmissioine = veicoloEmissioine;
    }

    public int getPuntoEmissione() {
        return puntoEmissione;
    }

    public void setPuntoEmissione(int puntoEmissione) {
        this.puntoEmissione = puntoEmissione;
    }

    public UUID getId() {
        return id;
    }

    /*-GETTER E SETTER DELLO STATO-*/
}