
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Marcos
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
   
    private Long documento;
    
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;

    public Cliente(String nombre, String apellido, String domicilio, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
    
    
    
}
