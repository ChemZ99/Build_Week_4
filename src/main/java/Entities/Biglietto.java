package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Biglietti")
public class Biglietto {
    @Id
    @Column(name = "Id")
    UUID id;

    @Column(name = "Data_Emissione")
    LocalDate dataEmissione;
    @Column(name = "Data_Vidimazione")
    LocalDate dataVidimazione;
    @Column(name = "Veicolo vidimazione")
    int veicoloEmissioine; /*-DA SISTEMARE-*/
    @Column(name = "Punto_Emissione")
    int puntoEmissione;  /*-DA SISTEMARE-*/
    /*@Column(name = "Stato")
    Enum (vidimizato, utilizabile)*/ /*-DA COLLEGARE GLI ENUM-*/

    
}
