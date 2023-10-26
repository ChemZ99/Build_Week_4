package Main.DAO;

import Main.Entities.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class BigliettoDAO {
    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(biglietto);
        transaction.commit();
        System.out.println("Biglietto salvato correttamente");
    }

    public Biglietto getById(UUID id) {
        return em.find(Biglietto.class, id);

    }

    public void delete(UUID id) {
        Biglietto selectedEl = em.find(Biglietto.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il biglietto con l'id " + id + " é stato correttamente cancellato");
        } else {
            System.err.println("Il biglietto con l'id " + id + " non esiste");
        }
    }


    public List<Biglietto> getAllBiglietti() {
        TypedQuery<Biglietto> lista = em.createQuery("SELECT b from Biglietto b", Biglietto.class);
        return lista.getResultList();
    }

    public void getNumTicketsByPeriod(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Long> numTicketQuery = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :startDate AND :endDate", Long.class);
        numTicketQuery.setParameter("startDate", startDate);
        numTicketQuery.setParameter("endDate", endDate);
        Long count = numTicketQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di biglietti venduti in questo periodo di tempo è: " + count);
        } else {
            System.out.println("Non sono presenti biglietti venduti in questo periodo di tempo");
        }
    }

    public void getNumTicketsByPV(UUID pv) {
        TypedQuery<Long> numAbbPVQuery = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.puntoEmissione.id = :pv", Long.class);
        numAbbPVQuery.setParameter("pv", pv);
        Long count = numAbbPVQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di biglietti venduti dal rivenditore con ID " + pv + "é: " + count);
        } else {
            System.out.println("Non sono presenti biglietti venduti da questo rivenditore");
        }
    }

    public void getNumTicketsVitimatiByVeicolo(UUID v) {
        TypedQuery<Long> numAbbPVQuery = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.veicolo.id = :v", Long.class);
        numAbbPVQuery.setParameter("v", v);
        Long count = numAbbPVQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di biglietti vitimati sul veicolo con ID " + v + "é: " + count);
        } else {
            System.out.println("Non sono presenti biglietti vitimati da questo veicolo");
        }
    }

    public void getNumTicketsVitimatiByPeriod(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Long> numTicketQuery = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataVidimazione BETWEEN :startDate AND :endDate", Long.class);
        numTicketQuery.setParameter("startDate", startDate);
        numTicketQuery.setParameter("endDate", endDate);
        Long count = numTicketQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di biglietti vitimati in questo periodo di tempo è: " + count);
        } else {
            System.out.println("Non sono stati vitimati biglietti in questo periodo di tempo");
        }
    }
}
