package MVC.repo;


import MVC.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaisRepo extends JpaRepository<Pais,String> {

    @Query("SELECT DISTINCT p.descripcion from Pais p")
    List<String> findAllPaises();
}
