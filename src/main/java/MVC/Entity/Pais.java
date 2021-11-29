package MVC.Entity;

import javax.persistence.*;

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
    private int codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "gentilicio")
    private String gentilicio;
    @Column(name = "ISO")
    private String ISO;

}
