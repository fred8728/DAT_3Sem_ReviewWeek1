/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static entity.Customer_.created;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fskn
 */
public class EntityTested {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer customer = new Customer();
        Customer customer1 = new Customer("Frederikke", "Nilsson", customer.getCreated());
        Customer customer2 = new Customer("Cathrine", "Nilsson", customer.getCreated());
        Customer customer3 = new Customer("Connie", "Nilsson", customer.getCreated());
        Customer customer4 = new Customer("Peter", "Nilsson", customer.getCreated());
        try {
            em.getTransaction().begin();
            em.persist(customer1);
            /*em.persist(customer2);
            em.persist(customer3);
            em.persist(customer4);*/
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }

}
