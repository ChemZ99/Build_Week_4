package Main.DAO;

import Main.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class UtenteDAO {
        private final EntityManager em;

        public UtenteDAO(EntityManager em) {
            this.em = em;
        }

        public void save(Utente utente) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(utente);
            transaction.commit();
            System.out.println("Utente salvato correttamente");
        }

        public Utente getById(UUID id) {
            return em.find(Utente.class, id);

        }

        public void delete(UUID id) {
            Utente selectedEl = em.find(Utente.class, id);
            if (selectedEl != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(selectedEl);
                transaction.commit();
                System.out.println("L'utente con l'id " + id + " é stato correttamente cancellato");
            } else {
                System.err.println("L'utente con l'id " + id + " non esiste");
            }
        }
}
