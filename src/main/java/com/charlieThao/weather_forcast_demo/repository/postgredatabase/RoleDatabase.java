package com.charlieThao.weather_forcast_demo.repository.postgredatabase;

import com.charlieThao.weather_forcast_demo.model.Role;
import com.charlieThao.weather_forcast_demo.repository.DatabaseInterface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoleDatabase implements DatabaseInterface<Role, String> {

    @PersistenceContext
    private EntityManager entityManager;

    public RoleDatabase(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean creat(Role item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Role getById(String id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getList(int limit) {
        return entityManager.createQuery("select r from Role r", Role.class)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public Role updateById(String id, Role item) {
        item.setId(id);
        try {
            entityManager.getTransaction().begin();
            Role role = entityManager.merge(item);
            entityManager.getTransaction().commit();
            return role;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(getById(id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Role> search(String s, int limit) {
        return entityManager
                .createQuery("select r from Role r where r.description like :query", Role.class)
                .setParameter("query", "%"+s+"%")
                .setMaxResults(limit)
                .getResultList();
    }
}
