package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "Tessere")
@DiscriminatorValue("Tessera")

public class Tessera {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate data_creazione_tessera;
    private LocalDate data_scadenza_tessera;
    private Stato_Abbonamento stato_abbonamento;



    public Tessera() {
    }

    public Tessera(LocalDate data_creazione_tessera, LocalDate data_scadenza_tessera, Stato_Abbonamento stato_abbonamento) {
        this.id = UUID.randomUUID();
        this.data_creazione_tessera = data_creazione_tessera;
        this.data_scadenza_tessera = data_scadenza_tessera;
        this.stato_abbonamento = stato_abbonamento;
    }


    public LocalDate getData_creazione_tessera() {
        return data_creazione_tessera;
    }

    public void setData_creazione_tessera(LocalDate data_creazione_tessera) {
        this.data_creazione_tessera = data_creazione_tessera;
    }
    public UUID getId() {
        return id;
    }

    public Stato_Abbonamento getStato_Abbonamento() {
        return stato_abbonamento;
    }

    public void setStato_Abbonamento(Stato_Abbonamento stato_abbonamento) {
        this.stato_abbonamento = stato_abbonamento;
    }



    public LocalDate getData_scadenza_tessera() {
        return data_scadenza_tessera;
    }

    public void setData_scadenza_tessera(LocalDate data_scadenza_tessera) {
        this.data_scadenza_tessera = data_scadenza_tessera;
    }
    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", data_creazione_tessera=" + data_creazione_tessera +
                ", data_scadenza_tessera=" + data_scadenza_tessera +
                '}';
    }
}
