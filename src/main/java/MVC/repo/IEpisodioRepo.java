package MVC.repo;

import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IEpisodioRepo extends JpaRepository<Episodio, Integer> {
    List<Episodio> findByid(Cliente id, Sort sort);


    List<Episodio> findAllByid_Id(int id);

   /* @Query("select p from Episodio p where p.paciente = ?1")
    List<Episodio>findAllByPaciente(int id);*/

}
