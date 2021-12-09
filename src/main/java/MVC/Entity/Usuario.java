package MVC.Entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "usuario")
@Entity
public class Usuario {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    @NotEmpty
    private int id;
    @Length(min = 2, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Column(name = "clave")
    private String clave;
    @Column(name = "nombre")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String nombre;
    @Column(name = "apellidos")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String apellidos;
    @Column(name = "DNI")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String DNI;
    @Column(name = "tipo")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String tipo;



}