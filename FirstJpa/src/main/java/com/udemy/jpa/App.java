package com.udemy.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory entityMannagerFactory = Persistence.createEntityManagerFactory("com.udemy.jpa");
		EntityManager entityManager = entityMannagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		/*Named query*/
		
		TypedQuery<Person> query = entityManager.createNamedQuery("person.getAll", Person.class);
		List <Person> people = query.getResultList();
		
		TypedQuery<Person> query1 = entityManager.createNamedQuery("person.getById", Person.class);
		query.setParameter("id", 1);
		
		TypedQuery<Person> query2 = entityManager.createNamedQuery("person.getByName", Person.class);
		query.setParameter("id", "marco");

		for(Person person : people) {
			System.out.println(person);
		}
		
		/* Create new table and insert information */
/*		Person person1 = new Person("MARION", 34);
		Person person2 = new Person("MARIO", 32);
		Person person3 = new Person("MARCO", 31);

		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);

		entityManager.getTransaction().commit();
		 Show info JPQL 
		Query query = entityManager.createQuery("SELECT p from Person p");
		List <Person> people = (List <Person>)query.getResultList();
		
		for(Person person : people) {
			System.out.println(person);
		}*/
		
		/*
		 * Find Person person = entityManager.find(Person.class, 1);
		 * System.out.println(person);
		 */

		/*
		 * Remove entityManager.remove(person);
		 * entityManager.getTransaction().commit();
		 */
		/*
		 * insert Information to a table Student student = new Student();
		 * student.setName("Martini"); student.setAge(34);
		 * 
		 * entityManager.persist(student);
		 * entityManager.getTransaction().commit();
		 */
		entityManager.close();
		entityMannagerFactory.close();
	}

}
