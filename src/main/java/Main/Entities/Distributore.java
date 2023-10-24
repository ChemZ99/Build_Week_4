package Main.Entities;

import Main.Enum.Stato_Distributore;

import javax.persistence.Column;
import javax.persistence.Enumerated;

public class Distributore extends Emissione {

    @Enumerated
    @Column
    private Stato_Distributore Stato;

    public Distributore() {
    }

    public Distributore(int biglietti_Venduti, Stato_Distributore stato) {

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