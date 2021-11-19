package MVC.repo;

import MVC.Entity.Cita;
import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitaRepo extends JpaRepository<Cita, Integer> {
    List<Cita> findByid(Cliente id, Sort sort);


    List<Cita> findAllByid_Id(int id);

   /* @Query("select p from Episodio p where p.paciente = ?1")
    List<Episodio>findAllByPaciente(int id);*/

}
