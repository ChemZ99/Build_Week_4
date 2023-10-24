package Main.DAO;

import Main.Entities.Distributore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DistributoreDAO {
    private final EntityManager em;

    public DistributoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Distributore distributore) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(distributore);
        transaction.commit();
        System.out.println("Distributore salvato correttamente");
    }

    public Distributore getById(long id) {
        return em.find(Distributore.class, id);

    }

    public void delete(long id) {
        Distributore selectedEl = em.find(Distributore.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il distributore con l'id " + id + " é stato correttamente cancellata");
        } else {
            System.err.println("Il distributore con l'id " + id + " non esiste");
        }
    }
}
