package Main.DAO;

import Main.Entities.Veicolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public Veicolo getById(long id) {
        return em.find(Veicolo.class, id);

    }

    public void delete(long id) {
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

    public List<Veicolo> getAllVeicoli() {
        TypedQuery<Veicolo> lista = em.createQuery("SELECT v from Veicolo v", Veicolo.class);
        return lista.getResultList();
    }

    public List<Veicolo> getAllVeicoliServizio() {
        TypedQuery<Veicolo> lista = em.createQuery("SELECT v from Veicolo v WHERE stato= 'SERVIZIO'", Veicolo.class);
        return lista.getResultList();
    }

    public List<Veicolo> getAllVeicoliManutenzione() {
        TypedQuery<Veicolo> lista = em.createQuery("SELECT v from Veicolo v WHERE stato= 'MANUTENZIONE'", Veicolo.class);
        return lista.getResultList();
    }
}
