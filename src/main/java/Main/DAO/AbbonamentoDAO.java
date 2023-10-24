package Main.DAO;

import Main.Entities.Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

    public Abbonamento getById(long id) {
        return em.find(Abbonamento.class, id);

    }

    public void delete(long id) {
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
}
