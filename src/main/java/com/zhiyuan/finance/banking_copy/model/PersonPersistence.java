package com.zhiyuan.finance.banking_copy.model;

import javax.persistence.*;

/**
 * 
 * @author zhiyuanyao
 *
 */
@Entity
@Table(name="PERSON")
@NamedQueries({
	@NamedQuery(name="fetchbyname",query="SELECT p FROM PersonPersistence p WHERE p.fullName=?"),
		@NamedQuery(name="fetchbyage",query="SELECT p FROM PersonPersistence p WHERE p.age=?")

})
public class PersonPersistence {
	//variable name has NOTHING to do with column names in DB table. 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="personId")
	private int personId;
	
	@Column(name="age")
	private int age;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="usercity")
	private String city;
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


}
