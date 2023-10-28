/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package umg.edu.gt.leer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import umg.edu.gt.datos.Alquiler;
import umg.edu.gt.datos.Libro;
import umg.edu.gt.datos.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import org.hibernate.cfg.Configuration;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

//http://localhost:8080/Leer/webresources/leer/primerWS/
//http://localhost:8080/Leer/webresources/leer/consultarUsuario/

/**
 * REST Web Service
 *
 * @author Wilmer de Mata
 */

@Path("leer")
public class Leer {

    @Context
    private UriInfo context;

    public Leer() {
    }
    @GET
    @Path("primerWS")
    @Produces({"text/plain"})
    @Consumes({"text/plain"})
    public String primerWS() {
        //TODO return proper representation object
        return "Mi primer API WS";
    }

    @Path("pruebaWSParametrosJson")
    @GET
    @Consumes({"text/plain"})
    @Produces({"text/plain"})
    public String pruebaWSParametrosJson(@QueryParam("Nombre") String pNombre, @QueryParam("Apellido") String pApellido) {
        JsonObject jo = new JsonObject();
        jo.addProperty("Nombre", pNombre);
        jo.addProperty("Apellido", pApellido);
        System.out.println("el objeto json es: " + jo.toString());

        return jo.toString();
    }
    
   
    @Path("consultarUsuario")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarUsuario() {
        
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        String json = null;

        try {
            Query query = session.createQuery("from usuarios");
            List<Usuarios> usuarios = query.list();

            session.close();

            json = gson.toJson(usuarios);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar usuarios " + e.getStackTrace());
            return "Error al consultar usuarios";
        }
        return json.toString();
    }
    
    @Path("consultarLibros")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarLibros() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libro.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        String json = null;

        try {
            Query query = session.createQuery("from libro");

            List<Usuarios> usuarios = query.list();

            session.close();

            json = gson.toJson(usuarios);

        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Error HB al consultar libros " + e.getStackTrace());
            return "Error al consultar libros";
        }
        return json.toString();
    }
    
     @Path("consultarAlquiler")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarAlquiler() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alquiler.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        String json = null;

        try {
            Query query = session.createQuery("from alquiler_libros");

            List<Usuarios> usuarios = query.list();

            session.close();

            json = gson.toJson(usuarios);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar alquiler_libros " + e.getStackTrace());
            return "Error al consultar alquiler_libros";
        }
        return json.toString();
    }
}
