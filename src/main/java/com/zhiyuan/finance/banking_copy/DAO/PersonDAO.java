package com.zhiyuan.finance.banking_copy.DAO;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;

import java.util.List;

public interface PersonDAO {
    public PersonPersistence insertPerson(PersonPersistence personPersistence);

    public PersonPersistence updatePerson(int personId, String name);

    public int deletePerson(int personId);

    public PersonPersistence fetchPerson(int personId);

    public List<PersonPersistence> fetchAllPerson();

    public List<PersonPersistence> getPersonByName(String name);
}
