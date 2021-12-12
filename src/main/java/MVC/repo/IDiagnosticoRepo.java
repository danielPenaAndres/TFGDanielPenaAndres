package MVC.repo;

import MVC.Entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiagnosticoRepo extends JpaRepository<Diagnostico, String> {
    @Query("SELECT DISTINCT (p.descripcion) from Diagnostico p")
    List<String> findAllDiagnosticos();
}
