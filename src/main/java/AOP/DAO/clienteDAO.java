package AOP.DAO;

import AOP.paciente;
import org.springframework.stereotype.Component;

@Component
public class pacienteDAO {
    public void insertapaciente(paciente elpaciente, String tipo){
        System.out.println("paciente Insertado con exito");

    }

    public String getValoracionpacienteNormal() {
        System.out.println("Obteniendo valoracion del paciente");
        return valoracionpacienteNormal;
    }

    public void setValoracionpacienteNormal(String valoracionpacienteNormal) {
        System.out.println("Estableciendo valoracion del paciente");
        this.valoracionpacienteNormal = valoracionpacienteNormal;
    }

    public String getCodigopacienteNormal() {
        System.out.println("Obteniendo codigo del paciente");
        return codigopacienteNormal;
    }

    public void setCodigopacienteNormal(String codigopacienteNormal) {
        System.out.println("Estableciendo codigo del paciente");
        this.codigopacienteNormal = codigopacienteNormal;
    }

    private String valoracionpacienteNormal;
    private String codigopacienteNormal;
}
