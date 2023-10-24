package Main.DAO;

import Main.Entities.Emissione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class EmissioneDAO {
    private final EntityManager em;

    public EmissioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Emissione e) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
        System.out.println("Punto vendita salvato correttamente");
    }

    public Emissione getById(UUID id) {
        return em.find(Emissione.class, id);

    }

    public void delete(UUID id) {
        Emissione selectedEl = em.find(Emissione.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il punto vendita con l'id " + id + " é stata correttamente cancellato");
        } else {
            System.err.println("Il punto vendita con l'id " + id + " non esiste");
        }
    }
}
