package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="episodio")
public class Episodio {
    public Episodio() {
    }

    public Integer getCodEpisodio() {
        return codEpisodio;
    }

    public void setCodEpisodio(Integer codEpisodio) {
        this.codEpisodio = codEpisodio;
    }

    public Paciente getId() {
        return id;
    }

    public void setId(Paciente id) {
        this.id = id;
    }

    public Date getFechaInicioDelEpisodio() {
        return fechaInicioDelEpisodio;
    }

    public void setFechaInicioDelEpisodio(Date fechaInicioDelEpisodio) {
        this.fechaInicioDelEpisodio = fechaInicioDelEpisodio;
    }

    public Date getFechaFinDelEpisodio() {
        return fechaFinDelEpisodio;
    }

    public void setFechaFinDelEpisodio(Date fechaFinDelEpisodio) {
        this.fechaFinDelEpisodio = fechaFinDelEpisodio;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "codEpisodio=" + codEpisodio +
                ", id=" + id +
                ", fechaInicioDelEpisodio=" + fechaInicioDelEpisodio +
                ", fechaFinDelEpisodio=" + fechaFinDelEpisodio +
                ", observaciones='" + observaciones + '\'' +
                ", servicio='" + servicio + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episodio_generator")
    @SequenceGenerator(name = "episodio_generator", sequenceName = "episodio_seq", allocationSize = 1)
    @Column(name = "codEpisodio")
    @NotNull
    private Integer codEpisodio;
    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull
    @NotEmpty
    private Paciente id;
    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInicioDelEpisodio")
    private Date fechaInicioDelEpisodio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaFinDelEpisodio")
    private Date fechaFinDelEpisodio;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    @Column(name = "servicio")
    private String servicio;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
}
