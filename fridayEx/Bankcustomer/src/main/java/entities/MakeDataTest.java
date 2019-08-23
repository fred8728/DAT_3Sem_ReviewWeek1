/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fskn
 */
public class MakeDataTest {
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
    }
   
}
