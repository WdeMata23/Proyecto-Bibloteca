/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.datos;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Wilmer de Mata
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Fecha_Nacimiento")
    private String Fecha_Nacimiento;
    @Column(name = "Grado_Academico")
    private String Grado_Academico;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "Estado")
    private String Estado;
    @Column(name = "Usuario")
    private String Usuario;
    @Column(name = "Contraseña")
    private String Contraseña;
    
      public Usuarios(Long id, String Nombre, String Fecha_Nacimiento, String Grado_Academico, String direccion, String Estado
                    ,String Usuario, String Contraseña ) {
        this.id = id;
        this.Nombre = Nombre;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Grado_Academico = Grado_Academico;
        this.direccion = direccion;
        this.Estado = Estado;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }
      
          public Usuarios( ) {
    }
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Fecha_Nacimiento
     */
    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    /**
     * @param Fecha_Nacimiento the Fecha_Nacimiento to set
     */
    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    /**
     * @return the Grado_Academico
     */
    public String getGrado_Academico() {
        return Grado_Academico;
    }

    /**
     * @param Grado_Academico the Grado_Academico to set
     */
    public void setGrado_Academico(String Grado_Academico) {
        this.Grado_Academico = Grado_Academico;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Contraseña
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * @param Contraseña the Contraseña to set
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    

    
}
