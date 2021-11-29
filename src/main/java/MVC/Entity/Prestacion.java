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

}
