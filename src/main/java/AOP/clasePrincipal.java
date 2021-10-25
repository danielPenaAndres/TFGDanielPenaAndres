package AOP;

import AOP.DAO.pacienteDAO;
import AOP.DAO.pacienteVIPDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class clasePrincipal {
    public static void main(String[] args) {
        //Leer config spring
        AnnotationConfigApplicationContext contexto=new AnnotationConfigApplicationContext(configuracion.class);
        //Obtener bean spring
        pacienteDAO elpaciente=contexto.getBean("pacienteDAO",pacienteDAO.class);
        pacienteVIPDAO elpacienteVIP=contexto.getBean("pacienteVIPDAO",pacienteVIPDAO.class);
        paciente cl1=new paciente();
        //llamar al bean
        elpaciente.insertapaciente(cl1,"Normal"); //nombre metodo que debe coincidir con before
        elpaciente.setCodigopacienteNormal("123123");
        elpaciente.setValoracionpacienteNormal("positiva");
        String codigoNormal=elpaciente.getCodigopacienteNormal();
        String valoracionNormal=elpaciente.getValoracionpacienteNormal();
        elpacienteVIP.insertapacienteVIP();
        //cerrar contexto
        contexto.close();
    }
}
