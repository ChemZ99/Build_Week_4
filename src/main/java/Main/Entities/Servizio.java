package Main.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "servizi")
public class Servizio {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDateTime inizio;
    private LocalDateTime fine;
    private int durata_media;
    private int n_tratte;
    @ManyToOne
    @JoinColumn(name = "id_veicolo")
    private Veicolo veicolo;
    @OneToOne
    @JoinColumn(name = "id_tratta")
    private Tratta tratta;

    public Servizio() {
    }

    public Servizio(LocalDateTime inizio, Veicolo veicolo, Tratta tratta) {
        Random rndm = new Random();
        this.inizio = inizio;
        this.fine = inizio.plusHours(6);
        this.veicolo = veicolo;
        this.tratta = tratta;
        this.n_tratte = rndm.nextInt(6, 10);
        this.durata_media = 360 / this.n_tratte;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime getFine() {
        return fine;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }

    public int getDurata_media() {
        return durata_media;
    }

    public void setDurata_media(int durata) {
        this.durata_media = durata;
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

    public int getN_tratte() {
        return n_tratte;
    }

    public void setN_tratte(int n_tratte) {
        this.n_tratte = n_tratte;
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                ", durata=" + durata_media +
                ", veicolo=" + veicolo +
                ", tratta=" + tratta +
                '}';
    }
}