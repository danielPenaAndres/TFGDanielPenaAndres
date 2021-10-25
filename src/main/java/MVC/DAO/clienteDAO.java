package MVC.DAO;

import MVC.Entity.Cliente;

import java.util.List;

public interface clienteDAO {
    public void insertarClientes(Cliente elCliente);

    public List<Cliente> getClientes();


    public Cliente getCliente(long id);

    public void eliminarCliente(long id);
}
