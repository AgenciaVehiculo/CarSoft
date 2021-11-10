/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.RazonSocial;
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
public class RazonSocialJpaController implements Serializable {

    public RazonSocialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RazonSocial razonSocial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(razonSocial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
        public boolean createTest(RazonSocial razonSocial) {
        EntityManager em = null;
        try {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public void edit(RazonSocial razonSocial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            razonSocial = em.merge(razonSocial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = razonSocial.getIdRazonSocial();
                if (findRazonSocial(id) == null) {
                    throw new NonexistentEntityException("The razonSocial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        public boolean editTest(RazonSocial razonSocial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = razonSocial.getIdRazonSocial();
                if (findRazonSocial(id) == null) {
                    throw new NonexistentEntityException("The razonSocial with id " + id + " no longer exists.");
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
            RazonSocial razonSocial;
            try {
                razonSocial = em.getReference(RazonSocial.class, id);
                razonSocial.getIdRazonSocial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The razonSocial with id " + id + " no longer exists.", enfe);
            }
            em.remove(razonSocial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RazonSocial> findRazonSocialEntities() {
        return findRazonSocialEntities(true, -1, -1);
    }

    public List<RazonSocial> findRazonSocialEntities(int maxResults, int firstResult) {
        return findRazonSocialEntities(false, maxResults, firstResult);
    }

    private List<RazonSocial> findRazonSocialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RazonSocial.class));
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

    public RazonSocial findRazonSocial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RazonSocial.class, id);
        } finally {
            em.close();
        }
    }

    public int getRazonSocialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RazonSocial> rt = cq.from(RazonSocial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
