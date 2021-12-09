package MVC.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pais")
public class Pais {
    public Pais() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGentilicio() {
        return gentilicio;
    }

    public void setGentilicio(String gentilicio) {
        this.gentilicio = gentilicio;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }


    @Override
    public String toString() {
        return "Pais{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", gentilicio='" + gentilicio + '\'' +
                ", ISO='" + ISO + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    @NotNull
    @NotEmpty
    private int codigo;
    @Column(name = "descripcion")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String descripcion;
    @Column(name = "gentilicio")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String gentilicio;
    @Column(name = "ISO")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String ISO;



}
