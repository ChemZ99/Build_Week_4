package Main.Entities;



import Main.Enum.Tipo_Veicolo;
import Main.Enum.Stato_Veicolo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name="veicoli")
public class Veicolo {
    @Id
    @GeneratedValue
   private UUID id;
   private Stato_Veicolo stato;
   private Tipo_Veicolo tipo;

public Veicolo(){}

    public Veicolo(Stato_Veicolo stato, Tipo_Veicolo tipo) {
        this.stato = stato;
        this.tipo = tipo;
    }

    public UUID getId() {
        return id;
    }


    public Stato_Veicolo getStato() {
        return stato;
    }

    public void setStato(Stato_Veicolo stato) {
        this.stato = stato;
    }

    public Tipo_Veicolo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_Veicolo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "id=" + id +
                ", stato=" + stato +
                ", tipo=" + tipo +
                '}';
    }
}
