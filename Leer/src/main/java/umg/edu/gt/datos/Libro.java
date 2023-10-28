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
@Table(name = "libro")
public class Libro implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "Año_publicacion")
    private String Año_publicacion;
    
    @Column(name = "editorial")
    private String editorial;
    
    @Column(name = "nombre_autor")
    private String nombre_autor;
    
    @Column(name = "estado_libro")
    private String estado_libro;

      public Libro(Long id, String nombre, String categoria, String Año_publicacion, String editorial, String nombre_autor
                    ,String estado_libro) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.Año_publicacion = Año_publicacion;
        this.editorial = editorial;
        this.nombre_autor = nombre_autor;
        this.estado_libro = estado_libro;
    }
    
    public Libro() {
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the Año_publicacion
     */
    public String getAño_publicacion() {
        return Año_publicacion;
    }

    /**
     * @param Año_publicacion the Año_publicacion to set
     */
    public void setAño_publicacion(String Año_publicacion) {
        this.Año_publicacion = Año_publicacion;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the nombre_autor
     */
    public String getNombre_autor() {
        return nombre_autor;
    }

    /**
     * @param nombre_autor the nombre_autor to set
     */
    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    /**
     * @return the estado_libro
     */
    public String getEstado_libro() {
        return estado_libro;
    }

    /**
     * @param estado_libro the estado_libro to set
     */
    public void setEstado_libro(String estado_libro) {
        this.estado_libro = estado_libro;
    }
    
   
   
}
