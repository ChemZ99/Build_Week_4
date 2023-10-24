package Main;

import Main.DAO.*;
import Main.Entities.*;
import Main.Enum.Stato_Distributore;
import Main.Enum.Stato_Veicolo;
import Main.Enum.Tipo_Veicolo;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BUILD_WEEK_4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EmissioneDAO emissioneDAO = new EmissioneDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        VeicoloDAO veicoloDAO = new VeicoloDAO(em);
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
        BigliettoDAO bigliettoDAO = new BigliettoDAO(em);
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO(em);
        ServizioDAO servizioDAO = new ServizioDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();
        Supplier<Utente> utenteSupplier = () -> new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.now().minusYears(rndm.nextInt(12, 70)).minusDays(rndm.nextInt(0, 365)));
        Supplier<Rivenditore> rivenditoreSupplier = () -> new Rivenditore(faker.address().streetAddress());
        Supplier<Distributore> distributoreSupplier = () -> new Distributore(faker.address().streetAddress(), Stato_Distributore.randomDistributore());
        Supplier<Tratta> trattaSupplier = () -> new Tratta(faker.address().streetAddress(), faker.address().streetAddress(), rndm.nextInt(25, 60));
        Supplier<Veicolo> veicoloSupplier = () -> new Veicolo(Stato_Veicolo.randomStatoVeicolo(), Tipo_Veicolo.randomTipoVeicolo());


        //CREIAMO RIVENDITORI E DISTRIBUTORI

        //     for (int i = 0; i < 10; i++) {
        //           emissioneDAO.save(rivenditoreSupplier.get());
//            emissioneDAO.save(distributoreSupplier.get());
//        }


        // LISTA DEI RIVENDITORI NON FUORI SERVIZIO
        List<Emissione> lista = emissioneDAO.getAllEmissione();


        //CREIAMO BIGLIETTI
        //  for (int i = 0; i < 500; i++) {
        //     int c = rndm.nextInt(0, lista.size() - 1);
        //     Emissione emis = lista.get(c);
        //     Supplier<Biglietto> bigliettoSupplier = () -> new Biglietto(LocalDate.now().minusYears(rndm.nextInt(0, 10)).minusDays(rndm.nextInt(0, 365)), emis);
        //      bigliettoDAO.save(bigliettoSupplier.get());
        //   }

// creaìiamo nuovi utenti

        //   for (int i = 0; i < 100; i++) {
        //     Utente u = utenteSupplier.get();
        //     utenteDAO.save(u);
        //     Supplier<Tessera> tesseraSupplier = () -> new Tessera(LocalDate.now().minusDays(rndm.nextInt(0, 365)), u);
        //      tesseraDAO.save(tesseraSupplier.get());

        //  }

        //LISTA TUTTE LE TESSERE
        List<Tessera> listaTess = tesseraDAO.getAllTessere();
        //LISTA SOLO RIVENDITORI PER FARE ABBONAMENTI
        List<Rivenditore> listaRiv = emissioneDAO.getAllRivenditori();


        //for (int i = 0; i < listaTess.size(); i++) {
        //    int c = rndm.nextInt(0, listaRiv.size() - 1);
        //    Rivenditore riv = listaRiv.get(c);
        //    int finalI = i;
        //    Supplier<Abbonamento> abbonamentoSupplier = () -> new Abbonamento(riv, LocalDate.now().minusDays(rndm.nextInt(0, 180)), Tipo_Abbonamento.randomTipoAbbonamento(), listaTess.get(finalI));
        //    abbonamentoDAO.save(abbonamentoSupplier.get());
        // }

        //CREIAMO VEICOLI

        // for (int i = 0; i < 100; i++) {
        //    veicoloDAO.save(veicoloSupplier.get());
        // }


        //CREIAMO TRATTE
        for (int i = 0; i < 100; i++) {
            trattaDAO.save(trattaSupplier.get());

        }
        System.out.println("Hello World!");
    }
}
