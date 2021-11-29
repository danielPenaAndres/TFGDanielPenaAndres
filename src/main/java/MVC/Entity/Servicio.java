package MVC.Entity;

import javax.persistence.*;

@Entity
@Table(name="servicio")
public class Servicio {
    public Servicio() {
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio='" + idServicio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Id
    @Column(name = "idServicio")
    private String idServicio;
    @Column(name = "descripcion")
    private String descripcion;

}
