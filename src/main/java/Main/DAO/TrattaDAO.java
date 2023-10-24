package Main.DAO;

import Main.Entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(tratta);
        transaction.commit();
        System.out.println("Tratta salvata correttamente");
    }

    public Tratta getById(long id) {
        return em.find(Tratta.class, id);

    }

    public List<Tratta> getAllTratte() {
        TypedQuery<Tratta> lista = em.createQuery("SELECT t from Tratta t", Tratta.class);
        return lista.getResultList();
    }

    public void delete(long id) {
        Tratta selectedEl = em.find(Tratta.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("La tratta con l'id " + id + " é stata correttamente cancellata");
        } else {
            System.err.println("La tratta con l'id " + id + " non esiste");
        }
    }
}
