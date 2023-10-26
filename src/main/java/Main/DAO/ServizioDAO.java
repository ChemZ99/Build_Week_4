package Main.DAO;

import Main.Entities.Servizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.UUID;

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

    public Servizio getById(UUID id) {
        return em.find(Servizio.class, id);

    }

    public void delete(UUID id) {
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

    public void servizioDetails(UUID s) {
        TypedQuery<Servizio> servizioQuery = em.createQuery("SELECT s FROM Servizio s INNER JOIN Tratta t ON t.id=s.tratta.id  WHERE s.id = :sid ", Servizio.class);
        servizioQuery.setParameter("sid", s);

        System.out.println(servizioQuery.getSingleResult());
    }
}
