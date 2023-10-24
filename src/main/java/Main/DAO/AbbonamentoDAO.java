package Main.DAO;

import Main.Entities.Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class AbbonamentoDAO {
    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(abbonamento);
        transaction.commit();
        System.out.println("Abbonamento salvato correttamente");
    }

    public Abbonamento getById(UUID id) {
        return em.find(Abbonamento.class, id);

    }

    public void delete(UUID id) {
        Abbonamento selectedEl = em.find(Abbonamento.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("L'abbonamento con l'id " + id + " é stato correttamente cancellato");
        } else {
            System.err.println("L'abbonamento con l'id " + id + " non esiste");
        }
    }

    public void getNumAbbByPeriod(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Long> numAbbQuery = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.data_emissione BETWEEN :startDate AND :endDate", Long.class);
        numAbbQuery.setParameter("startDate", startDate);
        numAbbQuery.setParameter("endDate", endDate);
        Long count = numAbbQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di abbonamenti in questo periodo di tempo è: " + count);
        } else {
            System.out.println("Non sono presenti abbonamenti in questo periodo di tempo");
        }
    }
}

