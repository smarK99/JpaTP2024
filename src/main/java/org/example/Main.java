package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creo la factory de managers
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        //Se crea un manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Running program...");

        //Crear cosas aca con try-catch
        try {
            entityManager.getTransaction().begin();

            //Domicilios

            Domicilio domicilio1 = Domicilio.builder()
                    .id(1L)
                    .numero(11)
                    .nombreCalle("AvenidaSiempreViva")
                    .build();

            //Clientes

            Cliente cliente1 = Cliente.builder()
                    .id(1L)
                    .dni(23456987)
                    .nombre("Ned")
                    .apellido("Flanders")
                    .domicilio(domicilio1)
                    .build();

            //Categorias

            Categoria categoria1 = Categoria.builder()
                    .id(1L)
                    .denominacion("Finanzas")
                    .build();

            Categoria categoria2 = Categoria.builder()
                    .id(2L)
                    .denominacion("Emprendimientos")
                    .build();

            Categoria categoria3 = Categoria.builder()
                    .id(3L)
                    .denominacion("Fantasia")
                    .build();

            //Articulos

            Articulo articulo1 = Articulo.builder()
                    .id(1L)
                    .precio(500)
                    .cantidad(4)
                    .denominacion("El toque de midas")
                    .categorias(List.of(categoria1,categoria2))
                    .build();
            Articulo articulo2 = Articulo.builder()
                    .id(2L)
                    .precio(600)
                    .cantidad(10)
                    .denominacion("Harry Potter y el misterio del principe")
                    .categorias(List.of(categoria3))
                    .build();

            //Detalles

            DetalleFactura detalle1 = DetalleFactura.builder()
                    .id(1L)
                    .articulo(articulo1)
                    .subtotal(1000)
                    .cantidad(2)
                    .build();
            DetalleFactura detalle2 = DetalleFactura.builder()
                    .id(2L)
                    .articulo(articulo2)
                    .subtotal(600)
                    .cantidad(2)
                    .build();

            //Facturas

            Factura factura1 = Factura.builder()
                    .id(1L)
                    .numero(1)
                    .total(1000)
                    .fecha("8/9/2024")
                    .detallesFactura(List.of(detalle1,detalle2))
                    .cliente(cliente1)
                    .build();

            entityManager.persist(factura1);

            entityManager.flush();
            entityManager.getTransaction().commit();


            // Consultar y mostrar la entidad persistida
            Factura retrievedFactura = entityManager.find(Factura.class, factura1.getId());
            System.out.println("Retrieved Person: " + retrievedFactura.toString());

        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Factura");
        }


        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
