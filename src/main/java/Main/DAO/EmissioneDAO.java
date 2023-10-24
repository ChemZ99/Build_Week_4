package Main.DAO;

import Main.Entities.Emissione;
import Main.Entities.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
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

    public List<Emissione> getAllEmissione() {
        TypedQuery<Emissione> lista = em.createQuery("SELECT e from Emissione e WHERE stato != 'FUORI_SERVIZIO' OR stato IS null", Emissione.class);
        return lista.getResultList();
    }

    public List<Rivenditore> getAllRivenditori() {
        TypedQuery<Rivenditore> lista = em.createQuery("SELECT e from Rivenditore e WHERE stato IS null", Rivenditore.class);
        return lista.getResultList();
    }
}
