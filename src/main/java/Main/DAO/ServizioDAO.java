package Main.DAO;

import Main.Entities.Servizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ServizioDAO {
    private final EntityManager em;

    public ServizioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Servizio servizio) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(servizio);
        transaction.commit();
        System.out.println("Servizio salvato correttamente");
    }

    public Servizio getById(long id) {
        return em.find(Servizio.class, id);

    }

    public void delete(long id) {
        Servizio selectedEl = em.find(Servizio.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il servizio con l'id " + id + " é stata correttamente cancellato");
        } else {
            System.err.println("Il servizio con l'id " + id + " non esiste");
        }
    }
}
