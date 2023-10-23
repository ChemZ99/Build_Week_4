package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity

public class Manutenzione {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate inizio;
    private LocalDate fine;
    private int durata;

    public Manutenzione() {
    }

    public Manutenzione(LocalDate inizio, LocalDate fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public UUID getId() {
        return id;
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
