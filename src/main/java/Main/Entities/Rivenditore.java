package Main.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Rivenditore extends Emissione {
    @OneToMany(mappedBy = "punto_emissione")
    private List<Abbonamento> lista;
    public Rivenditore() {
    }

    public Rivenditore(String indirizzo) {
        super(indirizzo);
    }

    public List<Abbonamento> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "Rivenditore{" +
                "Id=" + super.getId() +
                ", indirizzo='" + super.getIndirizzo() +
                '}';
    }

    public void setLista(List<Abbonamento> lista) {
        this.lista = lista;
    }
}
