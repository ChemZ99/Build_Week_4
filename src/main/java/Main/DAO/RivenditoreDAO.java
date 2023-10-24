package Main.DAO;

import Main.Entities.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(rivenditore);
        transaction.commit();
        System.out.println("Rivenditore salvato correttamente");
    }

    public Rivenditore getById(long id) {
        return em.find(Rivenditore.class, id);

    }

    public void delete(long id) {
        Rivenditore selectedEl = em.find(Rivenditore.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il rivenditore con l'id " + id + " é stata correttamente cancellato");
        } else {
            System.err.println("Il rivenditore con l'id " + id + " non esiste");
        }
    }
}
