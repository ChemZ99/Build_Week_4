package Main.DAO;

import Main.Entities.Manutenzione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ManutenzioneDAO {
    private final EntityManager em;

    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Manutenzione manutenzione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manutenzione);
        transaction.commit();
        System.out.println("Manutenzione salvata correttamente");
    }

    public Manutenzione getById(long id) {
        return em.find(Manutenzione.class, id);

    }

    public void delete(long id) {
        Manutenzione selectedEl = em.find(Manutenzione.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("La manutenzione con l'id " + id + " é stata correttamente cancellata");
        } else {
            System.err.println("La manutenzione con l'id " + id + " non esiste");
        }
    }
}
