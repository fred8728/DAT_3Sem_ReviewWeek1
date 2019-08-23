package rest.service;

import com.google.gson.Gson;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employee")
public class EmployeeResources {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
    private static Gson gson = new Gson();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllEmployees() {
        List<Employee> employee = facade.getAllEmployees();
        return gson.toJson(employee);
        
    }
    
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeById(@PathParam ("id") int id) {
        Employee employee = facade.getEmployeeById(id);
        return gson.toJson(employee);
    }
    
    @Path("highestpaid")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getHighestPaid() {
        int highestSalary = facade.getEmployeesWithHighestSalary();
        return gson.toJson(highestSalary);
    }
    
    @Path("name/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeByName(@PathParam ("name") String name) {
        List <Employee> employee = facade.getEmployeesByName(name);
        return gson.toJson(employee);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Employee entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
