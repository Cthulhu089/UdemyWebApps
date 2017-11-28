package com.udemy.inheritance.joinedTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory entityMannagerFactory = Persistence.createEntityManagerFactory("com.udemy.jpa");
		EntityManager entityManager = entityMannagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Car car = new Car("Tsuru", 100);
		Bus bus = new Bus("Yellow bus", 200);
		
		entityManager.persist(car);
		entityManager.persist(bus);
		
		entityManager.close();
		entityMannagerFactory.close();
	}

}
