package com.caps.dev.DAO;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.caps.dev.personBeans.Person;

public class DAOHibernet implements DAOInterface{
	public  void create(Person person)
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(person);
		tx.commit();
	}
	public Person search(Person person)
	{	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		 person = em.find(Person.class, person.getId());
			tx.commit();
		return person;
		}
	public void delete(Person person)
	{EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	person=em.find(Person.class,person.getId());
	em.remove(person);
	tx.commit();
	
	}
	public void update(Person person)
	{
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		person=em.find(Person.class,person.getId());
		person=em.find(Person.class,person.getAge());
		person.setAge(person.getAge());
		tx.commit();
	}
}
