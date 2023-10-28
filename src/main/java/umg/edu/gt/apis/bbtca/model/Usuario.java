package umg.edu.gt.apis.bbtca.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author enneasr
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Fecha_Nacimiento")
    private String fechaNacimiento;
    
    @Column(name = "Grado_Academico")
    private String gradoAcademico;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "Estado")
    private String estado;
    
    @Column(name = "Usuario")
    private String usuario;
    
    @Column(name = "Contraseña")
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String fechaNacimiento, String gradoAcademico, String direccion, String estado, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.gradoAcademico = gradoAcademico;
        this.direccion = direccion;
        this.estado = estado;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the gradoAcademico
     */
    public String getGradoAcademico() {
        return gradoAcademico;
    }

    /**
     * @param gradoAcademico the gradoAcademico to set
     */
    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", gradoAcademico=" + gradoAcademico + ", direccion=" + direccion + ", estado=" + estado + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    
    
}
