package MVC.repo;

import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import MVC.Entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAllByDNI(String id);

    @Query("SELECT p from Cliente p WHERE p.DNI LIKE %?1%")
    List<Cliente> findAll(String DNI);

    @Query("SELECT p from Cliente p WHERE p.DNI LIKE %?1%")
    Page<Cliente> findAll(String DNI,Pageable pageable);

    Cliente findByDNI(String DNI);


}
