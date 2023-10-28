/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import umg.edu.gt.datos.Libro;
import umg.edu.gt.datos.Usuarios;
/**
 *
 * @author Wilmer de Mata
 */
public class Actualizar {
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
    
        @PUT
    @Path("actualizarEstudiante")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String actualizarUsuario(Usuarios usuario){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
       try {
           transaction = session.beginTransaction();
            Usuarios user = session.get(Usuarios.class, usuario.getUsuario());
            
            user.setNombre(usuario.getNombre());
            user.setFecha_Nacimiento(usuario.getFecha_Nacimiento());
            user.setGrado_Academico(usuario.getGrado_Academico());
            user.setDireccion(usuario.getDireccion());
            user.setEstado(usuario.getEstado());
            user.setUsuario(usuario.getUsuario());
            user.setContraseña(usuario.getContraseña());
            
            session.update(user);
            transaction.commit();
            return "usuario Actualizado";
           
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar";
        }
       finally{
           session.close();
       }
    }
    
    @PUT
    @Path("actualizarLibro")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String actualizarLibro(Libro libro){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libro.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
       try {
           transaction = session.beginTransaction();
            Libro libr = session.get(Libro.class, libro.getNombre());
  
            libr.setNombre(libro.getNombre());
            libr.setCategoria(libro.getCategoria());
            libr.setAño_publicacion(libro.getAño_publicacion());
            libr.setEditorial(libro.getEditorial());
            libr.setNombre_autor(libro.getNombre_autor());

            
            session.update(libr);
            transaction.commit();
            return "libro Actualizado";
           
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar";
        }
       finally{
           session.close();
       }
    }
    
}
