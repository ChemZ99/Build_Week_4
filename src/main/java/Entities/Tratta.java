package Entities;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "Tratte")
public class Tratta {
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
