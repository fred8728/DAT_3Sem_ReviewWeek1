package rest.service;

import com.google.gson.Gson;
import dto.customerDTO;
import entities.BankCustomer;
import facades.BankCustomerFacade;
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


@Path("bankcustomer")
public class BankCustomerResource {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static BankCustomerFacade facade = BankCustomerFacade.getBankCustomerFacade(emf);
    private static Gson gson = new Gson();

    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }
    
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeById(@PathParam ("id") int id) {
        customerDTO customer = facade.getCustomerByID(id);
        return gson.toJson(customer);
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllBankCustomers() {
        List<BankCustomer>  customer = facade.getAllBankCustomers();
        return gson.toJson(customer);
        
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(BankCustomer entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
