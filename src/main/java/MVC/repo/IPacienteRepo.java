package MVC.repo;

import MVC.Entity.Paciente;
import MVC.Entity.Episodio;
import MVC.Entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

    List<Paciente> findAllByDNI(String id);

    @Query("SELECT p from Paciente p WHERE p.DNI LIKE %?1%")
    List<Paciente> findAll(String DNI);

    @Query("SELECT p from Paciente p WHERE p.DNI LIKE %?1%")
    Page<Paciente> findAll(String DNI,Pageable pageable);

    Paciente findByDNI(String DNI);


}
