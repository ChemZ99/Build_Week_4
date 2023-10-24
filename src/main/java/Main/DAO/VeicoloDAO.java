package Main.DAO;

import Main.Entities.Veicolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class VeicoloDAO {
    private final EntityManager em;

    public VeicoloDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Veicolo veicolo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(veicolo);
        transaction.commit();
        System.out.println("Veicolo salvato correttamente");
    }

    public Veicolo getById(UUID id) {
        return em.find(Veicolo.class, id);

    }

    public void delete(UUID id) {
        Veicolo selectedEl = em.find(Veicolo.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il veicolo con l'id " + id + " é stata correttamente cancellato");
        } else {
            System.err.println("Il veicolo con l'id " + id + " non esiste");
        }
    }
}
