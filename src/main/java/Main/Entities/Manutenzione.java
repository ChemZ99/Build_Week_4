package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "manutenzioni")
public class Manutenzione {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate inizio;
    private LocalDate fine;
    private int durata;
    @ManyToOne
    @JoinColumn(name = "id_veicolo")
    private Veicolo veicolo;

    public Manutenzione() {
    }

    public Manutenzione(LocalDate inizio, LocalDate fine, Veicolo veicolo) {
        this.inizio = inizio;
        this.fine = fine;
        long d1 = inizio.toEpochDay();
        if (fine == null) {
            long d2 = LocalDate.now().toEpochDay();
            this.durata = (int) (d2 - d1);
        } else {
            long d3 = fine.toEpochDay();
            this.durata = (int) (d3 - d1);
        }

        this.veicolo = veicolo;
    }

    public UUID getId() {
        return id;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public LocalDate getInizio() {
        return inizio;
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

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                ", durata=" + durata +
                '}';
    }
}
