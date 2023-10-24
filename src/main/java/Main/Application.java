package Main;

import Main.Entities.*;
import Main.Enum.Stato_Distributore;
import Main.Enum.Stato_Veicolo;
import Main.Enum.Tipo_Veicolo;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BUILD_WEEK_4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();
        Supplier<Utente> utenteSupplier = () -> new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.now().minusYears(rndm.nextInt(12, 70)).minusDays(rndm.nextInt(0, 365)), new Tessera(LocalDate.now().minusDays(rndm.nextInt(0, 365))));
        //Supplier<Abbonamento> abbonamentoSupplier=()->
        Supplier<Rivenditore> rivenditoreSupplier = () -> new Rivenditore(faker.address().fullAddress());
        Supplier<Distributore> distributoreSupplier = () -> new Distributore(faker.address().fullAddress(), Stato_Distributore.randomDistributore());
        Supplier<Tratta> trattaSupplier = () -> new Tratta(faker.address().fullAddress(), faker.address().fullAddress(), rndm.nextInt(25, 60));
        Supplier<Veicolo> veicoloSupplier = () -> new Veicolo(Stato_Veicolo.randomStatoVeicolo(), Tipo_Veicolo.randomTipoVeicolo());

        System.out.println("Hello World!");
    }
}
