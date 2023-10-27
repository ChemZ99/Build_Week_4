package Main.DAO;

import Main.Entities.Abbonamento;
import Main.Entities.Emissione;
import Main.Entities.Rivenditore;
import Main.Entities.Tessera;
import Main.Enum.Stato_abbonamento;
import Main.Enum.Tipo_Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.UUID;

public class AbbonamentoDAO {
    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(abbonamento);
        transaction.commit();
        System.out.println("Abbonamento salvato correttamente");
    }

    public Abbonamento getById(UUID id) {
        return em.find(Abbonamento.class, id);

    }

    public void delete(UUID id) {
        Abbonamento selectedEl = em.find(Abbonamento.class, id);
        if (selectedEl != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEl);
            transaction.commit();
            System.out.println("L'abbonamento con l'id " + id + " é stato correttamente cancellato");
        } else {
            System.err.println("L'abbonamento con l'id " + id + " non esiste");
        }
    }

    public long getNumAbbByPeriod(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Long> numAbbQuery = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.data_emissione BETWEEN :startDate AND :endDate", Long.class);
        numAbbQuery.setParameter("startDate", startDate);
        numAbbQuery.setParameter("endDate", endDate);
        Long count = numAbbQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di abbonamenti venduti in questo periodo di tempo è: " + count);
        } else {
            System.out.println("Non sono presenti abbonamenti in questo periodo di tempo");
        }
        return count;
    }

    public Long getNumAbbByPV(UUID pv) {
        TypedQuery<Long> numAbbPVQuery = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.punto_emissione.id = :pv", Long.class);
        numAbbPVQuery.setParameter("pv", pv);
        Long count = numAbbPVQuery.getSingleResult();
        if (count > 0) {
            System.out.println("Il numero di abbonamenti venduti dal rivenditore con ID " + pv + " é: " + count);
        } else {
            System.out.println("Non sono presenti abbonamenti venduti da questo rivenditore");
        }
        return count;
    }

    public void isSubsciptionValid(UUID idTes) {
        TypedQuery<Stato_abbonamento> isValidQuery = em.createQuery("SELECT a.stato_abbonamento FROM Abbonamento a WHERE a.tessera.id = :idTes", Stato_abbonamento.class);
        isValidQuery.setParameter("idTes", idTes);
        System.out.println("Lo stato dell'abbonamento é: " + isValidQuery.getSingleResult().toString());
    }

    public void renewAbbonamento(UUID id_tes, UUID id_riv, Tipo_Abbonamento t) {
        TypedQuery<Abbonamento> a = em.createQuery("SELECT a FROM Abbonamento a WHERE a.tessera.id = :id ORDER BY a.data_emissione DESC", Abbonamento.class);
        a.setParameter("id", id_tes);
        a.setMaxResults(1);
        TypedQuery<Tessera> tes = em.createQuery("SELECT t FROM Tessera t WHERE t.id= :idT", Tessera.class);
        tes.setParameter("idT", id_tes);
        TypedQuery<Emissione> riv = em.createQuery("SELECT r FROM Emissione r WHERE r.id= :idR", Emissione.class);
        riv.setParameter("idR", id_riv);
        if (a.getSingleResult().getStato_abbonamento() == Stato_abbonamento.SCADUTO) {
            save(new Abbonamento((Rivenditore) riv.getSingleResult(), LocalDate.now(), t, tes.getSingleResult()));
        } else {
            System.out.println("L' abbonamento legato a questa tessera è ancora valido aspetta la scadenza per rinnovarlo");
        }

    }
}

