package Main.DAO;

import Main.Entities.Tessera;
import Main.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class TesseraDAO {
    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(tessera);
        transaction.commit();
        System.out.println("Tessera salvata correttamente");
    }

    public Tessera getById(UUID id) {
        return em.find(Tessera.class, id);

    }

    public void delete(UUID id) {
        Tessera selectedEl = em.find(Tessera.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("La tessera con l'id " + id + " é stato correttamente cancellato");
        } else {
            System.err.println("La tessera con l'id " + id + " non esiste");
        }
    }
}
