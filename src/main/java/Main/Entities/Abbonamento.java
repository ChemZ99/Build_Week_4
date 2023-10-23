package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Abbonamenti")
@DiscriminatorValue("Abbonamento")
public class Abbonamento {
    @Id
    @GeneratedValue
    private UUID id;

    private StatoAbbonamento stato_abbonamento;
    @ManyToOne
    private Rivenditore_Autorizzato punto_emissione;
    private LocalDate data_emissione;
    private LocalDate data_scadenza;
    private Tipo_Abbonamento tipo_abbonamento;
    @ManyToOne
    private Utente utente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StatoAbbonamento getStato_abbonamento() {
        return stato_abbonamento;
    }

    public void setStato_abbonamento(StatoAbbonamento stato_abbonamento) {
        this.stato_abbonamento = stato_abbonamento;
    }

    public Rivenditore_Autorizzato getPunto_emissione() {
        return punto_emissione;
    }

    public void setPunto_emissione(Rivenditore_Autorizzato punto_emissione) {
        this.punto_emissione = punto_emissione;
    }

    public LocalDate getData_emissione() {
        return data_emissione;
    }

    public void setData_emissione(LocalDate data_emissione) {
        this.data_emissione = data_emissione;
    }

    public LocalDate getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(LocalDate data_scadenza) {
        this.data_scadenza = data_scadenza;
    }


    public Utente getUtente() {
        return utente;
    }

    public Tipo_Abbonamento getTipo_abbonamento() {
        return tipo_abbonamento;
    }

    public void setTipo_abbonamento(Tipo_Abbonamento tipo_abbonamento) {
        this.tipo_abbonamento = tipo_abbonamento;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Abbonamento(Tipo_Abbonamento tipo_abbonamento, Rivenditore_Autorizzato punto_emissione, LocalDate data_emissione, LocalDate data_scadenza, Validitá validitá, Utente utente) {
        this.id = UUID.randomUUID();
        this.Tipo_Abbonamento = tipo_abbonamento;
        this.punto_emissione = punto_emissione;
        this.data_emissione = data_emissione;
        this.data_scadenza = data_scadenza;
        this.validitá = validitá;
        this.utente = utente;
    }

    public Abbonamento() {
    }
}
