package umg.edu.gt.apis.bbtca.controller;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import umg.edu.gt.apis.bbtca.model.Usuario;
import umg.edu.gt.apis.bbtca.service.UsuarioService;

/**
 * REST Web Service
 *
 * @author enneasr
 */
@Path("usuario")
public class UsuarioController {
    
    private UsuarioService usuarioService = new UsuarioService();

    @Context
    private UriInfo context;
    public UsuarioController() {
    }

    @GET
    @Path("listar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        System.out.println("Obteniendo lista de usuarios");
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        String json = null;
        try {
            Query query = session.createQuery("from Usuario");
            List<Usuario> usuarios = query.list();
            session.close();
            json = gson.toJson(usuarios);
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de usuarios" + e);
        }
        return json.toString();
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
//    
//     @POST
//     @Path("guardar")
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//    public void postJson(String content) {
//    }

    /**
     * @return the usuarioService
     */
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    /**
     * @param usuarioService the usuarioService to set
     */
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    
    
}
