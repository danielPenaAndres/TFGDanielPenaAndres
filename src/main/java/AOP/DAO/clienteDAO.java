package AOP.DAO;

import AOP.Cliente;
import org.springframework.stereotype.Component;

@Component
public class clienteDAO {
    public void insertaCliente(Cliente elCliente, String tipo){
        System.out.println("Cliente Insertado con exito");

    }

    public String getValoracionClienteNormal() {
        System.out.println("Obteniendo valoracion del Cliente");
        return valoracionClienteNormal;
    }

    public void setValoracionClienteNormal(String valoracionClienteNormal) {
        System.out.println("Estableciendo valoracion del Cliente");
        this.valoracionClienteNormal = valoracionClienteNormal;
    }

    public String getCodigoClienteNormal() {
        System.out.println("Obteniendo codigo del Cliente");
        return codigoClienteNormal;
    }

    public void setCodigoClienteNormal(String codigoClienteNormal) {
        System.out.println("Estableciendo codigo del Cliente");
        this.codigoClienteNormal = codigoClienteNormal;
    }

    private String valoracionClienteNormal;
    private String codigoClienteNormal;
}
