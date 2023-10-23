package Entities;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
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
}
