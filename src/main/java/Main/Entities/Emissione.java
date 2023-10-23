package Main.Entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public abstract class Emissione {
    @Id
    @GeneratedValue
    private UUID Id;

    @OneToMany(mappedBy = "puntoEmissione")
    private List<Biglietto> lista_biglietti;

    public Emissione() {
    }


    public UUID getId() {
        return Id;
    }

    public List<Biglietto> getLista_biglietti() {
        return lista_biglietti;
    }

    public void setLista_biglietti(List<Biglietto> lista_biglietti) {
        this.lista_biglietti = lista_biglietti;
    }


}
