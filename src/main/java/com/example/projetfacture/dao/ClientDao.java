package com.example.projetfacture.dao;


import com.example.projetfacture.models.ClientEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<ClientEntity> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");

    @Override
    public Optional<ClientEntity> get(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            ClientEntity client = em.createQuery("SELECT c FROM ClientEntity c WHERE c.id = :idParam", ClientEntity.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(client);
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
    public List<ClientEntity> getAll() {
        List<ClientEntity> clientList = new ArrayList<>();

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();

        try{
            et.begin();

            TypedQuery<ClientEntity> query = entityManager.createQuery("SELECT c from ClientEntity c", ClientEntity.class);
            clientList = query.getResultList();
            et.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(et.isActive()) {et.rollback();}
        } finally {
            entityManager.close();
        }
        return clientList;
    }

    @Override
    public void save(ClientEntity clientEntity) {

    }

    @Override
    public void update(ClientEntity clientEntity) {

    }

    @Override
    public void update(int idParam, String name, String description) {

    }

    @Override
    public void delete(ClientEntity clientEntity) {

    }
}
