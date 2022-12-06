

package com.example.projetfacture.dao;

import com.example.projetfacture.models.InvoiceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.projetfacture.utilities.EntityManager.getEntityInstance;

public class DaoInvoice implements Dao<InvoiceEntity> {

    private EntityManagerFactory emf = getEntityInstance();

    public Optional<List<InvoiceEntity>> getInvoiceByIdClient(int idClient){
        List<InvoiceEntity> invoiceList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();

            TypedQuery<InvoiceEntity> query = em.createQuery("SELECT f from InvoiceEntity f INNER JOIN ClientEntity c ON f.idClient = :idParam", InvoiceEntity.class)
                    .setParameter("idParam", idClient);
            invoiceList = query.getResultList();
            et.commit();
            return Optional.of(invoiceList);
        }catch (Exception e){
            e.printStackTrace();
            if(et.isActive()) {et.rollback();}
        } finally {
            em.close();
        }
        return Optional.empty();
    }


    @Override
    public Optional<InvoiceEntity> get(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            InvoiceEntity invoice = em.createQuery("SELECT b FROM InvoiceEntity b WHERE b.id = :idParam", InvoiceEntity.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(invoice);
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public List<InvoiceEntity> getAll() {
        List<InvoiceEntity> invoiceList = new ArrayList<>();

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();

        try{
            et.begin();

            TypedQuery<InvoiceEntity> query = entityManager.createQuery("SELECT g from InvoiceEntity g", InvoiceEntity.class);
            invoiceList = query.getResultList();
            et.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(et.isActive()) {et.rollback();}
        } finally {
            entityManager.close();
        }
        return invoiceList;
    }

    @Override
    public void save(InvoiceEntity invoiceEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(invoiceEntity);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void update(InvoiceEntity invoiceEntity) {
        InvoiceEntity invoiceUpdated = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            invoiceUpdated = em.merge(invoiceEntity);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }


    @Override
    public void delete(InvoiceEntity invoiceEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            InvoiceEntity invoiceToDelete = em.find(InvoiceEntity.class, invoiceEntity.getIdInvoice());
            em.remove(invoiceToDelete);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}
