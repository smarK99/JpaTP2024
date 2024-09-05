package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //Creo la factory de managers
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        //Se crea un manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Running program...");

        //Crear cosas aca con try-catch

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
