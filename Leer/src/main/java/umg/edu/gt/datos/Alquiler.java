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
@Table(name = "alquiler_libros")
public class Alquiler implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "Usuario_id")
    private long Usuario_id;
    @Column(name = "Libro_id")
    private long Libro_id;
    @Column(name = "fecha_aquiler")
    private String fecha_aquiler;
    @Column(name = "fecha_entrega")    
    private String fecha_entrega;
    
     public Alquiler(Long id, Long Usuario_id, Long Libro_id, String fecha_aquiler, String fecha_entrega){
        this.id = id;
        this.Usuario_id = Usuario_id;
        this.Libro_id = Libro_id;
        this.fecha_aquiler = fecha_aquiler;
        this.fecha_entrega = fecha_entrega;
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
     * @return the Usuario_id
     */
    public long getUsuario_id() {
        return Usuario_id;
    }

    /**
     * @param Usuario_id the Usuario_id to set
     */
    public void setUsuario_id(long Usuario_id) {
        this.Usuario_id = Usuario_id;
    }

    /**
     * @return the Libro_id
     */
    public long getLibro_id() {
        return Libro_id;
    }

    /**
     * @param Libro_id the Libro_id to set
     */
    public void setLibro_id(long Libro_id) {
        this.Libro_id = Libro_id;
    }

    /**
     * @return the fecha_aquiler
     */
    public String getFecha_aquiler() {
        return fecha_aquiler;
    }

    /**
     * @param fecha_aquiler the fecha_aquiler to set
     */
    public void setFecha_aquiler(String fecha_aquiler) {
        this.fecha_aquiler = fecha_aquiler;
    }

    /**
     * @return the fecha_entrega
     */
    public String getFecha_entrega() {
        return fecha_entrega;
    }

    /**
     * @param fecha_entrega the fecha_entrega to set
     */
    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    


    
}
