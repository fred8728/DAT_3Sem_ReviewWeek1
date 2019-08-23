/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    private EmployeeFacade(){
        
    }
    
    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Employee employee = new Employee("Frederikke", "Mosebakken 533", 50040);
        Employee employee1 = new Employee("Kisser", "Mosebakken 543", 51060);
        Employee employee2 = new Employee("Rikke", "Mosebakken 563", 55300);
        Employee employee3 = new Employee("Malene", "Mosebakken 583", 53000);
        Employee employee4 = new Employee("Maiken", "Mosebakken 58", 50030);
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.persist(employee1);
            em.persist(employee2);
            em.persist(employee3);
            em.persist(employee4);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
        //CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        System.out.println(facade.getEmployeeById(3).toString());
        System.out.println("______________");
        System.out.println(facade.getEmployeesByName("Frederikke Nilsson"));
        System.out.println("_______________");
        System.out.println(facade.getAllEmployees());
        System.out.println("_______________");
        System.out.println(facade.getEmployeesWithHighestSalary());
        System.out.println("_______________");
        System.out.println(facade.createEmployee("Katja Hansen", "Bækmosen 2", 100000));
    }
    
    public Employee getEmployeeById(long id) {
        EntityManager em = emf.createEntityManager();
        try{
            Employee employee = em.find(Employee.class, id);
            return employee;
        } finally{
            em.close();
        }
    }

    public List<Employee> getEmployeesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <Employee> query = 
                    em.createQuery("Select e from Employee e where e.name =:name",Employee.class);
            return query.setParameter("name",name).getResultList();
        } finally{
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <Employee> query =
                    em.createQuery("Select e from Employee e", Employee.class);
            return query.getResultList();
        } finally{
            em.close();
        }
    }

    public int getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try{
            Query query =
                    em.createQuery("Select max(e.salary) from Employee e");
            int higestSalary = Integer.parseInt(query.getSingleResult().toString());
            return higestSalary;
        } finally{
            em.close();
        }
    }

    public Employee createEmployee(String name, String address, int salary) {
        EntityManager em = emf.createEntityManager();
        Employee employee = new Employee(name, address, salary);
        try{
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally{
            em.close();
        }
    }

}
