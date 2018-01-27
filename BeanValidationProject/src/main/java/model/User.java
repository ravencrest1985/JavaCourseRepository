package model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.pl.PESEL;

import validation.NotZero;
import validation.OddNumber;






public class User {
	
	@NotNull
	private String userName;
	@Size(min=2,max=10)
	private String firstName;
	@Size(min=2,max=10)
	private String lastName;
	@Past
	private Date birthDate;
	@PESEL
	private String pesel;
	@Min(13)
	private int age;
	@Email
	private String email;
	@OddNumber
	private int NotOddNumber;
	@NotZero
	private int number;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNotOddNumber() {
		return NotOddNumber;
	}
	public void setNotOddNumber(int notOddNumber) {
		NotOddNumber = notOddNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
