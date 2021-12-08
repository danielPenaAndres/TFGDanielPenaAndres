package MVC.repo;

import MVC.Entity.Paciente;
import MVC.Entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByDNI(String DNI);

    @Query("SELECT p from Usuario p WHERE p.DNI LIKE %?1%")
    List<Usuario> findAll(String DNI);

    @Query("SELECT p from Usuario p WHERE p.DNI LIKE %?1%")
    Page<Usuario> findAll(String DNI, Pageable pageable);

    @Query("SELECT DISTINCT concat(p.DNI, ' ' ,p.nombre,' ',p.apellidos) from Usuario p where p.tipo='MEDICO'")
    List<String> findAllMedicos();
}
