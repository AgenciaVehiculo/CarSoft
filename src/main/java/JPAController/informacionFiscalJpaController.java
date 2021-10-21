/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.informacionFiscal;
import JPAController.exceptions.NonexistentEntityException;
import JPAController.exceptions.PreexistingEntityException;
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
public class informacionFiscalJpaController implements Serializable {

    public informacionFiscalJpaController(EntityManagerFactory emf) {
        this.emf= emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(informacionFiscal informacionFiscal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(informacionFiscal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findinformacionFiscal(informacionFiscal.getIdInf()) != null) {
                throw new PreexistingEntityException("informacionFiscal " + informacionFiscal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(informacionFiscal informacionFiscal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            informacionFiscal = em.merge(informacionFiscal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = informacionFiscal.getIdInf();
                if (findinformacionFiscal(id) == null) {
                    throw new NonexistentEntityException("The informacionFiscal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            informacionFiscal informacionFiscal;
            try {
                informacionFiscal = em.getReference(informacionFiscal.class, id);
                informacionFiscal.getIdInf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The informacionFiscal with id " + id + " no longer exists.", enfe);
            }
            em.remove(informacionFiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<informacionFiscal> findinformacionFiscalEntities() {
        return findinformacionFiscalEntities(true, -1, -1);
    }

    public List<informacionFiscal> findinformacionFiscalEntities(int maxResults, int firstResult) {
        return findinformacionFiscalEntities(false, maxResults, firstResult);
    }

    private List<informacionFiscal> findinformacionFiscalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(informacionFiscal.class));
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

    public informacionFiscal findinformacionFiscal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(informacionFiscal.class, id);
        } finally {
            em.close();
        }
    }

    public int getinformacionFiscalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<informacionFiscal> rt = cq.from(informacionFiscal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
