package MVC.repo;

import MVC.Entity.Cita;
import MVC.Entity.Paciente;
import MVC.Entity.Pais;
import MVC.Entity.Servicio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServicioRepo extends JpaRepository<Servicio, String> {
    @Query("SELECT DISTINCT concat(p.idServicio, ' ' ,p.descripcion) from Servicio p")
    List<String> findAllServicios();

}
