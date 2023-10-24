package Main.DAO;

import Main.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

        public Utente getById(long id) {
            return em.find(Utente.class, id);

        }

        public void delete(long id) {
            Utente selectedEl = em.find(Utente.class, id);
            if (selectedEl != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(selectedEl);
                transaction.commit();
                System.out.println("L'utente con l'id " + id + " é stato correttamente cancellato");
            } else {
                System.err.println("Il utente con l'id " + id + " non esiste");
            }
        }
}
