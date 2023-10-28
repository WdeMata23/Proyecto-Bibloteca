package umg.edu.gt.apis.bbtca;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.Application;

/**
 *
 * @author enneasr
 */
@javax.ws.rs.ApplicationPath("api/v1")
public class ApplicationConfig extends Application{
    
   @Override
   public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    } 
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(umg.edu.gt.apis.bbtca.controller.UsuarioController.class);
    }
    
}
