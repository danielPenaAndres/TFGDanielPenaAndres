package MVC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="diagnostico")
public class Diagnostico {
    public Diagnostico() {
    }
    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "idDiagnostico=" + idDiagnostico +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Id
    @Column(name = "idDiagnostico")
    @NotNull
    @NotEmpty
    private int idDiagnostico;
    @Column(name = "descripcion")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String descripcion;
}
