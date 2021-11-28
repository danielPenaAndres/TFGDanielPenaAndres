package MVC.repo;

import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT p from Episodio p WHERE p.servicio LIKE %?1%")
    List<Episodio> findAll(String servicio);

    @Query("SELECT p from Episodio p WHERE p.servicio  LIKE %?1%")
    Page<Episodio> findAll(String servicio, Pageable pageable);


}
