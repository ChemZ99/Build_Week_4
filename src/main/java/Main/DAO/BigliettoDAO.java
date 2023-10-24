package Main.DAO;

import Main.Entities.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class BigliettoDAO {
    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(biglietto);
        transaction.commit();
        System.out.println("Biglietto salvato correttamente");
    }

    public Biglietto getById(long id) {
        return em.find(Biglietto.class, id);

    }

    public void delete(long id) {
        Biglietto selectedEl = em.find(Biglietto.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("Il biglietto con l'id " + id + " é stato correttamente cancellato");
        } else {
            System.err.println("Il biglietto con l'id " + id + " non esiste");
        }
    }

    public List<Biglietto> getAllBiglietti() {
        TypedQuery<Biglietto> lista = em.createQuery("SELECT b from Biglietto b", Biglietto.class);
        return lista.getResultList();
    }
}
