/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoPago;
import JPAController.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kur013
 */
public class TipoPagoJpaController implements Serializable {

    public TipoPagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoPago tipoPago) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public boolean createTest(TipoPago tipoPago) {
        EntityManager em = null;
        try {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }
    public void edit(TipoPago tipoPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoPago = em.merge(tipoPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoPago.getIdTipoPago();
                if (findTipoPago(id) == null) {
                    throw new NonexistentEntityException("The tipoPago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public boolean editTest(TipoPago tipoPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoPago.getIdTipoPago();
                if (findTipoPago(id) == null) {
                    throw new NonexistentEntityException("The tipoPago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoPago tipoPago;
            try {
                tipoPago = em.getReference(TipoPago.class, id);
                tipoPago.getIdTipoPago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoPago with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoPago> findTipoPagoEntities() {
        return findTipoPagoEntities(true, -1, -1);
    }

    public List<TipoPago> findTipoPagoEntities(int maxResults, int firstResult) {
        return findTipoPagoEntities(false, maxResults, firstResult);
    }

    private List<TipoPago> findTipoPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoPago.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoPago findTipoPago(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoPago.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoPago> rt = cq.from(TipoPago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
