package umg.edu.gt.apis.bbtca.service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import umg.edu.gt.apis.bbtca.dao.ConexionDao;
import umg.edu.gt.apis.bbtca.model.Usuario;

/**
 *
 * @author enneasr
 */
public class UsuarioService {
    
    ConexionDao con = new ConexionDao();
    
    public List<Usuario> findAllUsuarios(){
        List<Usuario> lista = new ArrayList<>();        
        try{
            String query="SELECT id, nombre, fechaNacimiento,gradoAcademico, direccion, estado, usuario, contraseña FROM usuarios";
            Statement st = con.conexionMysql().createStatement();
            ResultSet rs = st.executeQuery(query);            
            while(rs.next()){
                Usuario dato = new Usuario();
                dato.setId(rs.getInt("id"));
                dato.setNombre(rs.getString("nombre"));
                dato.setFechaNacimiento(rs.getString("fechaNacimiento"));
                dato.setGradoAcademico(rs.getString("gradoAcademico"));
                dato.setDireccion(rs.getString("direccion"));               
                dato.setEstado(rs.getString("estado"));
                dato.setUsuario(rs.getString("usuario"));
                dato.setContraseña(rs.getString("contraseña"));
                lista.add(dato);
            }          
        }catch(Exception e){
            System.out.println("Error al realizar la consulta");
        }
        return lista;
    }
    
    
}
