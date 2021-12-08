package MVC.repo;

import MVC.Entity.Cita;
import MVC.Entity.Paciente;
import MVC.Entity.Episodio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitaRepo extends JpaRepository<Cita, Integer> {
    List<Cita> findByid(Paciente id, Sort sort);

    @Query("SELECT p from Cita p WHERE p.medico LIKE %?1% and p.fechaDeCita>=current_date order by p.fechaDeCita asc ")
    List<Cita> findCitasMedico(String DNI);

    List<Cita> findAllByid_Id(int id);


    @Query(value = "SELECT u.id FROM Cita u WHERE u.cod_cita = ?1", nativeQuery = true)
    int findIdByCita(int idCita);

   /* @Query("select p from Episodio p where p.paciente = ?1")
    List<Episodio>findAllByPaciente(int id);*/

}
