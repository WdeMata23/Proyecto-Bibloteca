/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.leer;

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
import umg.edu.gt.datos.Alquiler;
import umg.edu.gt.datos.Libro;
import umg.edu.gt.datos.Usuarios;
/**
 *
 * @author Wilmer de Mata
 */
@Path("/insertar")
public class Insertar {
    
        @Context
    private UriInfo context;
        
        public Insertar() {
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
        
    @Path("ingresarUsuario")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarEstudiante(Usuarios usuario) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            //Usuarios user = new Usuarios(usuario.getId(), usuario.getNombre(), usuario.getFecha_Nacimiento(), usuario.getFecha_Nacimiento(), usuario.getGrado_Academico(), usuario.getDireccion(), usuario.getEstado() , usuario.getUsuario(), usuario.getContraseña());
            Usuarios user = new Usuarios(usuario.getId(), usuario.getNombre(), usuario.getFecha_Nacimiento(), usuario.getGrado_Academico(), usuario.getDireccion(), usuario.getEstado(), usuario.getUsuario(), usuario.getContraseña());
            session.beginTransaction();
            //session.save(client);
            session.persist(user);

            session.getTransaction().commit();

            session.close();

            return "Usuario creado";
        } catch (PersistenceException e) {
            e.printStackTrace();
            return "error al registrar usuario: " + e.getStackTrace();
        }

    }
    
        @Path("ingresarLibro")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarLibro(Libro libro) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            //Usuarios user = new Usuarios(usuario.getId(), usuario.getNombre(), usuario.getFecha_Nacimiento(), usuario.getFecha_Nacimiento(), usuario.getGrado_Academico(), usuario.getDireccion(), usuario.getEstado() , usuario.getUsuario(), usuario.getContraseña());
            Libro lbr = new Libro(libro.getId(), libro.getNombre(), libro.getCategoria(), libro.getEditorial(), libro.getAño_publicacion(), libro.getEstado_libro(), libro.getNombre_autor());
            session.beginTransaction();
            //session.save(client);
            session.persist(lbr);

            session.getTransaction().commit();

            session.close();

            return "Libro creado";
        } catch (PersistenceException e) {
            e.printStackTrace();
            return "error al registrar Libro: " + e.getStackTrace();
        }

    }
    
    
    
}
