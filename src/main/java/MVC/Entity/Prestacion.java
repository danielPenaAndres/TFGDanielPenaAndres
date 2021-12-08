package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="prestacion")
public class Prestacion {
    public Prestacion() {
    }
    public String getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(String idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Prestacion{" +
                "idPrestacion=" + idPrestacion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Id
    @Column(name = "idPrestacion")
    private String idPrestacion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "servicio")
    private String servicio;
}
