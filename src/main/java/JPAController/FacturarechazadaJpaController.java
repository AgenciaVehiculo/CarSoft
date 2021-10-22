/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Facturarechazada;
import JPAController.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.jpamodelgen.xml.jaxb.Persistence;

/**
 *
 * @author Kur013
 */
public class FacturarechazadaJpaController implements Serializable {

    public FacturarechazadaJpaController(EntityManagerFactory emf) {
        this.emf= emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Facturarechazada facturarechazada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(facturarechazada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
        public boolean createTest(Facturarechazada facturarechazada) {
        EntityManager em = null;
        try {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public void edit(Facturarechazada facturarechazada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            facturarechazada = em.merge(facturarechazada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = facturarechazada.getIdRechazo();
                if (findFacturarechazada(id) == null) {
                    throw new NonexistentEntityException("The facturarechazada with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
   public boolean editTest(Facturarechazada facturarechazada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = facturarechazada.getIdRechazo();
                if (findFacturarechazada(id) == null) {
                    throw new NonexistentEntityException("The facturarechazada with id " + id + " no longer exists.");
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
            Facturarechazada facturarechazada;
            try {
                facturarechazada = em.getReference(Facturarechazada.class, id);
                facturarechazada.getIdRechazo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturarechazada with id " + id + " no longer exists.", enfe);
            }
            em.remove(facturarechazada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Facturarechazada> findFacturarechazadaEntities() {
        return findFacturarechazadaEntities(true, -1, -1);
    }

    public List<Facturarechazada> findFacturarechazadaEntities(int maxResults, int firstResult) {
        return findFacturarechazadaEntities(false, maxResults, firstResult);
    }

    private List<Facturarechazada> findFacturarechazadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Facturarechazada.class));
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

    public Facturarechazada findFacturarechazada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Facturarechazada.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturarechazadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Facturarechazada> rt = cq.from(Facturarechazada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
