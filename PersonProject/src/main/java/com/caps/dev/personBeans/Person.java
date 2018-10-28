package com.caps.dev.personBeans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons_info")
public class Person {
	@Id @Column(name="person_id")
private int id;
	@Column(name="person_age")
private int age;
	@Column(name="person_name")
private String name;
	@Column(name="person_email")
private String email;
	@Column(name="person_address")
private String address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Person [id=" + id + ", age=" + age + ", name=" + name + ", email=" + email + ", address=" + address + "]";
}

}
