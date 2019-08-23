/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.customerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;

    public BankCustomerFacade() {
    }

    
    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getBankCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BankCustomer bankCustomer1 = new BankCustomer("Frederikke", "Love", "4192", 10000000.0, 10,"Good customer - has a lot of money");
        BankCustomer bankCustomer2 = new BankCustomer("Karen", "Mouse", "4322", 50000000.6, 1,"Semi - we can trust her");
        BankCustomer bankCustomer3 = new BankCustomer("Rikke", "Sweety", "2192", 6000.90, 6,"Semi - we can trust her");
        BankCustomer bankCustomer4 = new BankCustomer("Kim", "Margrethe", "7122", 50.7, 10,"Good customer - has a lot of money");
        BankCustomer bankCustomer5 = new BankCustomer("Anders", "Lion", "7792", 6453.232, 3,"Bad - dont give her any money ");
        BankCustomer bankCustomer6 = new BankCustomer("Kitty", "Alen", "9892", 400002321.432, 7,"Nice - future we will get more money");
        BankCustomer bankCustomer7 = new BankCustomer("Hans", "Nielsen", "8292", 999999.9999, 4,"Getting better - dont give her money");
        
        try {
            em.getTransaction().begin();
            em.persist(bankCustomer1);
            em.persist(bankCustomer2);
            em.persist(bankCustomer3);
            em.persist(bankCustomer4);
            em.persist(bankCustomer5);
            em.persist(bankCustomer6);
            em.persist(bankCustomer7);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
        BankCustomerFacade facade = BankCustomerFacade.getBankCustomerFacade(emf);
        
        System.out.println(facade.getCustomerByID(4).toString());
        System.out.println("______________");
        System.out.println(facade.getCustomerByName("Rikke").toString());
        System.out.println("_______________");
        System.out.println(facade.getAllBankCustomers().toString());
        System.out.println("_______________");
        BankCustomer bc = new BankCustomer("Simone", "Sej", "2222", 1999999999999.999, 10, "super Rich");
        System.out.println(facade.addCustomer(bc));
        System.out.println("_______________");
    }
    public customerDTO getCustomerByID(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            List <BankCustomer> list =em.createQuery("Select b from BankCustomer b").getResultList();
            customerDTO customer = new customerDTO(list.get(id-1));
            
            return customer;
        }finally{
            em.close();
        }
    }

    public List<customerDTO> getCustomerByName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <customerDTO> query =
                    em.createQuery("Select customer from BankCustomer customer where customer.firstName =:firstname", customerDTO.class);
            return query.setParameter("firstname", name).getResultList();
        } finally{
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query
                    = em.createQuery("Select customer from BankCustomer customer", customerDTO.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
