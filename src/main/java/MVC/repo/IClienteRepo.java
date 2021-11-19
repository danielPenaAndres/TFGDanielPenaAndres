package MVC.repo;

import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAllByDNI(String id);
}
