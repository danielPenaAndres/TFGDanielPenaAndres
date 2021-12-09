package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  DNI + " " + nombre +" " + apellidos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    @NotEmpty
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
    @NotNull
    @Size(min = 1, max = 100)
    @NotEmpty(message = "*Por favor escriba un usuario")
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "apellidos")
    private String apellidos;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 15)
    @NotEmpty(message = "*Por favor escriba un DNI")
    @Column(name = "DNI")
    private String DNI;
    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 15)
    @Column(name = "sexo")
    private String sexo;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    @Column(name = "pais")
    private String pais;
    @Email(message = "*Introduzca un email valido")
    @NotEmpty(message = "*Introduzca un email valido")
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;

}
