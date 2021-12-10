package MVC.repo;

import MVC.Entity.Prestacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrestacionRepo extends JpaRepository<Prestacion, String> {
    @Query("SELECT DISTINCT CONCAT(p.descripcion,'  ',p.idPrestacion,'  ',p.servicio) from Prestacion p")
    List<String> findAllPrestaciones();
}
