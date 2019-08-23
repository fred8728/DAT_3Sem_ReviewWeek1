/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author fskn
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public CustomerFacade() {

    }

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
            em.persist(customer2);
            em.persist(customer3);
            em.persist(customer4);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        System.out.println(facade.findByID(3).toString());
        System.out.println("______________");
        System.out.println(facade.findByLastName("Nilsson"));
        System.out.println("_______________");
        System.out.println(facade.getNumberOfCustomers());
        System.out.println("_______________");
        System.out.println(facade.allCustomers().toString());
        System.out.println("_______________");
        System.out.println(facade.addCustomer("Simone", "Nielsen"));
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer where customer.lastName=:lastname", Customer.class);
            return query.setParameter("lastname", name).getResultList();
        } finally {
            em.close();
        }
    }

    public int getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query
                    = em.createQuery("Select count(customer) from Customer customer");
            int customerCount = Integer.parseInt(query.getSingleResult().toString());
            return customerCount;
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(String fName, String lName) {
        Customer customer = new Customer();
        Customer customer1 = new Customer(fName, lName, customer.getCreated());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer1);
            em.getTransaction().commit();
            return customer1;
        } finally {
            em.close();
        }
    }

}
