/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fskn
 */
@Path("animal")
public class AnimalResource {
    @Context
    private UriInfo context;
    private static Gson gson = new Gson();
    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }
    
    public List <Animal> animalList(){
        List <Animal> animal = new ArrayList();
        Animal dog = new Animal("Dog", 2019, "Bark");
        Animal pig = new Animal("Pig", 2001, "Oink");
        Animal giraf = new Animal("giraf", 2014, "Bark");
        Animal elephant = new Animal("elephant", 2011, "Oink");
        Animal lion = new Animal("lion", 2017, "Bark");
        Animal cat = new Animal("cat", 2000, "miav");
        animal.add(dog);
        animal.add(pig);
        animal.add(giraf);
        animal.add(elephant);
        animal.add(lion);
        animal.add(cat);
        
        return animal;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello from my first web service";
    }

    @Path("random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomAnimal() {
        Random rand = new Random();
        List <Animal> animals = animalList();
        Animal animal = animals.get(rand.nextInt(animals.size()));
        return gson.toJson(animal);
    }
    
    
    /**
     * PUT method for updating or creating an instance of AnimalResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
