package com.zhiyuan.finance.banking_copy.DAO.impl;

import com.zhiyuan.finance.banking_copy.DAO.PersonDAO;
import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository("personDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonDAOImpl implements PersonDAO{
    Logger log = LoggerFactory.getLogger(PersonDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {

        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PersonPersistence insertPerson(PersonPersistence personPersistence) {
        log.info("Insert data for {}",personPersistence.getFullName());
        entityManager.persist(personPersistence);
        entityManager.flush();
        log.info("PersonId generated:{} ", personPersistence.getPersonId());

        return personPersistence;
    }

    @Override
    public PersonPersistence updatePerson(int personId, String name) {
        return null;
    }

    @Override
    public int deletePerson(int personId) {
        return 0;
    }

    @Override
    public PersonPersistence fetchPerson(int personId) {
        return null;
    }

    @Override
    public List<PersonPersistence> fetchAllPerson() {
        return null;
    }
}
