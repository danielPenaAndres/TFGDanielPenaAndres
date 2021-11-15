package MVC.repo;

import MVC.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {
}
