package MVC.DAO;

import MVC.Entity.paciente;

import java.util.List;

public interface pacienteDAO {
    public void insertarpacientes(paciente elpaciente);

    public List<paciente> getpacientes();


    public paciente getpaciente(long id);

    public void eliminarpaciente(long id);
}
