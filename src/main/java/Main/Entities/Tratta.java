package Main.Entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Tratte")
public class Tratta {


    @Column(name = "Tempo_Medio")
    private int tempo_medio;
    @Id
    @Column(name = "Id")
    private UUID Id;
    @Column(name = "Partenze")
    private String partenza;
    @Column(name = "Arrivi")
    private String capolinea;
    @OneToMany(mappedBy = "tratta")
    private List<Servizio> lista_servizi;

    public Tratta() {
    }

    public Tratta(String partenza, String capolinea, int tempo_medio) {
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

    public int getTempo_medio() {
        return tempo_medio;
    }

    public UUID getId() {
        return Id;
    }

    public List<Servizio> getLista_servizi() {
        return lista_servizi;
    }

    public void setLista_servizi(List<Servizio> lista_servizi) {
        this.lista_servizi = lista_servizi;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "Id=" + Id +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempo_medio=" + tempo_medio + " minuti " +
                '}';
    }
}