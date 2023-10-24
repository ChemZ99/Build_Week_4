package Main.Entities;

import Main.Enum.Stato_Distributore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Distributore extends Emissione {

    @Enumerated(EnumType.STRING)
    @Column
    private Stato_Distributore Stato;

    public Distributore() {
    }

    public Distributore(String indirizzo, Stato_Distributore stato) {
        super(indirizzo);
        Stato = stato;
    }

    public Stato_Distributore getStato() {
        return Stato;
    }

    public void setStato(Stato_Distributore stato) {
        Stato = stato;
    }

    @Override
    public String toString() {
        return "Distributore{" +
                "Stato=" + Stato +
                "} " + super.toString();
    }
}
