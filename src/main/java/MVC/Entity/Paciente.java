package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="paciente")
public class Paciente {
    public Paciente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Set<Episodio> episodios) {
        this.episodios = episodios;
    }

    public Set<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Set<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", sexo='" + sexo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "id",
            fetch=FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Episodio> episodios = new HashSet<>();
    @OneToMany(mappedBy = "id",
            fetch=FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Cita> citas = new HashSet<>();
    @Column(name = "nombre")
    @NotEmpty(message = "*Por favor escriba un usuario")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @NotEmpty(message = "*Por favor escriba un DNI")
    @Column(name = "DNI")
    private String DNI;
    @DateTimeFormat(pattern="dd.MM.yyyy")
    @Column(name = "fechaDeNacimiento")
    private String fechaDeNacimiento;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    @Column(name = "email")
    private String email;
}
