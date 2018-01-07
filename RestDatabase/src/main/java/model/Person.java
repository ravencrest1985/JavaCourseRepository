package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
@NamedQuery(name = "findQueryPersons", query = "select p from Person p"),
@NamedQuery(name = "findQueryPerson", query = "select p from Person p where p.id=:id")
})

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personId")
	private long id;
	@Column(name = "personName")
	private String name;
	@Column(name = "personAge")
	private int age;
	@OneToMany(mappedBy = "person")
	private List<PhoneNumber> phones;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
