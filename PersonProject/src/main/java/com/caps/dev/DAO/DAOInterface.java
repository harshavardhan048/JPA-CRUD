package com.caps.dev.DAO;

import com.caps.dev.personBeans.Person;

public interface DAOInterface {
	public void create(Person person);
	public void update(Person person);
	public Person search(Person person);
	public void delete(Person person);

}
