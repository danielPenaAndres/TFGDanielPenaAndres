package MVC.repo;

import MVC.Entity.Cita;
import MVC.Entity.Paciente;
import MVC.Entity.Pais;
import MVC.Entity.Prestacion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrestacionRepo extends JpaRepository<Prestacion, String> {
    @Query("SELECT DISTINCT CONCAT(p.idPrestacion,' ',p.descripcion,' ',p.servicio) from Prestacion p")
    List<String> findAllPrestaciones();
}
