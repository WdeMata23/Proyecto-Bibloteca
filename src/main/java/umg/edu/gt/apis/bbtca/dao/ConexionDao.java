package umg.edu.gt.apis.bbtca.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author enneasr
 */
public class ConexionDao {
    
    private String url;
    private String usuario;
    private String contraseña;
    
    public void credenciales(){
        Properties prop = new Properties();
        try{
            File configDirec = new File(System.getProperty("catalina.base"));
            File configFile = new File(configDirec, "umg-bbtca-filesystem.properties");
            InputStream stream = new FileInputStream(configFile);
            prop.load(stream);
            
            setUrl(prop.getProperty("url"));
            setUsuario(prop.getProperty("usuario"));
            setContraseña(prop.getProperty("clave"));
        } catch(Exception e){
                System.out.println("error al obtener las credenciales de base de datos " + e);
                        
        }
    }
    
    public Connection conexionMysql() throws Exception{
           this.credenciales();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conexion = DriverManager.getConnection(getUrl(), getUsuario(), getContraseña());
           System.out.println("la conexion es exitosa: " + conexion);
           return conexion;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
