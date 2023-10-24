package Main.Entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Rivenditore extends Emissione {
    @OneToMany(mappedBy = "punto_emissione")
    private List<Abbonamento> lista;

    public Rivenditore() {
    }

}