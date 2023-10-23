package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
@Entity
@Table(name="servizi")
public class Servizio {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate inizio;
    private LocalDate fine;
    private int durata;
    private Veicolo veicolo;
    private Tratta tratta;

    public Servizio() {
    }

    public Servizio(LocalDate inizio, LocalDate fine, Veicolo veicolo, Tratta tratta) {
        this.inizio = inizio;
        this.fine = fine;
        this.veicolo = veicolo;
        this.tratta = tratta;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                ", durata=" + durata +
                ", veicolo=" + veicolo +
                ", tratta=" + tratta +
                '}';
    }

    @Entity
    @Table(name = "Tratte")
    public static class Tratta {
        @Id
        @Column(name = "Id")
        UUID Id;
        @Column(name = "Partenze")
        String partenza;
        @Column(name = "Arrivi")
        String capolinea;
        @Column(name = "Tempo_Medio")
        final DateTimeFormatter tempo_medio;

        public Tratta(String partenza, String capolinea, DateTimeFormatter tempo_medio) {
            this.partenza = partenza;
            this.capolinea = capolinea;
            this.tempo_medio = tempo_medio;
        }

        public String getPartenza() {
            return partenza;
        }

        public void setPartenza(String partenza) {
            this.partenza = partenza;
        }

        public String getCapolinea() {
            return capolinea;
        }

        public void setCapolinea(String capolinea) {
            this.capolinea = capolinea;
        }

        public DateTimeFormatter getTempo_medio() {
            return tempo_medio;
        }

        public UUID getId() {
            return Id;
        }

        @Override
        public String toString() {
            return "Tratta{" +
                    "Id=" + Id +
                    ", partenza='" + partenza + '\'' +
                    ", capolinea='" + capolinea + '\'' +
                    ", tempo_medio=" + tempo_medio +
                    '}';
        }
    }

    @Entity
    @Table(name = "Biglietti")
    public static class Biglietto {
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
}
