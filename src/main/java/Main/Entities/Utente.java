package Main.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private LocalDate data_nascita;

    @OneToOne(mappedBy = "utente", cascade = CascadeType.REMOVE)
    private Tessera tessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate data_nascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }

    public UUID getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }
}
