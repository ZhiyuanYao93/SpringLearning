package com.zhiyuan.finance.banking_copy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;

    @Column(name="username")
    private String name;

    @Column(name="password")
    private String pwd;

    @ManyToOne
    @JoinColumn(name="personId")
    @JsonIgnore
    private PersonPersistence personPersistence;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public PersonPersistence getPersonPersistence() {
        return personPersistence;
    }

    public void setPersonPersistence(PersonPersistence personPersistence) {
        this.personPersistence = personPersistence;
    }
}
