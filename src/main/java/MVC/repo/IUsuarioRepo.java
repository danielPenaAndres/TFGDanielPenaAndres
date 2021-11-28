package MVC.repo;

import MVC.Entity.Paciente;
import MVC.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByDNI(String DNI);
}
