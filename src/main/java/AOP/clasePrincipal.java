package AOP;

import AOP.DAO.clienteDAO;
import AOP.DAO.clienteVIPDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class clasePrincipal {
    public static void main(String[] args) {
        //Leer config spring
        AnnotationConfigApplicationContext contexto=new AnnotationConfigApplicationContext(configuracion.class);
        //Obtener bean spring
        clienteDAO elCliente=contexto.getBean("clienteDAO",clienteDAO.class);
        clienteVIPDAO elClienteVIP=contexto.getBean("clienteVIPDAO",clienteVIPDAO.class);
        Cliente cl1=new Cliente();
        //llamar al bean
        elCliente.insertaCliente(cl1,"Normal"); //nombre metodo que debe coincidir con before
        elCliente.setCodigoClienteNormal("123123");
        elCliente.setValoracionClienteNormal("positiva");
        String codigoNormal=elCliente.getCodigoClienteNormal();
        String valoracionNormal=elCliente.getValoracionClienteNormal();
        elClienteVIP.insertaClienteVIP();
        //cerrar contexto
        contexto.close();
    }
}
