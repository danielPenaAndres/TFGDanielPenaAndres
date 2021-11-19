package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="cita")
public class Cita {
    public Cita() {
    }

    public Integer getCodCita() {
        return codCita;
    }

    public void setCodCita(Integer codCita) {
        this.codCita = codCita;
    }

    public Cliente getId() {
        return id;
    }

    public void setId(Cliente id) {
        this.id = id;
    }

    public String getFechaDeCita() {
        return fechaDeCita;
    }

    public void setFechaDeCita(String fechaDeCita) {
        this.fechaDeCita = fechaDeCita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(String prestacion) {
        this.prestacion = prestacion;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "codCita=" + codCita +
                ", id=" + id +
                ", fechaDeCita='" + fechaDeCita + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", servicio='" + servicio + '\'' +
                ", prestacion='" + prestacion + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codCita")
    private Integer codCita;
    @ManyToOne
    @JoinColumn(name = "id")
    private Cliente id;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "fechaDeCita")
    private String fechaDeCita;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "servicio")
    private String servicio;
    @Column(name = "prestacion")
    private String prestacion;
}
