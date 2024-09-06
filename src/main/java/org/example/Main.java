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
        /*
        try {
            // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();

            Persona person = new Persona("Pepe", 25);


            person.setName("Facu Cortez");
            person.setAge(60);

            entityManager.persist(person);

            entityManager.getTransaction().commit();


            // Consultar y mostrar la entidad persistida
            Persona retrievedPerson = entityManager.find(Persona.class, person.getId());
            System.out.println("Retrieved Person: " + retrievedPerson.getName());

        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Persona");
        }
        */

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
