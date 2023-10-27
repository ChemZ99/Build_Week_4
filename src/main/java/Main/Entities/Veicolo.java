package Main.Entities;


import Main.Enum.Stato_Veicolo;
import Main.Enum.Tipo_Veicolo;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "veicoli")
public class Veicolo {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Stato_Veicolo stato;
    @Enumerated(EnumType.STRING)
    private Tipo_Veicolo tipo;
    private int capienza;

    @OneToMany(mappedBy = "veicolo")
    private List<Biglietto> lista_biglietti;

    @OneToMany(mappedBy = "veicolo", cascade = CascadeType.ALL)
    private List<Manutenzione> lista_veicolo;
    @OneToMany(mappedBy = "veicolo", cascade = CascadeType.ALL)
    private List<Servizio> lista_servizi;

    public Veicolo() {
    }

    public Veicolo(Stato_Veicolo stato, Tipo_Veicolo tipo) {
        this.stato = stato;
        this.tipo = tipo;
        if (tipo == Tipo_Veicolo.AUTOBUS) {
            this.capienza = 70;
        } else {
            this.capienza = 100;
        }
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


    public List<Biglietto> getLista_biglietti() {
        return lista_biglietti;
    }

    public void setLista_biglietti(List<Biglietto> lista_biglietti) {
        this.lista_biglietti = lista_biglietti;
    }

    public List<Manutenzione> getLista_veicolo() {
        return lista_veicolo;
    }

    public void setLista_veicolo(List<Manutenzione> lista_veicolo) {
        this.lista_veicolo = lista_veicolo;
    }

    public List<Servizio> getLista_servizi() {
        return lista_servizi;
    }

    public void setLista_servizi(List<Servizio> lista_servizi) {
        this.lista_servizi = lista_servizi;
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
