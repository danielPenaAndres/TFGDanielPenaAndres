package MVC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull
    @NotEmpty
    private String idPrestacion;
    @Column(name = "descripcion")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String descripcion;
    @Column(name = "servicio")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String servicio;
}
