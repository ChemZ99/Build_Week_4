package Main.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public abstract class Emissione {
    @Id
    @GeneratedValue
    private UUID Id;

    @Column
    private int Biglietti_Venduti;

    public Emissione () {}

    public Emissione(int biglietti_Venduti) {
        Biglietti_Venduti = biglietti_Venduti;
    }

    public UUID getId() {
        return Id;
    }

    public int getBiglietti_Venduti() {
        return Biglietti_Venduti;
    }

    public void setBiglietti_Venduti(int biglietti_Venduti) {
        Biglietti_Venduti = biglietti_Venduti;
    }

    @Override
    public String toString() {
        return "Emissione{" +
                "Id=" + Id +
                ", Biglietti_Venduti=" + Biglietti_Venduti +
                '}';
    }
}
