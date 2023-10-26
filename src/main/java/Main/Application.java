package Main;

import Main.DAO.*;
import Main.Entities.*;
import Main.Enum.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
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
        Random rndm = new Random();

        //RIEMPIMENTO DATABASE
        //fillerDataBase();

    }

    public static void fillerDataBase() {
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
        Supplier<Tratta> trattaSupplier = () -> new Tratta(faker.address().streetAddress(), faker.address().streetAddress(), rndm.nextInt(40, 60));
        Supplier<Veicolo> veicoloSupplier = () -> new Veicolo(Stato_Veicolo.randomStatoVeicolo(), Tipo_Veicolo.randomTipoVeicolo());


        //CREIAMO RIVENDITORI E DISTRIBUTORI

        for (int i = 0; i < 50; i++) {
            emissioneDAO.save(rivenditoreSupplier.get());
            emissioneDAO.save(distributoreSupplier.get());
        }


        // LISTA DEI RIVENDITORI NON FUORI SERVIZIO
        List<Emissione> lista = emissioneDAO.getAllEmissione();


        //CREIAMO BIGLIETTI
        for (int i = 0; i < 2500; i++) {
            int c = rndm.nextInt(0, lista.size() - 1);
            Emissione emis = lista.get(c);
            Supplier<Biglietto> bigliettoSupplier = () -> new Biglietto(LocalDate.now().minusYears(rndm.nextInt(0, 10)).minusDays(rndm.nextInt(0, 365)), emis);
            bigliettoDAO.save(bigliettoSupplier.get());
        }

// creaìiamo nuovi utenti

        for (int i = 0; i < 100; i++) {
            Utente u = utenteSupplier.get();
            utenteDAO.save(u);
            Supplier<Tessera> tesseraSupplier = () -> new Tessera(LocalDate.now().minusDays(rndm.nextInt(0, 365)), u);
            tesseraDAO.save(tesseraSupplier.get());

        }

        //LISTA TUTTE LE TESSERE
        List<Tessera> listaTess = tesseraDAO.getAllTessere();
        //LISTA SOLO RIVENDITORI PER FARE ABBONAMENTI
        List<Rivenditore> listaRiv = emissioneDAO.getAllRivenditori();


        for (int i = 0; i < listaTess.size(); i++) {
            int c = rndm.nextInt(0, listaRiv.size() - 1);
            Rivenditore riv = listaRiv.get(c);
            int finalI = i;
            Supplier<Abbonamento> abbonamentoSupplier = () -> new Abbonamento(riv, LocalDate.now().minusDays(rndm.nextInt(0, 180)), Tipo_Abbonamento.randomTipoAbbonamento(), listaTess.get(finalI));
            abbonamentoDAO.save(abbonamentoSupplier.get());
        }

        //CREIAMO VEICOLI

        for (int i = 0; i < 150; i++) {
            veicoloDAO.save(veicoloSupplier.get());
        }


        //CREIAMO TRATTE
        for (int i = 0; i < 80; i++) {
            trattaDAO.save(trattaSupplier.get());

        }

        //LISTA DI VEICOLI IN MANUTENZIONE
        List<Veicolo> listaVecMan = veicoloDAO.getAllVeicoliManutenzione();

        for (int i = 0; i < listaVecMan.size(); i++) {
            int finalI = i;
            Supplier<Manutenzione> manutenzioneSupplier = () -> new Manutenzione(LocalDate.now().minusDays(rndm.nextInt(0, 30)), null, listaVecMan.get(finalI));
            manutenzioneDAO.save(manutenzioneSupplier.get());
        }

        //LISTA VEICOLI IN SERVIZIO
        List<Veicolo> listaVecSer = veicoloDAO.getAllVeicoliServizio();

        //LISTA TRATTE
        List<Tratta> listaTra = trattaDAO.getAllTratte();

        // CREIAMO SERVIZI Per un intero mese
        for (int k = 30; k > 0; k--) {
            LocalDateTime d1 = LocalDateTime.now().minusDays(k);
            for (int i = 0; i < listaVecSer.size(); i++) {
                int c = rndm.nextInt(0, listaTra.size() - 1);
                Tratta tratta = listaTra.get(c);
                int finalI1 = i;
                Supplier<Servizio> servizioSupplier = () -> new Servizio(d1.minusHours(rndm.nextInt(0, 24)), listaVecSer.get(finalI1), tratta);
                servizioDAO.save(servizioSupplier.get());
            }
        }

// LISTA BIGLIETTI
        List<Biglietto> listaBig = bigliettoDAO.getAllBiglietti();


        // VITIMAZIONE BIGLIETTI RANDOM
        for (int i = 0; i < listaBig.size(); i++) {
            int c = rndm.nextInt(0, 100);
            if (c % 2 == 0) {
                int v = rndm.nextInt(0, listaVecSer.size() - 1);
                LocalDate d;
                do {
                    d = listaBig.get(i).getDataEmissione().plusDays(rndm.nextInt(0, 365));
                } while (d.isAfter(LocalDate.now()));
                Biglietto b = listaBig.get(i);
                b.setStato(Stato_Biglietto.VITIMATO);
                b.setVeicolo(listaVecSer.get(v));
                b.setDataVidimazione(d);
                bigliettoDAO.save(b);
            }
        }

    }
}
