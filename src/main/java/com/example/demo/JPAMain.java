package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TESTDB");

	}

}
