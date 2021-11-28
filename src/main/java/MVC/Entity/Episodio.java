package MVC.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;

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

    public String getFechaDelEpisodio() {
        return fechaDelEpisodio;
    }

    public void setFechaDelEpisodio(String fechaDelEpisodio) {
        this.fechaDelEpisodio = fechaDelEpisodio;
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

    @Override
    public String toString() {
        return "Episodio{" +
                "codigo=" + codEpisodio +
                ", paciente='" + id + '\'' +
                ", fechaDeNacimiento='" + fechaDelEpisodio + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", servicio='" + servicio + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codEpisodio")
    private Integer codEpisodio;
    @ManyToOne
    @JoinColumn(name = "id")
    private Paciente id;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "fechaDelEpisodio")
    private String fechaDelEpisodio;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "servicio")
    private String servicio;
}
