package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "servizi")
public class Servizio {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate inizio;
    private LocalDate fine;
    private int durata;
    @ManyToOne
    @JoinColumn(name = "id_veicolo")
    private Veicolo veicolo;
    @OneToOne
    @JoinColumn(name = "id_tratta")
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
}