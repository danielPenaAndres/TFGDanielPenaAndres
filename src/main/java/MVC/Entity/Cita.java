package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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

    public Paciente getId() {
        return id;
    }

    public void setId(Paciente id) {
        this.id = id;
    }

    public Date getFechaDeCita() {
        return fechaDeCita;
    }

    public void setFechaDeCita(Date fechaDeCita) {
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

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
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
    @NotNull
    @NotEmpty
    private Integer codCita;
    @ManyToOne
    @JoinColumn(name = "id")
    private Paciente id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaDeCita")
    @NotNull
    @NotEmpty
    private Date fechaDeCita;

    @Column(name = "observaciones")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String observaciones;
    @Column(name = "servicio")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String servicio;
    @Column(name = "prestacion")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String prestacion;
    @Column(name = "medico")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String medico;
}
